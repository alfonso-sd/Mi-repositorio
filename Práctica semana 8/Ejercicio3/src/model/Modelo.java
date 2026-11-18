package model;

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
    
    private ArrayList<Persona> personas = new ArrayList<>();

    public ArrayList<Persona> getPersonas() {
        return personas;
    }
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public int leerDatos(){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.txt");

        String delimitador = "\t";

        ArrayList<Persona> personasLeidas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Persona p = Persona.getPersonFromDelimitedString(linea, delimitador);
                if(p != null){
                    personasLeidas.add(p);
                }
            }
            this.personas = personasLeidas;
            return 1;
        } catch (IOException e) {
            return -1;
        }        

    }

       
    public int leerFichero(String s){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", s);

        String delimitador = "\t";
        
        ArrayList<Persona> personasLeidas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Persona p = Persona.getPersonFromDelimitedString(linea, delimitador);
                if(p != null){
                    personasLeidas.add(p);
                }
            }
            this.personas = personasLeidas;
            return 1;
        } catch (IOException e) {
            return -1;
        }   

    }

}
