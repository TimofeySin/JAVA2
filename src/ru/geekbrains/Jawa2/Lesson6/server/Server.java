package ru.geekbrains.Jawa2.Lesson6.server;

import ru.geekbrains.Jawa2.Lesson6.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    private static final int PORT = 8080;
    Server() {
        ServerSocket server = null;
        Socket socket = null;
        ClientHandler clienthandler = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("server start");
            socket = server.accept();
            System.out.println("client connected");
            clienthandler = new ClientHandler(socket);
            clienthandler.Handler();
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
}
