/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Recursos.Database;
import Vista.InicioSesion;
import Vista.RestablecerContraseña;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marisol
 */
public class ControlIniciarSesion implements ActionListener{
    
    InicioSesion sesion;
    public ControlIniciarSesion(InicioSesion v) {
        this.sesion=v;
        this.sesion.btn_ingresar.addActionListener(this);
        this.sesion.btn_salir.addActionListener(this);
        this.sesion.btn_restablecer.addActionListener(this);
        this.sesion.lbl_Error.setVisible(false);
        this.sesion.setVisible(true);
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==sesion.btn_salir) sesion.dispose();
        if(e.getSource()==sesion.btn_ingresar) ValidarDatos();
        if(e.getSource()==sesion.btn_restablecer) CambiarContraseña(); 
    }
    
     private void ValidarDatos(){
       Database db = new Database();
       String leg =sesion.txt_legajo.getText();
       String contraseña = String.valueOf(sesion.txt_contraseña.getPassword());
       
       boolean campoVacio = CamposVacios(leg,contraseña );
       
              
       if(campoVacio==true){
           sesion.lbl_Error.setText("Campos legajo/contraseña vacíos."
                  + " Por favor revise y vuelva ingresar.");
          sesion.lbl_Error.setVisible(true);
          
       }else{
           int legajo= Integer.parseInt(sesion.txt_legajo.getText());
           
           boolean validar=db.accederSistema(legajo, contraseña);
           if(validar==false && campoVacio==false){
                sesion.lbl_Error.setText("Se introdujo un legajo/contraseña inválido."
                  + " Por favor revise y vuelva ingresar.");
                sesion.lbl_Error.setVisible(true);
                
            }
            if(validar==true){
                 VistaPrincipal vp = new VistaPrincipal();
                ControlPrincipal control= new ControlPrincipal(vp);
                sesion.dispose();
            }
       }    
     }
     private boolean CamposVacios(String l, String c){ 
          if(l.length()==0 || c.length()==0) return true;
          else return false;
      }
    
     private void CambiarContraseña(){
        RestablecerContraseña view = new RestablecerContraseña();
        ControlRestablecerContra control = new ControlRestablecerContra(view);
        sesion.dispose();
        
        
     }
    
}