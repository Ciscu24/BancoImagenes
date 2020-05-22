package PrimaryControllerTest;

import com.proyectociscu.proyectobancoimagenes.controller.PrimaryController;
import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PrimaryControllerTest {

    public static List<Client> Clientes = ClientDAO.selectAll();

    @Test
    public void pruebaInicioSesion() {
        System.out.println("Comprobación de la funcion iniciosesion");
        PrimaryController a = new PrimaryController();
        assertTrue(a.iniciosesion("Ciscu24", "24101998") == true);
        assertTrue(a.iniciosesion("Ciscu24", "1023") == false);
    }

}
