import static es.usal.progiii.tools.Esdia.*;
import java.util.HashMap;
import java.util.Map;


public class Ejercicio3 {

    private static HashMap<String, Libro> libros = new HashMap<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Modificar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    modificarLibro();
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarLibro() {
        String isbn = readString_ne("Ingrese el isbn del libro: ");
        String título = readString_ne("Ingrese el título del libro: ");
        String género = readString("Ingrese el género al que pertenece el libro: ");
        int longitud = readInt("Ingrese la longitud (nº de páginas) del libro: ");
        libros.put(isbn, new Libro(título, género, longitud));
    }

    public static void eliminarLibro() {
        String isbn = readString_ne("Ingrese el isbn del libro a eliminar: ");
        if (libros.containsKey(isbn)) {
            libros.remove(isbn);
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void modificarLibro() {
        String isbn = readString_ne("Ingrese el isbn del libro a modificar: ");

        if (libros.containsKey(isbn)) {

            String nuevoTitulo = readString_ne("Ingrese el nuevo título: ");
            String nuevoGénero = readString("Ingrese el nuevo género: ");
            int nuevaLongitud = readInt("Ingrese la nueva longitud: ");

            Libro libroModificado = new Libro(nuevoTitulo, nuevoGénero, nuevaLongitud);
            libros.put(isbn, libroModificado);

        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void listarLibros() {

        // Si está vacío, no se puede recorrer
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la lista.");
            return;
        }

        for (Map.Entry<String, Libro> entry : libros.entrySet()) {
            String isbn = entry.getKey();
            Libro value = entry.getValue();
            System.out.println(String.format("ISBN:%9s - %s",isbn,value.getEstadoComoString()));
        }
    }

}