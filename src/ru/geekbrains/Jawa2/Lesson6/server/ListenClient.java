package ru.geekbrains.Jawa2.Lesson6.server;


import ru.geekbrains.Jawa2.Lesson6.Listen;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


class ListenClient extends Listen {

    private Scanner scannerClient;
    private Socket socket;

    ListenClient(Socket socket) {
        this.socket = socket;
        try {
            this.scannerClient = new Scanner(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runListen() {
        String lineFromClient = "";
        while (true) {
            try {
                if (isKill()) {
                    close();
                    break;
                } else {
                    if (socket.getInputStream().available() > 0) {
                        lineFromClient = scannerClient.nextLine();
                        System.out.println(lineFromClient);
                        if (lineFromClient.equals("/exit")) {
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
        close();
    }

    @Override
    public synchronized void run() {
        runListen();
    }

    private void close() {
        scannerClient.close();
    }
}
