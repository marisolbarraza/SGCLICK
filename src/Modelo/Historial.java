/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Marisol
 */
public class Historial {
    private int id;
    private Cliente cliente;
    private double saldoAdeudado;

    public Historial(int id, Cliente cliente, double saldoAdeudado) {
        this.id = id;
        this.cliente = cliente;
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
    
    
    
}
