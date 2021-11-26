
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Marisol
 */
public class Historial {
    private int id;
    private Cliente cliente;
    private ArrayList<Factura> facturas;
    private double saldoAdeudado;

    public Historial(int id, Cliente cliente, ArrayList<Factura> facturas, double saldoAdeudado) {
        this.id = id;
        this.cliente = cliente;
        this.facturas = facturas;
        this.saldoAdeudado = saldoAdeudado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldoAdeudado() {
        return saldoAdeudado;
    }

    public void setSaldoAdeudado(double saldoAdeudado) {
        this.saldoAdeudado = saldoAdeudado;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
    
    
    
}
