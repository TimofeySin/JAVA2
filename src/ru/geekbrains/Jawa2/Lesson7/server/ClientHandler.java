package ru.geekbrains.Jawa2.Lesson7.server;


import ru.geekbrains.Jawa2.Lesson7.server.model.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientHandler {

    private Server server;
    private final String PRIVE_STRING = "/w";
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Client client;

    public ClientHandler(Server server, Socket socket, Client client) {
        this.client = client;
        this.server = server;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        startListen();
    }

    private void startListen(){
        new Thread(() -> {
            try {
                while (true) {
                    String line = in.readUTF();
                    System.out.print("from " + client.getNick() + line);
                    Map<String, String>  mapParseLine = parseLine(line);
                    server.broadCast(client.getNick(), mapParseLine.get("line"), mapParseLine.get("privNick"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                server.unsubscribe(this);
            }
        }).start();
    }

    private Map<String, String>  parseLine(String line) {
        Map<String, String> mapToReturn = new HashMap<>();
        if (line.startsWith(PRIVE_STRING)) {
            String[] strings = line.split(" ");
            mapToReturn.put("privNick",strings[1]);
            mapToReturn.put("line",Stream.of(strings).skip(2).collect(Collectors.joining(" ")));
        }else {
            mapToReturn.put("privNick","");
            mapToReturn.put("line",line);
        }
        return mapToReturn;
    }

    Client getClient() {
        return client;
    }

    void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
