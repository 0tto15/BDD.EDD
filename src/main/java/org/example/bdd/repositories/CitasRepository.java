package org.example.bdd.repositories;

import org.example.bdd.connexion.ConnectionBasicSupabase;
import org.example.bdd.models.CitaTbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitasRepository {

    public ArrayList<CitaTbl> getCitasByFecha(String fecha) throws Exception{
        ArrayList<CitaTbl> citas = new ArrayList<>();
        String sql = "SELECT * FROM CITAS WHERE fecha = ?";
        try (
                // Connection connection = ConnectionBasicDocker.connect(); // Conexión basica con docker.
                Connection connection = ConnectionBasicSupabase.getConnection(); // Conexión básica con supabase.
                // Connection connection = ConnectionPool.getDataSource().getConnection(); // Conexión pool.
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        )
        {
            preparedStatement.setString(1, fecha);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
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
        } catch (SQLException exception) {
            throw new Exception("Error en la base de datos.\nInformación del error: " + exception.getMessage());
        }
        return citas;
    }
}