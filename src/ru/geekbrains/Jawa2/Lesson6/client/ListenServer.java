package ru.geekbrains.Jawa2.Lesson6.client;

import ru.geekbrains.Jawa2.Lesson6.Listen;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


class ListenServer extends Listen {
    private PrintWriter printWriter;
    private Scanner scannerServer;

    ListenServer(Socket socket) {
        try {
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.scannerServer = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void run() {
        runListen();
    }

    private void runListen() {
        String lineFromServer = "";
        while (true) {
            try {
                if (isKill()) {
                    close();
                    break;
                } else {
                    if (System.in.available() > 0) {
                        lineFromServer = scannerServer.nextLine();
                        if (!lineFromServer.equals("/exit")) {
                            printWriter.println(lineFromServer);
                        } else {
                            setKill(true);
                            close();
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                setKill(true);
                close();
                break;
            }
        }

    }

    private void close() {
        printWriter.close();

    }

}
