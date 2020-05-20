package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.PhotoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BuscadorController {

    @FXML
    private TextField buscador;

    public void buscadorBoton() {
        IMController.PhotosIM = PhotoDAO.selectAllForBuscador(buscador.getText());
        AppController.changeScene("imagenesfx");
    }

}
