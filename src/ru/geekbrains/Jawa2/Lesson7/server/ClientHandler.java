package ru.geekbrains.Jawa2.Lesson7.server;

import ru.geekbrains.Jawa2.Lesson7.server.api.AuthService;
import ru.geekbrains.Jawa2.Lesson7.server.model.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Client client;

    public ClientHandler(Server server, Socket socket, Client client) {
        this.server = server;
        this.socket = socket;
        this.client = client;

        this.in = null;
        this.out = null;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String line = in.readUTF();
                        System.out.print("from " + client.getNick() + line);
                        server.broadCast(client.getNick() + ": " + line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    server.unsubscribe(this);
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
