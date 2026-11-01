import static es.usal.progiii.tools.Esdia.*;


public class Ejercicio1ConArrays {
     private static final int MAX_SIZE = 10;
    private static Coche[] coches = new Coche[MAX_SIZE];
    private static int cochesCount = 0;

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
                case 1: agregarCoche(); break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: listarCoches(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarCoche() {
        if (cochesCount < MAX_SIZE) {
            String marca = readString_ne("Ingrese la marca del coche: ");
            String modelo = readString("Ingrese el modelo del coche: ");
            String color = readString("Ingrese el color: ");
            coches[cochesCount++] = new Coche(marca, modelo, color);
            System.out.println("Coche añadido correctamente.");
        } else {
            System.out.println("Array de coches está lleno.");
        }
    }

    public static void eliminarCoche() {
        String marca = readString_ne("Ingrese la marca del coche a eliminar: ");
        boolean encontrado = false;
        for (int i = 0; i < cochesCount; i++) {
            // Para comparar cadenas empleamos equals
            if (coches[i].getMarca().equals(marca)) {
                encontrado = true;
                for (int j = i; j < cochesCount - 1; j++) {
                    coches[j] = coches[j + 1];
                }
                cochesCount--;

                System.out.println("Coche eliminado correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void modificarCoche() {

        String marca = readString_ne("Ingrese la marca del coche a modificar: ");
        boolean encontrado = false;
        for (int i = 0; i < cochesCount; i++) {
            if (coches[i].getMarca().equals(marca)) {
                String nuevaMarca = readString_ne("Ingrese la nueva marca: ");
                String nuevoModelo = readString("Ingrese el nuevo modelo: ");
                String nuevoColor = readString("Ingrese el nuevo color: ");

                coches[i].setMarca(nuevaMarca);
                coches[i].setModelo(nuevoModelo);
                coches[i].setColor(nuevoColor);

                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Coches no encontrado.");
        }
    }

    public static void listarCoches() {

        if (cochesCount == 0) {
            System.out.println("No hay coches en el array.");
            return;
        }

        for (int i = 0; i < cochesCount; i++) {
            System.out.println(coches[i].getEstadoComoString());
        }
    }
    
}
