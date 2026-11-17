package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Modelo {

    Controlador controlador;

    private HashMap<String, Persona> personas = new HashMap<>();

    public HashMap<String, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(HashMap<String, Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona (String dni, String nombre, int edad, double altura){
        personas.put(dni, new Persona(nombre, edad, altura));
    }

    public boolean eliminarPersona (String dni){

       if (personas.containsKey(dni)) {
        personas.remove(dni);
        return true;
       }else {
        return false;
        }
    }

    public void listarPersonas(){
        for (Map.Entry<String, Persona> entry : personas.entrySet()) {
            String dni = entry.getKey();
            Persona value = entry.getValue();
            controlador.getVista().imprimirMensaje(String.format("DNI:%9s - %s",dni,value.getEstadoComoString()));
        }

}

}
