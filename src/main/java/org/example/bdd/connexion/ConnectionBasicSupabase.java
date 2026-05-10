package org.example.bdd.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esto es un ejemplo de una conexión básica usando supaBase.
 * A tener en cuenta:
 * A veces vas a tener que agregar el en module info  el requieres java.sql
 * y agregar la dependencia de MySql en el pom.
 */
public class ConnectionBasicSupabase {
    private static final String URL = "jdbc:postgresql://db.erngodjaxfwybscotiqz.supabase.co:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "dnnel122002."; // Contraseña que se creó en la base de datos.

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
