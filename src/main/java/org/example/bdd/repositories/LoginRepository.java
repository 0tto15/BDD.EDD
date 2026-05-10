package org.example.bdd.repositories;

import org.example.bdd.connexion.ConnectionBasicSupabase;
import org.example.bdd.models.User;
import java.sql.*;

public class LoginRepository {

    private LoginRepository() {
        throw new IllegalStateException("Utility class");
    }

    public static User loginUser(String correo, String contrasena) throws SQLException {
        String sql = "SELECT id_user, nombre, apellidos, correo, contrasena, rol FROM usuarios WHERE correo = ? AND contrasena = ?";
        try (Connection connection = ConnectionBasicSupabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, contrasena);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id_user"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellidos"),
                            resultSet.getString("correo"),
                            resultSet.getString("contrasena"),
                            resultSet.getString("rol")
                    );
                } else {
                    throw new SQLException("Usuario/Contraseña no encontrados");
                }
            }
        }
    }
}