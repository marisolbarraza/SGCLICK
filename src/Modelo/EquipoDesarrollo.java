
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Marisol
 */
public class EquipoDesarrollo {
    private int id;
    private String descripción;
    private ArrayList<Empleado> equipo;

    public EquipoDesarrollo(int id, String descripción, ArrayList<Empleado> equipo) {
        this.id = id;
        this.descripción = descripción;
        this.equipo = equipo;
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

    public ArrayList<Empleado> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Empleado> equipo) {
        this.equipo = equipo;
    }
    
}
