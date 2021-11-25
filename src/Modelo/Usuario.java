
package Modelo;

/**
 *
 * @author Marisol
 */
public class Usuario {
    private int id;
    private String contraseña;
    private Empleado empleado;
    private  boolean esAdmin;
    private  boolean visible;

    public Usuario(int id, String contraseña, Empleado empleado, boolean esAdmin, boolean visible) {
        this.id = id;
        this.contraseña = contraseña;
        this.empleado = empleado;
        this.esAdmin = esAdmin;
        this.visible = visible;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    

}
