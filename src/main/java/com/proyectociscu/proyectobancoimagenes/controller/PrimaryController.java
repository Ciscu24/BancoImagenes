package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;

public class PrimaryController implements Initializable {
    
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasena;
    
    public static Client CLIENTE; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
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
            Utils.showInformation("Inicio Sesion", "Inicio de sesion correcto", "Pulse el boton para continuar");
            AppController.changeScene("imagenesfx");
        }else{
            Utils.showWarning("Inicio Sesion", "Inicio de sesion incorrecto", "Verifique que todo esta correcto");
        }
        
        return resultado;
    }
    
    @FXML
    public void registro(){
        AppController.changeScene("registro");
    }
}
