package ru.geekbrains.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Server {

    private List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public Server() {
        ServerSocket server = null;
        Socket socket = null;
        try {

            server = new ServerSocket(8080);
            System.out.println("server start");

            while (true) {
                socket = server.accept();
                System.out.println("client connected");
                clients.add(new ClientHandler(this, socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void broadCast(String msg) {
        String firstStopWord = "</private:";
        String secondStopWord = "/>";
        int i = 0;
        for (ClientHandler handler : clients) {
            if (msg.contains(firstStopWord) && msg.contains(secondStopWord)) {
                int firstStopWordInt = msg.indexOf(firstStopWord);
                int secondStopWordInt = msg.indexOf(secondStopWord);
                if (firstStopWordInt < secondStopWordInt) {
                    String numberUser = msg.substring(firstStopWordInt + firstStopWord.length(), secondStopWordInt);
                    int intNumber = Integer.parseInt(numberUser);
                    if (i == intNumber) {
                        handler.sendMsg(msg);
                        break;
                    }
                }
            } else {
                handler.sendMsg(msg);
            }
            i++;
        }
    }
}
