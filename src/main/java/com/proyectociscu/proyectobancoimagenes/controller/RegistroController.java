package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import com.proyectociscu.proyectobancoimagenes.utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;

public class RegistroController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    
    @FXML
    private TextField usuario;
    @FXML
    private TextField contrasena;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;

    @FXML
    private void add(){
        String usuario = this.usuario.getText();
        String contrasena = DigestUtils.sha512Hex(this.contrasena.getText());
        String nombre = this.nombre.getText();
        String apellidos = this.apellidos.getText();
        
        if(usuario.length()>0 && contrasena.length()>0 && nombre.length()>0 && apellidos.length()>0){
            Client newClient = new Client(-1,nombre,apellidos,usuario,contrasena);
            AppController.Clientes.add(newClient);
            ClientDAO dao = new ClientDAO(newClient);
            int newId = dao.save();
            newClient.setCodigo(newId);
            Utils.showWarning("Registro", "Usuario creado correctamente", "Pulse confirmar para continuar");
            AppController.changeScene("inicio");
            
        }else{
            Utils.showWarning("Error de Validacion", "Rellenar huecos", "Usted no relleno completamente");
        }
    }
    
    

    
}
