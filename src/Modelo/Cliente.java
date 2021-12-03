
package Modelo;



/**
 *
 * @author Marisol
 */
public class Cliente {
    private int cuit; //le va a quedar muy chico como para int -> hay una clase llamada BigInteger de la librería math, solo es probar que tal. 
    private String razonSocial;
    private String correoElectronico;
    private Domicilio domicilio; //domicilio como clase ya que tiene la direccion, pais, provincia y localidad xd(?
    private int telefono;//lo mismo que cuit. 
    private int visible; //podemos hacer una conversión en vez de trabajar con un byte como tipo de dato. 

    public Cliente(int cuit, String razonSocial,String correoElectronico, Domicilio domicilio, int telefono, int visible) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.correoElectronico=correoElectronico;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.visible = visible;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public int isVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
            
}
