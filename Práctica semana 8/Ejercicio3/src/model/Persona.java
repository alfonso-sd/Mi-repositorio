package model;

import java.util.Locale;


public class Persona {
    
    private String nombre;
    private String telefono;
    private float peso;
    
    public Persona(String nombre, String telefono, float peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    } 
   
    public static Persona getPersonFromDelimitedString(String delimitedString, String delimiter){
        
        String[] chunks = delimitedString.split(delimiter);
        
        if(chunks.length != 3){
            return null;
        }
        
        try{
            String nombre = chunks[0];
            String telefono = chunks[1];
            float peso = Float.parseFloat(chunks[2]);
            Persona p = new Persona(nombre, telefono, peso);
            return p;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}
