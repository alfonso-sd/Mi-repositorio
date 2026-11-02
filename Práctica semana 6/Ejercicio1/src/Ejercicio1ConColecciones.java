import static es.usal.progiii.tools.Esdia.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Ejercicio1ConColecciones {

   
    private static ArrayList<Coche> coches = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Listar coches");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarCoche();
                    break;
                case 2:
                    eliminarCoche();
                    break;
                case 3:
                    modificarCoche();
                    break;
                case 4:
                    listarCoches();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarCoche() {
        String marca = readString("Ingrese la marca del coche: ");
        String modelo = readString("Ingrese el modelo del coche: ");
        String color = readString("Ingrese el color del coche: ");
        coches.add(new Coche(marca, modelo, color));
    }

    public static void eliminarCocheConIterator() {
        String marca = readString_ne("Ingrese la marca del coche a eliminar: ");
        boolean eliminado = false;
        Iterator<Coche> iterator = coches.iterator();
        while (iterator.hasNext()) {
            Coche coche = iterator.next();
            if (coche.getMarca().equals(marca)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            System.out.println("Coche eliminado.");
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void eliminarCoche() {

        String marca = readString_ne("Ingrese la marca del coche a eliminar: ");
        Coche cocheAEliminar = null;

            for (Coche coche : coches) {
            if (coche.getMarca().equals(marca)) {
                cocheAEliminar = coche;
                break;
            }
        }
        if (cocheAEliminar != null) {
            coches.remove(cocheAEliminar);
            System.out.println("Coche eliminado.");
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void modificarCoche() {

        String marca = readString_ne("Ingrese la marca del coche a modificar: ");
        Coche cocheAModificar = null;
        for (Coche coche : coches) {
            if (coche.getMarca().equals(marca)) {
                cocheAModificar = coche;
                break;
            }
        }
        if (cocheAModificar != null) {
            String nuevaMarca = readString_ne("Ingrese la nueva marca: ");
            String nuevoModelo = readString("Ingrese el nuevo modelo: ");
            String nuevoColor = readString("Ingrese el nuevo color: ");

            cocheAModificar.setMarca(nuevaMarca);
            cocheAModificar.setModelo(nuevoModelo);
            cocheAModificar.setColor(nuevoColor);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void listarCoches() {

        if (coches.isEmpty()) {
            System.out.println("No hay coches en la lista.");
            return;
        }

        for (Coche coche : coches) {
            System.out.println(coche.getEstadoComoString());
        }
    }

}