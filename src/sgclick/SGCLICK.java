package sgclick;

import Controlador.ControlPrincipal;
import Modelo.*;
import Recursos.Database;
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
        Database db= new Database();
        
        String m = "rol";
//        int i = db.TotalRegistros(m);
//         System.out.println(i);
        Usuario u = db.obtenerUsuario(44444);
//       // System.out.println;
//       
//       boolean b =db.validadCuit(203541);
//       System.out.println(b);
        
        VistaPrincipal view = new VistaPrincipal();
        ControlPrincipal c = new ControlPrincipal(view,u);
        
      
       
       
       
       


        
        
        
    }
    
}
