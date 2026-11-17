package modelo;

import static es.usal.progiii.tools.OpMat.*;
import es.usal.progiii.tools.Rutas;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


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

    public void leerPartidos(){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "equipos.txt");

        String delimitador = "-";        
        ArrayList<Partido> partidosLeidos = importarDelimitado(ruta, delimitador);
        this.partidos = partidosLeidos;
    }

    public static ArrayList<Partido> importarDelimitado(Path ruta, String delimitador) {

        ArrayList<Partido> partidos = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Partido p = Partido.getPartidoFromDelimitedString(linea, delimitador);
                if(p != null){
                    partidos.add(p);
                }
            }
        } catch (IOException e) {
            return null;
        }
         
        return partidos;
    }
}
