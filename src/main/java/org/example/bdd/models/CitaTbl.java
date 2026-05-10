package org.example.bdd.models;

/**
 * Esta es una clase de ejemplo necesaria para poder crear la tabla la cual estaré usando en la "Main Screen"
 * su composición puede varias, pero la estructura será usualemnte siempre la misma.
 */

public class CitaTbl {
    private  int id_cita;
    private String fecha;
    private String hora;
    private String cliente;
    private String descripcion;

    public String getFecha() {return fecha;}
    public String getHora() {
        return hora;
    }
    public String getCliente() {
        return cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId_cita() {return id_cita;}

    public CitaTbl(int id_cita, String fecha, String hora, String cliente, String descripcion) {
        this.id_cita = id_cita;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }
}
