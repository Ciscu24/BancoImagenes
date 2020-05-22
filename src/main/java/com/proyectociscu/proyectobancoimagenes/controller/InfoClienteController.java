package com.proyectociscu.proyectobancoimagenes.controller;

import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import com.proyectociscu.proyectobancoimagenes.utils.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;

public class InfoClienteController implements Initializable{
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasena;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private Button guardar;    
    @FXML
    private Button editar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarCliente();
    }
    
    /**
     * Rellena los TextField con la informacion del cliente
     */
    public void rellenarCliente(){
        if(PrimaryController.CLIENTE != null){
            usuario.setPromptText(PrimaryController.CLIENTE.getUsuario());
            usuario.setDisable(true);
            contrasena.setPromptText("****************");
            contrasena.setDisable(true);
            nombre.setPromptText(PrimaryController.CLIENTE.getNombre());
            nombre.setDisable(true);
            apellidos.setPromptText(PrimaryController.CLIENTE.getApellidos());
            apellidos.setDisable(true);
        }
    }
    
    /**
     * Un funcion para FXML para editar los datos de los TextFields
     */
    @FXML
    public void editar(){
        contrasena.setDisable(false);
        nombre.setDisable(false);
        apellidos.setDisable(false);
        guardar.setVisible(true);
        editar.setVisible(false);
    }
    
    /**
     * Guardar en la base de datos los cambios realizados en el cliente
     */
    public void guardar(){
        if(!contrasena.getText().equals("")){
            String cambioContrasena = DigestUtils.sha512Hex(contrasena.getText());
            PrimaryController.CLIENTE.setContrasena(cambioContrasena);
        }
        if(!nombre.getText().equals("")){
            PrimaryController.CLIENTE.setNombre(nombre.getText());
        }
        if(!apellidos.getText().equals("")){
            PrimaryController.CLIENTE.setApellidos(apellidos.getText());
        }
        ClientDAO c = new ClientDAO(PrimaryController.CLIENTE);
        c.save();
        Utils.showInformation("Editar", "Cambios hechos correctamente", "Guardando en la base de datos");
        
        AppController.changeScene("clientedescripcion");
    }
    
    /**
     * Borra la cuenta de la base de datos
     */
    public void borrarCuenta(){
        boolean resultado = Utils.showConfirm();
        if(resultado == true){
            ClientDAO c = new ClientDAO(PrimaryController.CLIENTE);
            c.remove();
            AppController.Clientes.remove(PrimaryController.CLIENTE);
            PrimaryController.CLIENTE = null;
            AppController.changeScene("inicio");
        }
    }
    
    public void volver(){
        AppController.changeScene("imagenesfx");
    }
    
}
