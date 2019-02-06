package ru.geekbrains.Jawa2.Lesson7.server.api;

import ru.geekbrains.Jawa2.Lesson7.server.model.Client;

public interface AuthService {
    Client authenticate(String login, String pass);
}
