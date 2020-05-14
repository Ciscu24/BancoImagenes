package com.proyectociscu.proyectobancoimagenes.model;

public class Client {
    protected int codigo;
    protected String nombre;
    protected String apellidos;
    protected String usuario;
    protected String contrasena;

    public Client() {
        this(-1,"","","","");
    }
    
    public Client(int codigo, String nombre, String apellidos, String usuario, String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", contrase\u00f1a=" + contrasena + '}';
    }
    
}
