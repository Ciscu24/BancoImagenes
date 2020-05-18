package com.proyectociscu.proyectobancoimagenes.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenesController implements Initializable{
    
    private static int contadorPositivo = 0;
    private static int contadorNegativo = -4;
    
    @FXML
    private ImageView imagen1;
    @FXML
    private ImageView imagen2;
    @FXML
    private ImageView imagen3;
    @FXML
    private ImageView imagen4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarImagenes();
    }
    
    private void rellenarImagenes(){
        boolean aux = false;
        int i = 0;
        while(i<4){
            Image imagen = new Image("File:"+AppController.Photos.get(contadorPositivo).getRuta());
            if(imagen1.getImage()==null){
                imagen1.setImage(imagen);
            }else if(imagen2.getImage()==null){
                imagen2.setImage(imagen);
            }else if(imagen3.getImage()==null){
                imagen3.setImage(imagen);
            }else{
                imagen4.setImage(imagen);
                aux = true;
            }
            contadorPositivo++;
            contadorNegativo++;
            i++;
        }
    }
    
    private void siguienteImagenes(){
        boolean aux = false;
        int i = 0;
        while(i<4 && AppController.Photos.get(contadorPositivo)!=null){
            Image imagen = new Image("File:"+AppController.Photos.get(contadorPositivo).getRuta());
            if(imagen1.getImage()==null){
                imagen1.setImage(imagen);
                contadorPositivo++;
                contadorNegativo++;
            }else if(imagen2.getImage()==null){
                imagen2.setImage(imagen);
                contadorPositivo++;
                contadorNegativo++;
            }else if(imagen3.getImage()==null){
                imagen3.setImage(imagen);
                contadorPositivo++;
                contadorNegativo++;
            }else{
                imagen4.setImage(imagen);
                aux = true;
            }
            i++;
        }
    }
    
    private void anteriorImagenes(){
        boolean aux = false;
        int i = 0;
        while(i<4 && AppController.Photos.get(contadorNegativo)!=null){
            Image imagen = new Image("File:"+AppController.Photos.get(contadorNegativo).getRuta());
            if(imagen4.getImage()==null){
                imagen4.setImage(imagen);
                contadorPositivo--;
                contadorNegativo--;
            }else if(imagen3.getImage()==null){
                imagen3.setImage(imagen);
                contadorPositivo--;
                contadorNegativo--;
            }else if(imagen2.getImage()==null){
                imagen2.setImage(imagen);
                contadorPositivo--;
                contadorNegativo--;
            }else{
                imagen1.setImage(imagen);
                aux = true;
            }
            i++;
        }
    }
    
    private void vaciarImagenes(){
        imagen1.setImage(null);
        imagen2.setImage(null);
        imagen3.setImage(null);
        imagen4.setImage(null);
    }
    
    @FXML
    private void siguienteImagenesFX(){
        vaciarImagenes();
        siguienteImagenes();
        System.out.println(contadorPositivo);
        System.out.println(contadorNegativo);
    }
    
    @FXML
    private void anteriorImagenesFX(){
        vaciarImagenes();
        anteriorImagenes();
        System.out.println(contadorPositivo);
        System.out.println(contadorNegativo);
    }
    
    
}
