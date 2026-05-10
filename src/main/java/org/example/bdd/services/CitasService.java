package org.example.bdd.services;

import org.example.bdd.models.CitaTbl;
import org.example.bdd.repositories.CitasRepository;
import java.util.ArrayList;

public class CitasService {
    // Repositorios propios del servicio
    private CitasRepository citasRepository = new CitasRepository();
    public ArrayList<CitaTbl> getCitasByFecha(String fecha) throws Exception {
        return (ArrayList<CitaTbl>) citasRepository.getCitasByFecha(fecha);
    }
}
