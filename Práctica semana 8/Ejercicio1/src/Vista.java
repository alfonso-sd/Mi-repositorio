import es.usal.progiii.tools.*;
import modelo.*;

public class Vista {

    Controlador controlador;
    
    public void mostrarMenu (){

        boolean running = true;
        while (running){

        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Leer los partidos de la jornada");
        System.out.println("2. Leer los resultados");
        System.out.println("3. Mostrar la quiniela");
        System.out.println("q. Salir");
        System.out.println("Seleccione una opción: ");

        String opcion = this.leerOpcion();

        switch (opcion.toLowerCase()) {

            case "1":
                for(int i =1;i<=15;i++){
                    String equipo1 = Esdia.readString("Introduce el nombre del equipo local del " + i + "º partido: ");
                    String equipo2 = Esdia.readString("Introduce el nombre del equipo visitante del " + i + "º partido: ");
                    controlador.agregarPartido(equipo1, equipo2);
                }
                this.imprimirMensaje("Partidos introducidos correctamente. ");
                break;

            case "2":
                for(int i = 1 ; i<=15 ; i++){
                        String resultado = Esdia.readString("Cuál ha sido el resultado del "+ i +"º partido (1 victoria local, 2 victoria visitante, X empate): ");
                        controlador.getModelo().getPartidos().get(i-1).setResultado(resultado);
                    }
                this.imprimirMensaje("Resultados introducidos correctamente. ");
                break;

            case "3":
                System.out.println(String.format("|-------------------------------------------|"));
                System.out.println(String.format("|              QUINIELA                     |"));
                System.out.println(String.format("|-------------------------------------------|"));
                for(Partido partido: controlador.getModelo().getPartidos()){
                    System.out.println(String.format("| %-15s | %-15s | %-5s |", partido.getEquipos().get(0).getNombre(), partido.getEquipos().get(1).getNombre(), partido.getResultado()));
                }
                System.out.println(String.format("|-------------------------------------------|"));
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




    public int leerNumero(String s){
        return Esdia.readInt(s);
    }

    public String leerOpcion (){
        return Esdia.readString("");
    }

    public void mostrarResultado(int resultado){
        System.out.println("El resultado de la suma es: "+ resultado);
    }

    public void imprimirMensaje (String s){
        System.out.println(s);
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
}
