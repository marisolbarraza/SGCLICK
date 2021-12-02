
package Recursos;

import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.EquipoDesarrollo;
import Modelo.Rol;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Marisol
 */
public class Database {
    public static final String url ="jdbc:mysql://localhost:3306/clientes";
    public static final String username ="root";
    public static final String password ="root";
    
    
    Connection getConnection(){
        Connection c = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url,username,password);
            System.out.println("Conexion exitosa");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return c;
    }
    
    public boolean accederSistema(int legajo, String contraseña){
       try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from usuario where Empleado_legajoEmpleado = "+legajo+ " and contraseña = \""+contraseña+"\" and visible=1";                 
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             
             if(r.getInt("visible")==1) return true;            
          } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean verificarPedidoContraseña(int legajo, String email){
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from usuario "+ 
                      "Inner join empleado on usuario.Empleado_legajoEmpleado = empleado.legajoEmpleado "+
                      "where Empleado_legajoEmpleado = "+legajo+ " and email= \""+ email+"\" and empleado.visible=1 and usuario.visible=1;";
         
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             
             if(r.getInt("visible")==1) return true;            
          } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    public void cambiarContraseña(int legajo,String contraseña){
        try {
            String sql = "UPDATE usuario SET contraseña ='%1' WHERE Empleado_legajoEmpleado = %2"
                    .replace("%1",""+contraseña)
                    .replace("%2",""+legajo);
            Connection c = getConnection();
            c.createStatement().executeUpdate(sql);
        } 
         catch(Exception e){
            System.out.println(e);
        } 
    }
    
    public Domicilio seleccionarDomicilio(int id){
        Domicilio d=null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from domicilio where idDomicilio= "+id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             d=new Domicilio(r.getString("calleyaltura"),r.getString("localidad"),r.getString("provincia"),r.getString("pais"));
         } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return d;
    }
    
    public Rol seleccionarRol(int id){
        Rol d=null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from rol where idRol= "+id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             d=new Rol(r.getString("descripcion"));
         } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return d;
        
    }
    
    public Empleado seleccionarEmpleado(int legajo){
        Empleado emp=null;
        Rol rol=null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "SELECT * FROM empleado where legajoEmpleado= "+legajo;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             Domicilio dom = seleccionarDomicilio(r.getInt("domicilio_idDomicilio"));
             Date fn = new Date(r.getDate("fechaNac").getTime());
             Date fi = new Date(r.getDate("fecIngreso").getTime());
             rol = seleccionarRol(r.getInt("Rol_idRol"));
             emp = new Empleado(r.getInt("legajoEmpleado"),r.getInt("dni"),r.getString("apellido"),r.getString("nombre"),fn,dom,r.getInt("telefono"),r.getString("email"),fi,rol,r.getInt("visible") ) ;
         } 
         //int legajo, int dni, String apellido, String nombre, Date fechaNacimiento, Domicilio domicilio, int telefono, String mail, Date fechaIngreso, Rol rol, int visible
        } catch(Exception e){
            e.printStackTrace();
        }
        return emp;
        
    }
    
    public Usuario seleccionarUsuario(int legajo){
        Usuario u=null;
        Empleado emp=null;
        
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "SELECT * FROM usuario where Empleado_legajoEmpleado= "+legajo;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             emp= seleccionarEmpleado(legajo);
             u = new Usuario(r.getInt("idUsuario"),r.getString("contraseña"),emp,r.getInt("esAdmin"),r.getInt("visible") ) ;
         } 
         
        } catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }
}
