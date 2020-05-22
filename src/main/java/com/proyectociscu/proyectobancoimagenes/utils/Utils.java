package com.proyectociscu.proyectobancoimagenes.utils;

import com.proyectociscu.proyectobancoimagenes.controller.AppController;
import com.proyectociscu.proyectobancoimagenes.model.Client;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Utils {
    /**
     * Busca un cliente por usuario
     * @param usuario El usuario en cuestion
     * @return El cliente en cuestion
     */
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
    
    public static void showInformation(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        Optional<ButtonType> resultado = alert.showAndWait();
    }
    
    public static boolean showConfirm() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText("A punto de eliminar");
        alert.setContentText("¿Desea borrar la cuenta?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
