package com.proyectociscu.proyectobancoimagenes.model;

public class Client {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String contraseña;

    public Client() {
        this(-1,"","","","");
    }
    
    public Client(int codigo, String nombre, String apellidos, String usuario, String contraseña) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}
