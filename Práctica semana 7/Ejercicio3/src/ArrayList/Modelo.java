package ArrayList;

import java.util.ArrayList;

public class Modelo {
    private ArrayList<Persona> personas = new ArrayList<>();

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona (String nombre, int edad, double altura){
        personas.add(new Persona(nombre, edad, altura));
    }

    public boolean eliminarPersona (String nombre){
        Persona personaAEliminar = null;

        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personaAEliminar = persona;
                break;
            }
        }
        if (personaAEliminar != null) {
            personas.remove(personaAEliminar);
            return true;
        } else {
            return false;
        }
    }

    public Persona contienePersona (String nombre){
        Persona personaAModificar = null;
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personaAModificar = persona;
                break;
            }
        }
        return personaAModificar;
    }

    public void cambiarPersona (String nuevoNombre, int nuevaEdad, double nuevaAltura, Persona personaAModificar){
        personaAModificar.setNombre(nuevoNombre);
        personaAModificar.setEdad(nuevaEdad);
        personaAModificar.setAltura(nuevaAltura);
    }

}
