package com.proyectociscu.proyectobancoimagenes.model;

import java.util.List;

public interface IPhotoDAO {
    int save();
    List<Photo> selectAll();
    int remove();
}
