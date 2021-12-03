
package Controlador;

import Modelo.Empleado;
import Modelo.Historial;
import Modelo.Proyecto;
import Modelo.Usuario;
import Recursos.Database;
import Vista.HistorialCliente;
import Vista.ListarEmpleados;
import Vista.NuevoEmpleado;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
        CargarTabla();
     }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==this.actual.btn_darBaja) DarBajaEmpleado();
       if(e.getSource()==this.actual.btn_editarEmpleado)EditarEmpleado();
       if(e.getSource()==this.actual.btn_nuevoEmpleado)CrearEmpleado();
       
    }
        private void CambiarMensaje(Usuario u){
            String apenom = u.getEmpleado().getApellido()+", "+u.getEmpleado().getNombre();
            System.out.println(apenom);
            String rol = u.isEsAdmin()==1? "Administrador":"No Administrador";
            String mensaje = "Usuario: "+apenom+" - Rol: "+rol;
             this.actual.lbl_infoUsuario.setText(mensaje);
       }

    private void DarBajaEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void EditarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void CrearEmpleado() {
       NuevoEmpleado view = new NuevoEmpleado();
       ControlNuevoEmpleado control = new ControlNuevoEmpleado(view);
       view.setVisible(true);
       
    }

    private void CargarTabla() {
        Database db = new Database();
        this.empleados = db.ListarEmpleados();
        LlenarTabla(this.empleados);
    }

    private void LlenarTabla(ArrayList<Empleado> e) {
       DefaultTableModel tablaEmpleados = new DefaultTableModel();
        tablaEmpleados.addColumn("legajo");
        tablaEmpleados.addColumn("Fecha de Ingreso");
        tablaEmpleados.addColumn("DNI");
        tablaEmpleados.addColumn("Nombre y Apellido");
        tablaEmpleados.addColumn("Fecha de Nacimiento");
        tablaEmpleados.addColumn("Domicilio");
        tablaEmpleados.addColumn("Localidad");
        tablaEmpleados.addColumn("Provincia");
        tablaEmpleados.addColumn("Pais");
        tablaEmpleados.addColumn("Teléfono");
        tablaEmpleados.addColumn("Correo Electrónico");
        tablaEmpleados.addColumn("Rol");
               
        for(Empleado emp: e){
            Object[]fila={
                emp.getLegajo(),
                emp.getFechaIngreso(),
                emp.getDni(),
                emp.getNombre()+ emp.getApellido(),
                emp.getFechaNacimiento(),
                emp.getDomicilio().getDomicilio(),
                emp.getDomicilio().getLocalidad(),
                emp.getDomicilio().getProvincia(),
                emp.getDomicilio().getPais(),
                emp.getTelefono(),
                emp.getMail(),
                emp.getRol().getDescripcion()
            }; tablaEmpleados.addRow(fila);
            actual.tablaEmpleados.setModel(tablaEmpleados);
                
            }
    }

    
        
    }
    

