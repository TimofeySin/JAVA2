package ru.geekbrains.Jawa2.Lesson6.client;

import ru.geekbrains.Jawa2.Lesson6.ListenClient;
import ru.geekbrains.Jawa2.Lesson6.ListenServer;

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

        ListenClient treadClient = new ListenClient(socket);
        ListenServer treadServer = new ListenServer(socket);

        treadClient.setDaemon(true);
        treadServer.setDaemon(true);

        treadServer.start();
        treadClient.start();
        do {
            if (treadClient.isKill()) {
                treadServer.setKill(true);
            }
            if (treadServer.isKill()) {
                treadClient.setKill(true);
            }

        } while (!treadClient.isKill() && !treadServer.isKill());

    }
}
