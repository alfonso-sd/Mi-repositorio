package model;

import static es.usal.progiii.tools.OpMat.*;
import es.usal.progiii.tools.Rutas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Modelo {
    
    private ArrayList<DatosDeAlumno> alumnos = new ArrayList<>();

    public ArrayList<DatosDeAlumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(ArrayList<DatosDeAlumno> alumnos) {
        this.alumnos = alumnos;
    }


    public void inicializarLista() {
        alumnos = new ArrayList<>();
        Set<String> nifsExistentes = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            alumnos.add(DatosDeAlumno.crearAleatorio(nifsExistentes));
        }
    }


    public int exportarDatosPersonalesCSV() {
        String archivo = "datos_personales.csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("Nombre,Apellidos,Edad,NIF");
            for (DatosDeAlumno alumno : alumnos) {
                DatosPersonales p = alumno.getDatosPersonales();
                pw.printf("%s,%s,%d,%s%n", p.getNombre(), p.getApellidos(), p.getEdad(), p.getNif());
            }
            return 1;
        } catch (IOException e) {
            return -1;
            }
    }

    public int exportarDireccionesCSV() {
        String archivo = "direcciones.csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("Calle,Numero,Piso,Letra");
            for (DatosDeAlumno alumno : alumnos) {
                Direccion d = alumno.getDireccion();
                pw.printf("%s,%d,%d,%s%n", d.getCalle(), d.getNumero(), d.getPiso(), d.getLetra());
            }
            return 1;
        } catch (IOException e) {
            return -1;
            }
    }
}
