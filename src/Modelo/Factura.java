
package Modelo;

import java.util.Date;

/**
 *
 * @author Marisol
 */
public class Factura {
    private int nroFactura;
    private Date fechaEmisión;
    private double total;
    private Historial historial;
    private boolean visible;

    public Factura(int nroFactura, Date fechaEmisión, double total, Historial historial, boolean visible) {
        this.nroFactura = nroFactura;
        this.fechaEmisión = fechaEmisión;
        this.total = total;
        this.historial = historial;
        this.visible = visible;
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

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
    
}
