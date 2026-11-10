package modelo;

import java.util.ArrayList;

public class Modelo {
    
    private ArrayList<Partido> partidos = new ArrayList<>();

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void agregarPartido (String equipo1, String equipo2){
        Partido partido = new Partido(equipo1, equipo2);
        partidos.add(partido);
    }
}
