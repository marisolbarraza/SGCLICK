
package Persistencia;

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
    
    public Usuario buscarCuenta(int legajo, String contraseña){
        Usuario user=null;
        Empleado empleado;
        
       try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from usuario" +
                      "where Empleado_legajoEmpleado ="+ legajo +" and usuario.contraseña =" + contraseña;
         ResultSet r = s.executeQuery(sql);
         
         empleado = buscarEmpleado(r.getInt("Empleado_legajoEmpleado"));
         
       
         
        } catch(Exception e){
            e.printStackTrace();
        }
        return user;
        
    }
    
    public Empleado buscarEmpleado(int legajo){
        
        Domicilio domicilio;
        ArrayList<Rol> roles;
        ArrayList<EquipoDesarrollo> equipo;
         try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from usuario" +
                      "where legajoEmpleado ="+ legajo +" and visible = 1";
         ResultSet r = s.executeQuery(sql);         
        
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    public ArrayList<Rol> buscarRoles(int id){
        return null;
               
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
