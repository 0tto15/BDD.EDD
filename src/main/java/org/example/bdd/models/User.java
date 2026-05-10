package org.example.bdd.models;

public class User {
    private int idUser;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String rol;

    public User(int idUser, String nombre, String apellidos, String correo, String contrasena, String rol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}

