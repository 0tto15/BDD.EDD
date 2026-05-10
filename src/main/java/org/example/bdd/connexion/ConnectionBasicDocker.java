package org.example.bdd.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esto es un ejemplo de una conexión básica usando docker.
 * A tener en cuenta:
 * A veces vas a tener que agregar el en module info  el requieres java.sql
 * y agregar la dependencia de MySql en el pom.
 */

public class ConnectionBasicDocker {
    private final static String URL = "jdbc:mysql://localhost:3309/PelosBD?serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection connect() throws Exception {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException exception) {
                throw new Exception("Error en la conexion con la base de datos.\n" +
                        "Informacion del error: " + exception.getMessage());
            }
        }
        return connection;
    }
}
