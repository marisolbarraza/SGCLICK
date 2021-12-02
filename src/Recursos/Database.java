
package Recursos;

import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.EquipoDesarrollo;
import Modelo.Rol;
import Modelo.Usuario;
import java.sql.Connection;
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
    
    public Empleado buscarEmpleado(int legajo){
        
        Empleado emp = null;
         try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from usuario" +
                      "where legajoEmpleado ="+ legajo +" and visible = 1";
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             Domicilio d = buscarDomicilio(r.getInt("domicilio_idDomicilio"));
             Rol rol = buscarRoles(r.getInt("Rol_idRol"));
             emp = new Empleado(r.getInt("legajoEmpleado"),r.getInt("dni"),r.getString("nombre"),r.getString("apellido"),r.getDate("fechaNac"), d,r.getInt("telefono"),r.getDate("fechIngreso"),rol,r.getInt("visible"));    
             //int legajo, int dni, String apellido, String nombre, Date fechaNacimiento, Domicilio domicilio, int telefono, Date fechaIngreso, Rol rol, boolean visible
             
          } 
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return emp;
    }
    public Rol buscarRoles(int id){
        
        Rol d = null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from rol where idRol="+ id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
              d= new Rol(r.getString("descripcion"));    
          } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return d;
        
               
    }
    public ArrayList<EquipoDesarrollo> buscarEquipos(int id){
        return null;
    }
    public Domicilio buscarDomicilio (int id){
       Domicilio d = null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from domicilio where idDomicilio="+ id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
              d= new Domicilio(r.getString("calleyaltura"),r.getString("localidad"),r.getString("provincia"),r.getString("pais"));    
          } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return d;
     }
    
   
    
}
