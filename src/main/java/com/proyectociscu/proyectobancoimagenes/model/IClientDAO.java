package com.proyectociscu.proyectobancoimagenes.model;

import java.util.List;

public interface IClientDAO {
    int save();
    List<Client> selectAll();
    int remove();
}
