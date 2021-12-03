
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Marisol
 */
public class Factura {
    private int nroFactura;
    private Date fechaEmisión;
    private double total;
    private double horasTotalPagadas;
    private ArrayList<Detalle> detalles;
    private int visible;

    public Factura(int nroFactura, Date fechaEmisión, double total, ArrayList<Detalle> detalles, int visible) {
        this.nroFactura = nroFactura;
        this.fechaEmisión = fechaEmisión;
        this.detalles=detalles;
        this.horasTotalPagadas=CalcularHoras(detalles);
        this.total = CalcularTotal(detalles);
        this.visible =1;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFechaEmisión() {
        return fechaEmisión;
    }

    public void setFechaEmisión(Date fechaEmisión) {
        this.fechaEmisión = fechaEmisión;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

    public int isVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public ArrayList<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<Detalle> detalles) {
        this.detalles = detalles;
    }
    
    private double CalcularTotal(ArrayList<Detalle> detalles){
        double total = 0.0;
        for(int i=0; i<detalles.size();i++){
            total += detalles.get(i).getSubtotal();
        }
        return total;
    }

    private double CalcularHoras(ArrayList<Detalle> detalles) {
        double total = 0.0;
        for(int i=0; i<detalles.size();i++){
            total += detalles.get(i).getHorasPagas();
        }
        return total;
    }

    public double getHorasTotalPagadas() {
        return horasTotalPagadas;
    }

    public void setHorasTotalPagadas(double horasTotalPagadas) {
        this.horasTotalPagadas = horasTotalPagadas;
    }
    
    
}
