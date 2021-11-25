/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Marisol
 */
public class Detalle {
    private int id;
    private double horasPagas;
    private double subtotal;
    private Proyecto proyecto;
    private Factura factura; //aquí tengo duda, si iría un array de detalles en factura, o ponemos aqui a que factura corresponde el detalle(?

    public Detalle(int id, double horasPagas, double subtotal, Proyecto proyecto, Factura factura) {
        this.id = id;
        this.horasPagas = horasPagas;
        this.subtotal = subtotal;
        this.proyecto = proyecto;
        this.factura = factura;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    
}
