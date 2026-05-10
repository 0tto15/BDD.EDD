package org.example.bdd.services;

import org.example.bdd.models.User;
import org.example.bdd.repositories.LoginRepository;

import java.io.IOException;

/**
 * A tener en cuenta:
 * El paquete de servicio (services) es el intermediario entre la ventana (screens) y el repositorio (repositories)
 * es, inclusive si no es necesario, es buena practica que exista esta relación entre ellos.
 */

public class UsersService {

    // Login sin usuario.
    public static void loginNotUser (String username, String contrasena) throws Exception {
        if (username.isBlank() || contrasena.isBlank()) {
            throw new Exception("Todos los campos deben estar llenos.");
        }
        LoginRepository.loginNotUser(username, contrasena);
    }
    // Login con usuario.
    public static User loginUser (String username, String contrasena) throws Exception {
        if (username.isBlank() || contrasena.isBlank()) {
            throw new Exception("Todos los campos deben estar llenos.");
        }
        return LoginRepository.loginUser(username, contrasena);
    }
}
