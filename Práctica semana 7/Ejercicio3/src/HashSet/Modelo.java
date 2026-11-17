package HashSet;

import java.util.HashSet;

public class Modelo {
    private  HashSet<Persona> personas = new HashSet<>();

    Controlador controlador;

    public HashSet<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(HashSet<Persona> personas) {
        this.personas = personas;
    }

    public boolean agregarPersona (String nombre, int edad, double altura){
        Persona nuevaPersona = new Persona(nombre, edad, altura);
        return personas.add(nuevaPersona);
    }

    public boolean eliminarPersona (String nombre){
        Persona personaAEliminar = new Persona(nombre, 0, 0);
        return personas.remove(personaAEliminar);
    }

    public boolean contienePersona (String nombre){
        Persona personaAModificar = new Persona(nombre, 0,0);
        return personas.contains(personaAModificar);
    }

    public void cambiarPersona (String nombre, String nuevoNombre, int nuevaEdad, double nuevaAltura){
        eliminarPersona(nombre);
        personas.add(new Persona(nuevoNombre, nuevaEdad, nuevaAltura));
    }


}
