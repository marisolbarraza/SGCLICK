
package Modelo;

import java.util.Date;

/**
 *
 * @author Marisol
 */
public class Proyecto {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechInicio;
    private double horasEmpleadas;
    private boolean finalizado;
    private EquipoDesarrollo equipo;

    
    public Proyecto(int id, String nombre, String descripcion, Date fechInicio, double horasEmpleadas, boolean finalizado, EquipoDesarrollo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechInicio = fechInicio;
        this.horasEmpleadas = horasEmpleadas;
        this.finalizado = finalizado;
        this.equipo = equipo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechInicio() {
        return fechInicio;
    }

    public void setFechInicio(Date fechInicio) {
        this.fechInicio = fechInicio;
    }

    public double getHorasEmpleadas() {
        return horasEmpleadas;
    }

    public void setHorasEmpleadas(double horasEmpleadas) {
        this.horasEmpleadas = horasEmpleadas;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public EquipoDesarrollo getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDesarrollo equipo) {
        this.equipo = equipo;
    }

    
    
    
    
    
    
}
