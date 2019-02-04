package ru.geekbrains.Jawa2.Lesson6;

import ru.geekbrains.Jawa2.Lesson6.ListenClient;
import ru.geekbrains.Jawa2.Lesson6.ListenServer;

import java.net.Socket;

public class ClientHandler {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void Handler() {
        ListenServer treadServer = new ListenServer(socket);
        ListenClient treadClient = new ListenClient(socket);

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
