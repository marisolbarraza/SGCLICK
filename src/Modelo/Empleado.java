
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marisol
 */
public class Empleado {
    private int legajo;
    private int dni;
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;
    private Domicilio domicilio;
    private int telefono;
    private Date fechaIngreso;
    private ArrayList<Rol> roles;
    private ArrayList<EquipoDesarrollo> equipos;
    

    public Empleado(int legajo, int dni, String apellido, String nombre, Date fechaNacimiento, Domicilio domicilio, int telefono, Date fechaIngreso, ArrayList<Rol> roles, ArrayList<EquipoDesarrollo> equipos) {
        this.legajo = legajo;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
        this.roles = roles;
        this.equipos = equipos;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }

    public ArrayList<EquipoDesarrollo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<EquipoDesarrollo> equipos) {
        this.equipos = equipos;
    }
    
    
    
}
