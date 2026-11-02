import static es.usal.progiii.tools.Esdia.*;
import java.util.ArrayList;
import java.util.Iterator;

import es.usal.progiii.tools.Esdia;


public class Ejercicio2 {
   
    private static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar animal");
            System.out.println("2. Eliminar animal");
            System.out.println("3. Modificar animal");
            System.out.println("4. Listar animal");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarAnimal();
                    break;
                case 2:
                    eliminarAnimal();
                    break;
                case 3:
                    modificarAnimal();
                    break;
                case 4:
                    listarAnimales();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarAnimal() {
        String especie = Esdia.readString("¿De qué especie es el animal que quieres añadir? ");
            String nombreAnimal = Esdia.readString("¿Cómo se llama el animal que vas a introducir? ");
                
            Float peso = Esdia.readFloat("¿Cuánto pesa el animal (en Kg)? ");
            if(peso <= 0){
               do{
                    peso = Esdia.readFloat("El peso introducido no es válido, vuelva a escribir el peso del animal: ");
                }while(peso<=0);
            }

            Float consumo = Esdia.readFloat("¿Cuántos Kg de alimento consume el animal al día? ");
            if(consumo <= 0){
                do{
                    consumo = Esdia.readFloat("El consumo introducido no es válido, vuelva a escribir el consumo del animal: ");
                }while(consumo<=0);
            }

            String nombreCuidador = Esdia.readString("¿Cómo se llama el cuidador del nuevo animal? ");
            String apellidos = Esdia.readString("¿Y cuáles son sus apellidos? ");
            Cuidador nuevoCuidador = new Cuidador(nombreCuidador, apellidos);
                
            nuevoCuidador.setFormacionEnCuidadoAnimal(Esdia.siOno("¿Tiene formación en cuidado animal?"));
                
        animales.add(new Animal(nuevoCuidador, nombreAnimal, especie, consumo, peso));
    }

    public static void eliminarAnimalConIterator() {
        String especie = readString_ne("Ingrese la especie del animal a eliminar: ");
        boolean eliminado = false;
        Iterator<Animal> iterator = animales.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getEspecie().equals(especie)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            System.out.println("Animal eliminado del registro.");
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    public static void eliminarAnimal() {

        String especie = readString_ne("Ingrese la especie del animal a eliminar: ");
        Animal animalAEliminar = null;

            for (Animal animal : animales) {
            if (animal.getEspecie().equals(especie)) {
                animalAEliminar = animal;
                break;
            }
        }
        if (animalAEliminar != null) {
            animales.remove(animalAEliminar);
            System.out.println("Animal eliminado del registro.");
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    public static void modificarAnimal() {

        String especie = readString_ne("Ingrese la especie del animal a modificar: ");
        Animal animalAModificar = null;
        for (Animal animal : animales) {
            if (animal.getEspecie().equals(especie)) {
                animalAModificar = animal;
                break;
            }
        }
        if (animalAModificar != null) {
            String nuevaEspecie = readString_ne("Ingrese la nueva especie: ");
            String nuevoNombre = readString("Ingrese el nuevo nombre: ");
            Float nuevoConsumo = readFloat("Ingrese el nuevo consumo: ");
            Float nuevoPeso = readFloat("Ingrese el nuevo peso: ");

            String nuevoNombreCuidador = readString("Ingrese el nombre del nuevo cuidador");
            String nuevosApellidosCuidador = readString("Ingrese los apellidos del nuevo cuidador: ");
            Cuidador nuevoCuidador = new Cuidador(nuevoNombreCuidador, nuevosApellidosCuidador);
            nuevoCuidador.setFormacionEnCuidadoAnimal(Esdia.siOno("¿Tiene formación en cuidado animal el nuevo cuidador?"));     

            animalAModificar.setEspecie(nuevaEspecie);
            animalAModificar.setNombre(nuevoNombre);
            animalAModificar.setConsumo(nuevoConsumo);
            animalAModificar.setPeso(nuevoPeso);
            animalAModificar.setCuidador(nuevoCuidador);
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    public static void listarAnimales() {

        if (animales.isEmpty()) {
            System.out.println("No hay animales en el registro.");
            return;
        }

        for (Animal animal : animales) {
            System.out.println(animal.getEstadoComoString());
        }
    }

}