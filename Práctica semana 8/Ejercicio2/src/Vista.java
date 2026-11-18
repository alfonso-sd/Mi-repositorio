import es.usal.progiii.tools.*;
import modelo.*;

public class Vista {

    Controlador controlador;
    
    public void mostrarMenu (){

        boolean running = true;
        while (running){

        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Importar facturas de disco. ");
        System.out.println("2. Leer importe mínimo. ");
        System.out.println("3. Calcular listado de facturas (importe > mínimo). ");
        System.out.println("4. Imprimir facturas. ");
        System.out.println("5. Opciones de exportación. ");
        System.out.println("q. Salir");
        System.out.println("Seleccione una opción: ");

        String opcion = this.leerOpcion();

        switch (opcion.toLowerCase()) {

            case "1":
                controlador.leerFacturas();
                this.imprimirMensaje("Facturas leídas correctamente. ");
                break;

            case "2":
                Double minimo = Esdia.readDouble("¿Cuál es el importe mínimo? ");
                controlador.getModelo().setMinimo(minimo);
                break;

            case "3":
                controlador.calcularFacturasMinimas();
                System.out.println("Las facturas que superan el importe mínimo son:");
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------------------------------------------------|"));
                System.out.println(String.format("|      Concepto             | Descuento  |   Fecha    |   Importe   |    NIF    |        Nombre        |             Dirección             |   IVA    |"));
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------------------------------------------------|"));
                for(Factura factura: controlador.getModelo().getFacturasConImporteMinimo()){
                    System.out.println(String.format("| %-25s | %-10f | %-10s | %-11f | %-9s | %-20s | %-33s | %-8f |", factura.getConcepto(), factura.getDescuento(), factura.getFecha(), factura.getImporte(), factura.getNIF(), factura.getNombre(), factura.getDirección(), factura.getIVA()));
                }
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------------------------------------------------|"));
                break;

            case "4":
                System.out.println("Listado total de facturas: ");
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------------------------------------------------|"));
                System.out.println(String.format("|       Concepto            | Descuento  |   Fecha    |   Importe   |    NIF    |        Nombre        |             Dirección             |   IVA    |"));
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------------------------------------------------|"));
                for(Factura factura: controlador.getModelo().getFacturas()){
                    System.out.println(String.format("| %-25s | %-10f | %-10s | %-11f | %-9s | %-20s | %-33s | %-8f |", factura.getConcepto(), factura.getDescuento(), factura.getFecha(), factura.getImporte(), factura.getNIF(), factura.getNombre(), factura.getDirección(), factura.getIVA()));
                }
                System.out.println(String.format("|-----------------------------------------------------------------------------------------------------------------------------------------------------|"));
                break;

            case "5":
                System.out.println("¿En qué formato quieres exportar las facturas?");
                System.out.println("1. Exportar las facturas en formato HTML. ");
                System.out.println("2. Exportar las facturas en formato csv. ");

                String opcion2 = this.leerOpcion();
                switch (opcion2.toLowerCase()) {
                    case "1":
                        if(controlador.exportarHtml()>0){
                            System.out.println("El archivo facturas.html se ha creado con éxito.");
                        } else{System.out.println("Error al intentar exportar las facturas. ");}                       
                        break;

                    case"2":
                    if(controlador.exportarAcsv() > 0){
                        System.out.println("Datos exportados exitosamente");
                    } else{
                        System.err.println("Ocurrió un error al intentar exportar las facturas");
                    }
                    break;
                
                    default:
                        this.imprimirMensaje("Opción no válida, inténtelo otra vez.");
                        break;
                }
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
