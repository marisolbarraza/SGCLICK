
package Controlador;

import Recursos.Database;
import Recursos.GeneradorContraseñas;
import Vista.InicioSesion;
import Vista.RestablecerContraseña;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Marisol
 */
public class ControlRestablecerContra implements ActionListener  {
    RestablecerContraseña actual;

    public ControlRestablecerContra(RestablecerContraseña rc) {
        this.actual = rc;
        this.actual.btn_enviar.addActionListener(this);
        this.actual.btn_salir.addActionListener(this);
        this.actual.btn_volverAtras.addActionListener(this);
        this.actual.lbl_Error.setVisible(false);
        this.actual.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==actual.btn_salir) actual.dispose();
        if(e.getSource()==actual.btn_volverAtras) VolverAtras();
        if(e.getSource()==actual.btn_enviar) SolicitarContraseña();
        
    }

    private void VolverAtras(){
        InicioSesion view = new InicioSesion();
        ControlIniciarSesion control = new ControlIniciarSesion(view);
        actual.dispose();
    }
        
    private void SolicitarContraseña(){
       Database db = new Database();
       String legajo =actual.txt_legajo.getText();
       String mail = actual.txt_mail.getText();
       
       boolean campoVacio = CamposVacios(legajo, mail);
                    
       if(campoVacio==true){
           actual.lbl_Error.setText("Campos legajo/correo electrónico vacíos."
                  + " Por favor revise y vuelva ingresar.");
          actual.lbl_Error.setVisible(true);
          
       }else{
           int leg= Integer.parseInt(actual.txt_legajo.getText());
           
           boolean validar=db.verificarPedidoContraseña(leg, mail);
           if(validar==false && campoVacio==false){
                actual.lbl_Error.setText("Se introdujo un legajo/correo electrónico inválido."
                  + " Por favor revise y vuelva ingresar.");
                actual.lbl_Error.setVisible(true);
                
            }
            if(validar==true){
                String nuevaContraseña =GeneradorContraseñas.getRandomString(8);
                db.cambiarContraseña(leg, nuevaContraseña);
                EnviarContraseña(nuevaContraseña);
                System.out.println("Se ha enviado la contraseña a la casilla: "+ mail+ ".");
            }
       }    
     }
    
    private void EnviarContraseña(String c){
        String correoEmisor="sgclicktfi@gmail.com";
        String contraseña = "tfvvvmgrqfyfbeoc";//
        String correoReceptor=actual.txt_mail.getText();
        
        Properties propiedad = new Properties();
        propiedad.put("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.user", correoEmisor);
        propiedad.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(propiedad);
                
        String asunto="Cambio de contraseña SGClick";
        String mensaje="¡Hola! Esta es tu nueva contraseña: "+ c;
        
        MimeMessage mail = new MimeMessage(session);
        try {
            mail.setFrom(new InternetAddress(correoEmisor));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transporte = session.getTransport("smtp");
            transporte.connect(correoEmisor,contraseña);
            transporte.sendMessage(mail, mail.getAllRecipients());
            transporte.close();
            
            actual.lbl_Error.setText("¡Correo Enviado!");
                
        } catch (AddressException ex) {
            Logger.getLogger(ControlRestablecerContra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ControlRestablecerContra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean CamposVacios(String l, String c){ 
          if(l.length()==0 || c.length()==0) return true;
          else return false;
      }
    
}
