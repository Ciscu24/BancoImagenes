package com.proyectociscu.proyectobancoimagenes.utils;

import com.proyectociscu.proyectobancoimagenes.controller.AppController;
import com.proyectociscu.proyectobancoimagenes.model.Client;
import javafx.scene.control.Alert;

public class Utils {
    public static Client buscarCliente(String usuario){
        Client cliente = null;
        boolean aux = false;
        
        for(int i=0; i<AppController.Clientes.size() && !aux; i++){
            if(AppController.Clientes.get(i).getUsuario().equals(usuario)){
                cliente = AppController.Clientes.get(i);
                aux = true;
            }
        }
        
        return cliente;
    }
    
    public static void showWarning(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);

        alert.showAndWait();
    }
}
