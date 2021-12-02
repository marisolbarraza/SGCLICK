/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Usuario;
import Vista.Bienvenida;
import Vista.HistorialCliente;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Marisol
 */
public class ControlPrincipal implements ActionListener{

    VistaPrincipal actual;
    Empleado empleado;
    Usuario usuario;
    ControlBienvenida cb;
    ControlHistorial ch;
    Bienvenida bienvenida;
    
    public ControlPrincipal(VistaPrincipal v, Usuario usuario) {
        this.actual=v;
        this.usuario= usuario;
        this.bienvenida= new Bienvenida();
        this.cb=new ControlBienvenida(this.actual,this.bienvenida,this.usuario);
       
        this.actual.btn_consultarHistorial.addActionListener(this);
        this.actual.btn_listarClientes.addActionListener(this);
        this.actual.btn_nuevoCliente.addActionListener(this);
        this.actual.btn_consultarHistorial.addActionListener(this);
        this.actual.btn_verEmpleados.addActionListener(this);
        this.actual.btn_verEquipos.addActionListener(this);
        this.actual.btn_verProyectos.addActionListener(this);
        this.actual.btn_verReportes.addActionListener(this);
        
        
        
        
        this.actual.setVisible(true);
        
    }
   
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.actual.btn_consultarHistorial) MostrarConsultarHistorial();
            
        
    }

    private void MostrarConsultarHistorial() {
       HistorialCliente hc=new HistorialCliente();
       ch=new ControlHistorial(this.actual,hc,usuario);
       
    }
    
    
    
    
    
}
