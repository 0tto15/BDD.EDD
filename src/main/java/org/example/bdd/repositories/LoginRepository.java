package org.example.bdd.repositories;

import org.example.bdd.connexion.ConnectionBasicSupabase;
import org.example.bdd.connexion.ConnectionPool;
import org.example.bdd.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {

    // Login sin usuario.
    public static void loginNotUser (String correo, String contrasena) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";

        try (
                Connection connection = ConnectionBasicSupabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1,correo);
            preparedStatement.setString(2,contrasena);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new Exception("Usuario/Contraseña no encontrados");
                }
            } catch (Exception exception) {
                throw new Exception("Error en la base de datos. \nInformación del error: " + exception.getMessage());
            }
        }
    }
    // Login con usuario.
    public static User loginUser(String correo, String contrasena) throws Exception{
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
        try (
                // Connection connection = ConnectionBasicDocker.connect(); // Conexión basica con docker.
                Connection connection = ConnectionBasicSupabase.getConnection(); // Conexión básica con supabase.
                // Connection connection = ConnectionPool.getDataSource().getConnection(); // Conexión pool.

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasena);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User usuario = new User(
                            resultSet.getInt("id_user"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellidos"),
                            resultSet.getString("correo"),
                            resultSet.getString("contrasena"),
                            resultSet.getString("rol")
                    );
                    resultSet.close();
                    return usuario;
                } else {
                    throw new Exception("Usuario/Contraseña no encontrados");
                }
            }
        } catch (Exception exception) {
            throw new Exception("Error en la conexión con la base de datos.\n Información del error: " + exception.getMessage());
        }
    }

}


