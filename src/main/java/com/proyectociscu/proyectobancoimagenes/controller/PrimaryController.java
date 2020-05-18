package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import com.proyectociscu.proyectobancoimagenes.model.Photo;
import com.proyectociscu.proyectobancoimagenes.model.PhotoDAO;
import com.proyectociscu.proyectobancoimagenes.utils.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;

public class PrimaryController implements Initializable{
    
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasena;
    
    public static Client CLIENTE; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Utils.buscarCliente("Ciscu24"));
    }
    
    public boolean iniciosesion(String usuario, String contrasena){
        boolean resultado = false;
        contrasena = DigestUtils.sha512Hex(contrasena);
        Client cliente = Utils.buscarCliente(usuario);
        
        if(cliente != null && contrasena.equals(cliente.getContrasena())){
            resultado = true;
            CLIENTE = cliente;
        }
        
        return resultado;
    }
    
    @FXML
    public boolean iniciosesionfx(){
        boolean resultado = false;
        String usuario = this.usuario.getText();
        String contrasena = this.contrasena.getText();
        if(!usuario.equals("") && !contrasena.equals("") && iniciosesion(usuario, contrasena)){
            resultado = true;
            Utils.showWarning("Inicio Sesion", "Inicio de sesion correcto", "Pulse el boton para continuar");
            AppController.changeScene("imagenes");
        }else{
            Utils.showWarning("Inicio Sesion", "Inicio de sesion incorrecto", "Verifique que todo esta correcto");
        }
        
        return resultado;
    }
    
    @FXML
    public void registro(){
        AppController.changeScene("registro");
    }
    
    /*  public boolean cambioPantalla(){
    
    }*/
}
