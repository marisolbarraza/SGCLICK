/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.Bienvenida;
import Vista.HistorialCliente;
import Vista.VistaPrincipal;
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
   
    public ControlHistorial(VistaPrincipal v, HistorialCliente a, Usuario u) {
        
        this.vp=v;
        this.actual=a;
        this.user=u;
        System.out.println("Hola");
        v.cambiarPanel(actual);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
