package RegistroControllerTest;

import com.proyectociscu.proyectobancoimagenes.controller.RegistroController;
import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.model.ClientDAO;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RegistroControllerTest {
    public static List<Client> Clientes = ClientDAO.selectAll();

    @Test
    public void pruebaUsuarioRepetido() {
        System.out.println("Comprobación de la funcion usuarioRepetido");
        RegistroController a = new RegistroController();
        assertTrue(a.usuarioRepetido("Ciscu24") == true);
        assertTrue(a.usuarioRepetido("Francisco") == false);
    }
}
