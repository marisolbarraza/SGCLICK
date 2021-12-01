
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Marisol
 */
public class Detalle {
    private int id;
    private double horasPagas;
    private double subtotal;
    private Proyecto proyecto;
    

    public Detalle(int id, double horasPagas, double subtotal, Proyecto proyecto) {
        this.id = id;
        this.horasPagas = horasPagas;
        this.subtotal = horasPagas*1800;
        this.proyecto = proyecto;
        
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHorasPagas() {
        return horasPagas;
    }

    public void setHorasPagas(double horasPagas) {
        this.horasPagas = horasPagas;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

   
    
}
