package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import com.proyectociscu.proyectobancoimagenes.model.Photo;
import com.proyectociscu.proyectobancoimagenes.model.PhotoDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Cargando Controlador Primario");
        //Cargar todos los items de la base de datos
        //SELECT * FROM item -> print
        List<Client> resultado = ClientDAO.selectAll();
        System.out.println(resultado);
        List<Photo> resultado02 = PhotoDAO.selectAll();
        System.out.println(resultado02);
    }

    /*@FXML
    private void switchToSecondary() throws IOException {
    AppController.setRoot("secondary");
    }*/
}
