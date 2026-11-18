package model;

import java.util.Random;

public class Direccion {
    private String calle;
    private int numero;
    private int piso;
    private String letra;

public String getCalle() {
    return calle;
}
public String getLetra() {
    return letra;
}
public int getNumero() {
    return numero;
}
public int getPiso() {
    return piso;
}

    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setPiso(int piso) {
        this.piso = piso;
    }

    private static String[] calles = {
        "Calle Mayor", "Avenida de la Constitución", "Calle Real", 
        "Paseo de la Castellana", "Calle Gran Vía", "Calle de Alcalá", 
        "Calle de Toledo", "Calle Ancha", "Calle de la Paz", "Avenida Libertad"
    };
    private static String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private static Random random = new Random();

    public Direccion (String calle, int número, int piso, String letra) {
        this.calle = calle;
        this.numero = número;
        this.piso = piso;
        this.letra = letra;
    }

    public static Direccion crearAleatoria() {
        String calle = calles[random.nextInt(calles.length)];
        int número = random.nextInt(99) + 1;
        int piso = random.nextInt(6);
        String letra = letras[random.nextInt(letras.length)];
        return new Direccion(calle, número, piso, letra);
    }

}
