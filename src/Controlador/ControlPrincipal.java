/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Usuario;
import Vista.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.actual.btn_verReportes.addActionListener(this);
        
        this.actual.setVisible(true);
    }
   
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.actual.btn_consultarHistorial) MostrarConsultarHistorial();
        if (e.getSource()==this.actual.btn_listarClientes) MostrarListarClientes();
        
        if(e.getSource()==this.actual.btn_verEmpleados) MostrarListarEmpleados();
        
            
        
    }

    private void MostrarConsultarHistorial() {
       HistorialCliente viewhc=new HistorialCliente();
       ControlHistorial ch=new ControlHistorial(this.actual,viewhc,usuario);
       actual.btn_consultarHistorial.setBackground(Color.YELLOW);
       actual.btn_consultarHistorial.setForeground(Color.BLACK);
       actual.cambiarPanel(viewhc);
    }

    private void MostrarListarClientes() {
       HistorialCliente view=new HistorialCliente();
       ControlHistorial ch=new ControlHistorial(this.actual,view,usuario);
       actual.btn_consultarHistorial.setBackground(Color.YELLOW);
       actual.btn_consultarHistorial.setForeground(Color.BLACK);
       actual.cambiarPanel(view);
    }

    private void MostrarListarEmpleados() {
       ListarEmpleados view=new ListarEmpleados();
       ControlListarEmpleados control =new ControlListarEmpleados(this.actual,view,usuario);
       actual.btn_verEmpleados.setBackground(Color.YELLOW);
       actual.btn_verEmpleados.setForeground(Color.BLACK);
       actual.cambiarPanel(view);
    }

    
    
    

    
    
    
    
    
    
}
