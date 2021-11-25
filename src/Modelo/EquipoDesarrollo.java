
package Modelo;

/**
 *
 * @author Marisol
 */
public class EquipoDesarrollo {
    private int id;
    private String descripción;

    public EquipoDesarrollo(int id, String descripción) {
        this.id = id;
        this.descripción = descripción;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    
}
