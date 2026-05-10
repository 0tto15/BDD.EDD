package org.example.bdd.repositories;

import org.example.bdd.connexion.ConnectionBasicSupabase;
import org.example.bdd.models.CitaTbl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitasRepository {

    public List<CitaTbl> getCitasByFecha(String fecha) throws SQLException {
        List<CitaTbl> citas = new ArrayList<>();
        String sql = "SELECT id_cita, fecha, hora, cliente, descripcion FROM CITAS WHERE fecha = ?";
        try (Connection connection = ConnectionBasicSupabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, fecha);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()){
                    citas.add(new CitaTbl(
                            resultSet.getInt("id_cita"),
                            resultSet.getString("fecha"),
                            resultSet.getString("hora"),
                            resultSet.getString("cliente"),
                            resultSet.getString("descripcion")
                    ));
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return citas;
    }
}