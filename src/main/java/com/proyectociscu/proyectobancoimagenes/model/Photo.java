package com.proyectociscu.proyectobancoimagenes.model;

public class Photo {
    private int codigo;
    private String titulo;
    private String categoria;
    private String descripcion;
    private String codcliente;

    public Photo() {
        this(-1,"","","","");
    }

    public Photo(int codigo, String titulo, String categoria, String descripcion, String codcliente) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.codcliente = codcliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    @Override
    public String toString() {
        return "Photo{" + "codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", descripcion=" + descripcion + ", codcliente=" + codcliente + '}';
    }
    
    
}
