
package Controlador;

import Modelo.Empleado;
import Modelo.Historial;
import Modelo.Usuario;
import Recursos.Database;
import Vista.HistorialCliente;
import Vista.ListarEmpleados;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Marisol
 */
public class ControlListarEmpleados implements ActionListener{

    ListarEmpleados actual;
    VistaPrincipal vp;
    Usuario user;
    ArrayList<Empleado> empleados;
    Database db;
    public ControlListarEmpleados(VistaPrincipal v,ListarEmpleados a, Usuario u) {
        
        this.vp=v;
        this.actual=a;
        this.user=u;
        CambiarMensaje(this.user);
        this.actual.btn_darBaja.addActionListener(this);
        this.actual.btn_editarEmpleado.addActionListener(this);
        this.actual.btn_nuevoEmpleado.addActionListener(this);
       
        v.cambiarPanel(actual);
     }
        private void CambiarMensaje(Usuario u){
            String apenom = u.getEmpleado().getApellido()+", "+u.getEmpleado().getNombre();
            System.out.println(apenom);
            String rol = u.isEsAdmin()==1? "Administrador":"No Administrador";
            String mensaje = "Usuario: "+apenom+" - Rol: "+rol;
             this.actual.lbl_infoUsuario.setText(mensaje);
       }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
        
    }
    

