package org.example.bdd.models;

/**
 * Este es el usuario que se usará para navegar entre pantallas.
 */

public class User {
    private int  id_user;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String rol;

    public User(int id_user, String nombre, String apellidos, String correo, String contrasena, String rol) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}

