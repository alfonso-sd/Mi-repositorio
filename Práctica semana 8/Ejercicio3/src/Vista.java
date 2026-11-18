import es.usal.progiii.tools.*;
import model.*;

public class Vista {

    Controlador controlador;
    
    public void mostrarMenu (){

        if(controlador.leerDatos()>0){
            this.imprimirMensaje("\nSe han cargado los datos de datos.txt correctamente. ");
        }else{System.out.println("No se han podido cargar los datos de datos.txt");}

        boolean running = true;
        while (running){

        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Cargar los datos desde un fichero TSV");
        System.out.println("2. Mostrar los datos");
        System.out.println("q. Salir");
        System.out.println("Seleccione una opción: ");

        String opcion = this.leerOpcion();

        switch (opcion.toLowerCase()) {

            case "1":
                String s = Esdia.readString("¿Cómo se llama el archivo del que quieres importar los datos (recuerda que tiene que estar en el escritorio)? ");
                if(controlador.leerFichero(s)>0){
                this.imprimirMensaje("Datos introducidos correctamente. ");
                }else{System.out.println("Ha habido un error al intentar leer los datos");}
                break;

            case "2":
                System.out.println(String.format("|-------------------------------------------|"));
                System.out.println(String.format("|      Nombre          | Telefono   | Peso  |"));
                System.out.println(String.format("|-------------------------------------------|"));
                for(Persona persona: controlador.getModelo().getPersonas()){
                    System.out.println(String.format("| %-20s | %-10s | %-5.0f |", persona.getNombre(), persona.getTelefono(), persona.getPeso()));
                }
                System.out.println(String.format("|-------------------------------------------|"));
                break;

            case "q":
                boolean opcion2 = Esdia.siOno("¿Estás seguro de que quieres salir? ");
                if(opcion2){
                running = false;
                this.imprimirMensaje("Saliendo del programa, ¡Adiós!");
                }
                break;
                    
            default:
                this.imprimirMensaje("Opción no válida, inténtelo otra vez.");
                break;
            }   
        }      
    }




    public int leerNumero(String s){
        return Esdia.readInt(s);
    }

    public String leerOpcion (){
        return Esdia.readString("");
    }

    public void imprimirMensaje (String s){
        System.out.println(s);
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
}
