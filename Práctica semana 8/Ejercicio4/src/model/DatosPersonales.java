package model;

import java.util.Random;
import java.util.Set;

public class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

public String getApellidos() {
    return apellidos;
}
public String getNombre() {
    return nombre;
}
public int getEdad() {
    return edad;
}
public String getNif() {
    return nif;
}

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }


    private static String[] nombres = {
        "Lucía", "Alejandro", "María", "Carlos", "Sofía", "David", 
        "Paula", "Daniel", "Elena", "Pablo", "Carmen", "Álvaro", "Laura", "Adrián", "Sara"
    };
    private static String[] apellidosPosibles = {
        "García", "Rodríguez", "González", "Fernández", "López", 
        "Martínez", "Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz"
    };
    private static Random random = new Random();
    private static String letras_nif = "TRWAGMYFPDXBNJZSQVHLCKE";

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    public static DatosPersonales crearAleatorio(Set<String> nifsExistentes) {
        String nombre = nombres[random.nextInt(nombres.length)];
        String apellidos = apellidosPosibles[random.nextInt(apellidosPosibles.length)] + " " + apellidosPosibles[random.nextInt(apellidosPosibles.length)];
        int edad = random.nextInt(15) + 10;

        String nif;
        do {
            int num = random.nextInt(90000000) + 10000000;
            char letraControl = letras_nif.charAt(num % 23);
            nif = num + String.valueOf(letraControl);
        } while (nifsExistentes.contains(nif));

        nifsExistentes.add(nif);
        return new DatosPersonales(nombre, apellidos, edad, nif);
    }

}
