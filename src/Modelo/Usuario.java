
package Modelo;

/**
 *
 * @author Marisol
 */
public class Usuario {
    private int id;
    private String contraseña;
    private Empleado empleado;
    private  int esAdmin;
    private  int visible;

    public Usuario(int id, String contraseña, Empleado empleado, int esAdmin, int visible) {
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

    public int isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(int esAdmin) {
        this.esAdmin = esAdmin;
    }

    public int isVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    

}
