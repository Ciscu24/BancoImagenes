package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.App;
import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import com.proyectociscu.proyectobancoimagenes.model.Photo;
import com.proyectociscu.proyectobancoimagenes.model.PhotoDAO;
import com.proyectociscu.proyectobancoimagenes.utils.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class AppController extends Application implements Initializable{

    private static Scene scene;
    public static BorderPane rootLayout;
    public Stage mainStage;
    
    public static List<Client> Clientes = ClientDAO.selectAll();
    public static List<Photo> Photos = PhotoDAO.selectAll();
    
    @Override
    public void start(Stage stage) throws IOException {
        rootLayout=(BorderPane)loadFXML("root");
        rootLayout.setCenter(loadFXML("buscador"));
        scene = new Scene(rootLayout, 600, 420);
        stage.setScene(scene);
        mainStage = stage;
        stage.setTitle("Pixels Bank");
        stage.getIcons().add(new Image("File:logo.png"));
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static void changeScene(String nombre){
        try {
            rootLayout.setCenter(loadFXML(nombre));
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    @FXML
    public void infoCliente(){
        if(PrimaryController.CLIENTE != null){
            changeScene("clientedescripcion");
        }else{
            Utils.showWarning("Error", "Error de validacion", "Usted tiene que estar registrado");
        }  
    }
    
    @FXML
    public void buscador(){
        if(PrimaryController.CLIENTE != null){
            changeScene("buscador");
        }else{
            Utils.showWarning("Error", "Error de validacion", "Usted tiene que iniciar sesion");
        }
    }
    
    @FXML
    public void acercaDe(){
        changeScene("info");
    }
    @FXML
    public void CerrarSesion(){
        if(PrimaryController.CLIENTE==null){
            System.exit(0);
        }else{
            changeScene("inicio");
            PrimaryController.CLIENTE = null;
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
}
