package org.example.bdd.models;

public class CitaTbl {
    private int idCita;
    private String fecha;
    private String hora;
    private String cliente;
    private String descripcion;

    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getCliente() { return cliente; }
    public String getDescripcion() { return descripcion; }
    public int getIdCita() { return idCita; }

    public CitaTbl(int idCita, String fecha, String hora, String cliente, String descripcion) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }
}
