package HashMap;

import static es.usal.progiii.tools.Esdia.*;


public class Vista {

    Controlador controlador;

    public void mostrarMenu(){

        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Listar personas");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    eliminarPersona();
                    break;
                case 3:
                    modificarPersona();
                    break;
                case 4:
                    listarPersonas();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public void agregarPersona() {
        String dni = readString_ne("Ingrese el dni de la persona: ");
        String nombre = readString_ne("Ingrese el nombre de la persona: ");
        int edad = readInt("Ingrese la edad de la persona: ");
        double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ");
        controlador.getModelo().agregarPersona(dni, nombre, edad, altura);
    }

    public void eliminarPersona() {
        String dni = readString_ne("Ingrese el dni de la persona a eliminar: ");
        Boolean personaEliminada = controlador.getModelo().eliminarPersona(dni);
        if (personaEliminada) {
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public void modificarPersona() {
        String dni = readString_ne("Ingrese el dni de la persona a modificar: ");

        if (controlador.getModelo().getPersonas().containsKey(dni)) {

            String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
            int nuevaEdad = readInt("Ingrese la nueva edad: ");
            double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ");

            controlador.getModelo().agregarPersona(dni, nuevoNombre, nuevaEdad, nuevaAltura);
            System.out.println("Persona modificada correctamente. ");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public void listarPersonas() {

        if (controlador.getModelo().getPersonas().isEmpty()) {
            System.out.println("No hay personas en la lista.");
            return;
        }

        controlador.getModelo().listarPersonas();
    }

    public void imprimirMensaje (String s){
        System.out.println(s);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

}
