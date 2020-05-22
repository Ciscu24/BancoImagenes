package com.proyectociscu.proyectobancoimagenes.model;

public interface IClientDAO {
    int save();
    int remove();
    void persist();
    public void detatch();
}
