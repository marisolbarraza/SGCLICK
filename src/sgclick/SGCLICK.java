package sgclick;

import Controlador.ControlIniciarSesion;
import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.Historial;
import Modelo.Rol;
import Modelo.Usuario;
import Persistencia.Database;
import Vista.HistorialCliente;
import Vista.InicioSesion;
import Vista.VistaPrincipal;
import java.util.ArrayList;



/**
 *
 * @author Marisol
 */
public class SGCLICK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InicioSesion view = new InicioSesion();
        ControlIniciarSesion c = new ControlIniciarSesion(view);
        
//        Database db = new Database();
//        
//        boolean v = db.accederSistema(44444, "Luchocosta02");
//        System.out.println(v);
        
        
        
    }
    
}
