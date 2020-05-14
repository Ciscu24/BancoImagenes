package com.proyectociscu.proyectobancoimagenes.model;

public class Photo {
    protected int codigo;
    protected String titulo;
    protected String categoria;
    protected String descripcion;
    protected int codcliente;

    public Photo() {
        this(-1,"","","",0);
    }

    public Photo(int codigo, String titulo, String categoria, String descripcion, int codcliente) {
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

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    @Override
    public String toString() {
        return "Photo{" + "codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", descripcion=" + descripcion + ", codcliente=" + codcliente + '}';
    }
    
    
}
