import es.usal.progiii.tools.*;

public class Vista {

    Controlador controlador;
    
    public void mostrarMenu (){

        boolean running = true;
        while (running){

        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Leer los números");
        System.out.println("2. Calcular la suma");
        System.out.println("3. Mostrar el resultado");
        System.out.println("q. Salir");
        System.out.println("Seleccione una opción: ");

        String opcion = this.leerOpcion();

        switch (opcion.toLowerCase()) {

            case "1":
                int numero1 = this.leerNumero("Introduzca el primer número: ");
                int numero2 = this.leerNumero("Introduzca el segundo número: ");
                controlador.getModelo().setNumero1(numero1);
                controlador.getModelo().setNumero2(numero2);
                this.imprimirMensaje("Números introducidos correctamente");
                    
                break;

            case "2":
                controlador.getModelo().calcularSuma();
                this.imprimirMensaje("Suma calculada correctamente");
                break;

            case "3":
                int resultado = controlador.getModelo().getSuma();
                this.mostrarResultado(resultado);
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
