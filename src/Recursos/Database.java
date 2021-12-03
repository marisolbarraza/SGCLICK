
package Recursos;

import Modelo.Cliente;
import Modelo.Detalle;
import Modelo.Domicilio;
import Modelo.Empleado;
import Modelo.EquipoDesarrollo;
import Modelo.Factura;
import Modelo.Historial;
import Modelo.Proyecto;
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
           // System.out.println("Conexion exitosa");
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
    
    public ArrayList<Proyecto> obtenerProyectos(int id){
        ArrayList<Proyecto> proy= new ArrayList<Proyecto>();
        
        try {
          Connection c = getConnection();
          Statement s = c.createStatement();
          String sql = "SELECT * FROM clientes.proyecto where historial_idHistorial= "+id;
          ResultSet r = s.executeQuery(sql);       
          
          while(r.next()){
              EquipoDesarrollo equ  = obtenerEquipo(r.getInt("EquipoDesarrollo_idEquipo"));
              Date fi = new Date(r.getDate("fechaInicio").getTime());
              Proyecto p = new Proyecto(r.getInt("idProyecto"),r.getString("nombre"),r.getString("descripcion"),fi,r.getDouble("horasEmpleadas"),r.getInt("finalizado"),equ);
              proy.add(p);
          }          
        } catch(Exception e){
            e.printStackTrace();
        }
        return proy;
        
        
    }
    public ArrayList<Factura> obtenerFacturas(int id){
        
        ArrayList<Factura> fac= new ArrayList<Factura>();
        
        try {
          Connection c = getConnection();
          Statement s = c.createStatement();
          String sql = "SELECT * FROM factura where Historial_idHistorial= "+id;
          ResultSet r = s.executeQuery(sql);       
          
          while(r.next()){
              
              Date fe = new Date(r.getDate("fecha").getTime());
              ArrayList<Detalle> detalles = obtenerDetalles(r.getInt("idFactura"));
              Factura f = new Factura(r.getInt("idFactura"),fe,r.getDouble("total"),detalles,r.getInt("visible"));
              fac.add(f);
          }          
        } catch(Exception e){
            e.printStackTrace();
        }
        return fac;
    }
    public ArrayList<Detalle> obtenerDetalles(int id){
        ArrayList<Detalle> det= new ArrayList<Detalle>();
        
        try {
          Connection c = getConnection();
          Statement s = c.createStatement();
          String sql = "SELECT * FROM detalle where Factura_idFactura= "+id;
          ResultSet r = s.executeQuery(sql);       
          
          while(r.next()){
              Proyecto p = obtenerProyecto(id);
              Detalle d = new Detalle(r.getInt("idDetalle"),r.getDouble("horasPagadas"),r.getDouble("subtotal"),p);
                      
              det.add(d);
          }          
        } catch(Exception e){
            e.printStackTrace();
        }
        return det;
        
        
    }
    private ArrayList<Empleado>ListarEmpleados(){
        ArrayList<Empleado> empleados= new ArrayList<Empleado>();
        
        try {
          Connection c = getConnection();
          Statement s = c.createStatement();
          String sql = "select * from empleado";
          ResultSet r = s.executeQuery(sql);       
          
          while(r.next()){
              Domicilio dom = obtenerDomicilio(r.getInt("domicilio_idDomicilio"));
              Rol rol = obtenerRol(r.getInt("Rol_idRol"));
              Empleado em = obtenerEmpleado(r.getInt("legajo"));
              empleados.add(em);
          }          
        } catch(Exception e){
            e.printStackTrace();
        }
        return empleados;
    }
    private ArrayList<Empleado>EquipoEmpleados(int id){
       ArrayList<Empleado> equi = new ArrayList<Empleado>();
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "SELECT * FROM equipoDesarrollo where idEquipo= "+id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
            equi.add(obtenerEmpleado(r.getInt("empleado_legajoEmpleado")));
        } 
         
        } catch(Exception e){
            e.printStackTrace();
        }
        return equi;
    }
    
    public Domicilio obtenerDomicilio(int id){
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
    public Rol obtenerRol(int id){
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
    public Empleado obtenerEmpleado(int legajo){
        Empleado emp=null;
        Rol rol=null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "SELECT * FROM empleado where legajoEmpleado= "+legajo;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             Domicilio dom = obtenerDomicilio(r.getInt("domicilio_idDomicilio"));
             Date fn = new Date(r.getDate("fechaNac").getTime());
             Date fi = new Date(r.getDate("fecIngreso").getTime());
             rol = obtenerRol(r.getInt("Rol_idRol"));
             emp = new Empleado(r.getInt("legajoEmpleado"),r.getInt("dni"),r.getString("apellido"),r.getString("nombre"),fn,dom,r.getInt("telefono"),r.getString("email"),fi,rol,r.getInt("visible") ) ;
         } 
         //int legajo, int dni, String apellido, String nombre, Date fechaNacimiento, Domicilio domicilio, int telefono, String mail, Date fechaIngreso, Rol rol, int visible
        } catch(Exception e){
            e.printStackTrace();
        }
        return emp;
        
    }
    public Usuario obtenerUsuario(int legajo){
        Usuario u=null;
        Empleado emp=null;
        
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "SELECT * FROM usuario where Empleado_legajoEmpleado= "+legajo;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             emp= obtenerEmpleado(legajo);
             u = new Usuario(r.getInt("idUsuario"),r.getString("contraseña"),emp,r.getInt("esAdmin"),r.getInt("visible") ) ;
         } 
         
        } catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }
    public Historial obtenerHistorial(int cuit){
        Historial h = null;
        
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from historial "
                     + "inner join cliente on historial.cliente_CUIT = cliente.CUIT " +
                        "where historial.cliente_CUIT= "+cuit; 
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             Domicilio dom = obtenerDomicilio(r.getInt("domicilio_idDomicilio"));
             Cliente cli = obtenerCliente(cuit);
             ArrayList<Proyecto> pro= obtenerProyectos(r.getInt("idHistorial"));
             ArrayList<Factura> fac = obtenerFacturas(r.getInt("idHistorial"));
             h= new Historial(r.getInt("idHistorial"),cli,fac,r.getDouble("saldoAdeudado"),pro);
             
             
         } 
         
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return h;
    }
    
    public Cliente obtenerCliente(int cuit){
        Cliente cli=null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from cliente "
                 + "where cliente.visible=1 and cliente.cuit= "+cuit; 
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             Domicilio dom = obtenerDomicilio(r.getInt("domicilio_idDomicilio"));
             cli = new Cliente(r.getInt("cuit"),r.getString("razonSocial"),r.getString("mail"),dom,r.getInt("telefono"),r.getInt("visible"));
        } 
         
        } catch(Exception e){
            e.printStackTrace();
        }
        return cli;
    }
    public Proyecto obtenerProyecto(int id ){
        Proyecto p=null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from proyecto where idProyecto= "+id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             EquipoDesarrollo equ  = obtenerEquipo(r.getInt("EquipoDesarrollo_idEquipo"));
              Date fi = new Date(r.getDate("fechaInicio").getTime());
              p = new Proyecto(r.getInt("idProyecto"),r.getString("nombre"),r.getString("descripcion"),fi,r.getDouble("horasEmpleadas"),r.getInt("finalizado"),equ);
         } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }
    public EquipoDesarrollo obtenerEquipo(int id) {
        EquipoDesarrollo m =null;
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "SELECT * FROM equipoDesarrollo where idEquipo= "+id;
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
           ArrayList<Empleado> equipo = EquipoEmpleados(r.getInt("idEquipo"));
           m= new EquipoDesarrollo(r.getInt("idEquipo"),r.getString("descripcion"),equipo);
           return m;
        } 
         
        } catch(Exception e){
            e.printStackTrace();
        }
        return m;
        
    }
    
    public boolean validadCuit(int cuit){
        try {
         Connection c = getConnection();
         Statement s = c.createStatement();
         String sql = "select * from historial "
                     + "inner join cliente on historial.cliente_CUIT = cliente.CUIT " +
                        "where historial.cliente_CUIT= "+cuit;
         
         ResultSet r = s.executeQuery(sql);
         
         while(r.next()){
             
             if(r.getInt("cliente.visible")==1) return true;            
          } 
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    
    
    
    
    
}
