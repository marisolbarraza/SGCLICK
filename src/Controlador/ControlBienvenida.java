/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.Bienvenida;
import Vista.VistaPrincipal;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Marisol
 */
public class ControlBienvenida implements ActionListener{

    Bienvenida actual;
    VistaPrincipal vp;
    Usuario user;
    public ControlBienvenida(VistaPrincipal v, Bienvenida a, Usuario u) {
        this.vp=v;
        this.actual=a;
        this.user=u;
        System.out.println("Hola");
        CambiarMensaje(this.user);
        v.cambiarPanel(actual);
    }
    
    private void CambiarMensaje(Usuario u){
        this.actual.lbl_bienvenida1.setText("¡Bienvenido "+u.getEmpleado().getNombre().toString()+"!");
        String apenom = u.getEmpleado().getApellido()+", "+u.getEmpleado().getNombre();
        String rol = u.isEsAdmin()==1? "Administrador":"No Administrador";
        String mensaje = "Usuario: "+apenom+" - Rol: "+rol;
        
        this.actual.lbl_infoUsuario.setText(mensaje);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
