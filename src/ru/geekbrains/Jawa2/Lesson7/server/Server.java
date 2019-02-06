package ru.geekbrains.Jawa2.Lesson7.server;

import ru.geekbrains.Jawa2.Lesson7.server.impl.CsvAuthService;
import ru.geekbrains.Jawa2.Lesson7.server.task.AuthenticationTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

    private List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    Server() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("server start");

            while (true) {
                socket = server.accept();
                System.out.println("client connected");
                new AuthenticationTask(socket, this, new CsvAuthService()).start();
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

    void broadCast(String nick, String msg, String privNick) {
        for (ClientHandler handler : clients) {
            String message = getMessage(nick, msg, handler.getClient().getNick(), privNick);
            if (!message.isEmpty()) handler.sendMsg(message);
        }
    }

    private String getMessage(String nick, String msg, String nickForSend, String privNick) {
        String message = "";
        if (!privNick.isEmpty()) {
            if (privNick.equals(nickForSend))  message = nick + " send private: " + msg;
            else if (nick.equals(nickForSend)) message = "Me send private to "+nickForSend+": " + msg;
        } else {
            if (nick.equals(nickForSend)) message = "Me: " + msg;
            else message = nick + ": " + msg;
        }
        return message;
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }
}
