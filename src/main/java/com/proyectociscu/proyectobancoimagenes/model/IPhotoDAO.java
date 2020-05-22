package com.proyectociscu.proyectobancoimagenes.model;

import java.util.List;

public interface IPhotoDAO {
    int save();
    int remove();    
    void persist();
    public void detatch();
}
