import es.usal.progiii.tools.*;
import model.*;

public class Vista {

    Controlador controlador;
    
    public void mostrarMenu (){

        controlador.inicializarLista();

        boolean running = true;
        while (running){

        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Volver a crear la lista de alumnos ");
        System.out.println("2. Mostrar tabla de alumnos ");
        System.out.println("3. Exportar datos personales (CSV) ");
        System.out.println("4. Exportar direcciones (CSV) ");
        System.out.println("q. Salir");
        System.out.println("Seleccione una opción: ");

        String opcion = this.leerOpcion();

        switch (opcion.toLowerCase()) {

            case "1":
                controlador.inicializarLista();
                this.imprimirMensaje("Lista inicializada correctamente. ");
                break;

            case "2":
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------|"));
                System.out.println(String.format("|   Nombre   |      Apellidos       |  Edad |    NIF    |           Calle           |Número | Piso  | Letra |"));
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------|"));
                for(DatosDeAlumno alumno: controlador.getModelo().getAlumnos()){
                    System.out.println(String.format("| %-10s | %-20s | %-5d | %-9s | %-25s | %-5d | %-5d | %-5s |", 
                    alumno.getDatosPersonales().getNombre(), alumno.getDatosPersonales().getApellidos(), alumno.getDatosPersonales().getEdad(), alumno.getDatosPersonales().getNif(), alumno.getDireccion().getCalle(),
                    alumno.getDireccion().getNumero(), alumno.getDireccion().getPiso(), alumno.getDireccion().getLetra()));
                }
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------|"));
                break;

            case "3":
                if(controlador.exportarDatosPersonales()>0){
                    this.imprimirMensaje("Archivo exportado con éxito.");
                }else{this.imprimirMensaje("Ha ocurrido un error al intentar exportar el archivo.");}
                break;

            case "4":
                if(controlador.exportarDirecciones()>0){
                    this.imprimirMensaje("Archivo exportado con éxito.");
                }else{this.imprimirMensaje("Ha ocurrido un error al intentar exportar el archivo.");}                
                break;


            case "q":
                running = false;
                this.imprimirMensaje("Saliendo del programa, ¡Adiós!");
                break;
                    
            default:
                this.imprimirMensaje("Opción no válida, inténtelo otra vez.");
                break;
            }   
        }      
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
