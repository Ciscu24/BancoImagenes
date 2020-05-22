package UtilsTest;

import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.utils.Utils;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UtilsTest {
    
    @Test
    public void pruebaInicioSesion() {
        System.out.println("Comprobación de la funcion iniciosesion");
        Client c = Utils.buscarCliente("Ciscu24");
        assertTrue(c != null);
        c = Utils.buscarCliente("Francisco");
        assertTrue(c == null);
        
    }

}
