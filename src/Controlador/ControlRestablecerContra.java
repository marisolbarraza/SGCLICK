
package Controlador;

import Recursos.GeneradorContraseñas;
import Vista.InicioSesion;
import Vista.RestablecerContraseña;
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
    
    private void SolicitarContraseña(){
    
    
    }
    private void VolverAtras(){
        InicioSesion view = new InicioSesion();
        ControlIniciarSesion control = new ControlIniciarSesion(view);
        actual.dispose();
    }
    private void EnviarContraseña(){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail smtp host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enabled", "true");
        propiedad.setProperty("mail smtp port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(propiedad);
        
        String correoEmisor="sgclicktfi@gmail.com";
        String contraseña = "Hola1234@";
        
        String correoReceptor=actual.txt_mail.getText();
        String asunto="Cambio de contraseña SGClick";
        String mensaje="¡Hola! Esta es tu nueva contraseña: "+ GeneradorContraseñas.getRandomString(8);
        
        MimeMessage mail = new MimeMessage(session);
        try {
            mail.setFrom(new InternetAddress(correoEmisor));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transporte = session.getTransport("smtp");
            transporte.connect(correoEmisor,contraseña);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            actual.lbl_Error.setText("¡Correo Enviado!");
                
        } catch (AddressException ex) {
            Logger.getLogger(ControlRestablecerContra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ControlRestablecerContra.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
}
