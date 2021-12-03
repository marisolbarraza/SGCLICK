
package Controlador;

import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.Rol;
import Recursos.Database;
import Vista.NuevoEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marisol
 */
public class ControlNuevoEmpleado implements ActionListener{

    NuevoEmpleado actual ;
    public ControlNuevoEmpleado(NuevoEmpleado v) {
        this.actual=v;
        this.actual.btn_cancelar.addActionListener(this);
        this.actual.btn_crearEmpleado.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==actual.btn_cancelar) CancelarCreacion();
        if(e.getSource()==actual.btn_crearEmpleado) try {
            CrearEmpleado();
        } catch (ParseException ex) {
            Logger.getLogger(ControlNuevoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CancelarCreacion() {actual.dispose();}
    

    private void CrearEmpleado() throws ParseException {
        
        Database db = new Database();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-DD");
        int legajo = Integer.parseInt(actual.txt_legajo.getText());
        String fechaIng = actual.txt_fechIng1.getText();
        Date fecha1 = formato.parse(fechaIng);
        String rol = actual.txt_rol.getText();
        int dni = Integer.parseInt(actual.txt_dni.getText());
        String nombre = actual.txt_nombres.getText();
        String apellido = actual.txt_apellidos.getText();
        String fechaNac =actual.txt_fechNac.getText();
        Date fecha2 =formato.parse(fechaNac);
        int telefono =Integer.parseInt(actual.txt_telefono.getText());
        String mail = actual.txt_mail.getText();
        String domicilio = actual.txt_domicilio.getText();
        String localidad = actual.cb_localidad.getSelectedItem().toString();
        String provincia = actual.cb_provincia.getSelectedItem().toString();
        String pais = actual.cb_pais.getSelectedItem().toString();
        Rol r = new Rol(rol);
        Domicilio d =new Domicilio(domicilio,localidad, provincia,pais);
        Empleado e =new Empleado(legajo, dni, apellido, nombre, fecha2, d, telefono, mail, fecha1, r,1); 
        
             
        db.CrearRol(r);
        
        db.CrearEmpleado(e);
        db.CrearDomicilio(d);   
        
    }
    
}
