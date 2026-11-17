package modelo;
import java.util.ArrayList;

public class Partido {
    private ArrayList<Equipo> equipos = new ArrayList<>();
    String resultado;

    public String getResultado() {
        return resultado;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Partido (String s, String w){
        Equipo equipo1 = new Equipo(s);
        Equipo equipo2 = new Equipo(w);
        equipos.add(equipo1);
        equipos.add(equipo2);
    }

}
