/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Historial;
import Modelo.Usuario;
import Vista.Bienvenida;
import Vista.HistorialCliente;
import Vista.VistaPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Marisol
 */
public class ControlHistorial implements ActionListener {

    HistorialCliente actual;
    VistaPrincipal vp;
    Usuario user;
    Historial historial;
    public ControlHistorial(VistaPrincipal v, HistorialCliente a, Usuario u) {
        
        this.vp=v;
        this.actual=a;
        this.user=u;
        System.out.println("Hola");
        v.btn_consultarHistorial.setBackground(Color.YELLOW);
        v.btn_consultarHistorial.setForeground(Color.BLACK);
        CambiarMensaje(this.user);
        v.cambiarPanel(actual);
        llenarHistorial();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void CambiarMensaje(Usuario u){
        String apenom = u.getEmpleado().getApellido()+", "+u.getEmpleado().getNombre();
        String rol = u.isEsAdmin()==1? "Administrador":"No Administrador";
        String mensaje = "Usuario: "+apenom+" - Rol: "+rol;
        this.actual.lbl_infoUsuario.setText(mensaje);
    }

    private void llenarHistorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
