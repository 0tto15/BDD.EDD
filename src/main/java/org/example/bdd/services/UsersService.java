package org.example.bdd.services;

import org.example.bdd.models.User;
import org.example.bdd.repositories.LoginRepository;
import java.sql.SQLException;

public class UsersService {

    public UsersService() {
        throw new IllegalStateException("Utility class");
    }

    public static User loginUser (String username, String contrasena) throws SQLException {
        if (username == null || username.isBlank() || contrasena == null || contrasena.isBlank()) {
            throw new IllegalArgumentException("Campos vacíos");
        }
        return LoginRepository.loginUser(username, contrasena);
    }
}
