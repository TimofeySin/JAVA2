package ru.geekbrains.Jawa2.Lesson6.client;

import ru.geekbrains.Jawa2.Lesson6.ClientHandler;

import java.io.IOException;
import java.net.Socket;


class Client {

    Client(String host, int port) {
        Socket socket;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ClientHandler clienthandler = new ClientHandler(socket);
        clienthandler.Handler();

    }
}
