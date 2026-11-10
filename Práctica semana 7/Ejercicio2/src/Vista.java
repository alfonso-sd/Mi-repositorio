import es.usal.progiii.tools.Esdia;

public class Vista {

    Controlador controlador;

    public void mostrarMenu () {

        boolean ventasRecibidas = false;
        boolean preciosRecibidos = false;
        boolean running = true;
        while (running){

        System.out.println("");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.- Leer tabla de ventas");
        System.out.println("2.- Leer tabla de precios");
        System.out.println("3.- Calcular ingresos totales");
        System.out.println("4.- Mostrar resultados");
        System.out.println("q.- Salir");
        System.out.print("Seleccione una opcion: ");

        String opcion = this.leerOpcion();

        switch (opcion.toLowerCase()) {

            case "1":
                for(int i = 1; i<=5; i++){
                    for(int j = 1; j<=2; j++){
                        controlador.getModelo().getAlmacenes()[i-1].getProductos()[j-1].setNumVentas(Esdia.readInt("¿Cuántas unidades del producto "+j+" del almacén "+i+" se han vendido? "));
                    }
                }
                ventasRecibidas = true;

                break;
            
            case "2":
                for(int k = 1; k<=2 ; k++){
                    double precio = Esdia.readDouble("¿Cuál es el precio del producto " + k + "? ");
                    for(int l = 0; l<5 ; l++)
                    controlador.getModelo().getAlmacenes()[l].getProductos()[k-1].setPrecio(precio);
                }
                preciosRecibidos = true;
                break;

            case "3":
                if(!ventasRecibidas){
                    this.imprimirMensaje("Todavía no has introducido cuántos productos hemos vendido, así que no podemos calcular los ingresos. ");
                }else{
                if(!preciosRecibidos){
                    this.imprimirMensaje("Todavía no has introducido el precio de los productos, así que no podemos calcular los ingresos. ");
                } else {
                controlador.getModelo().calcularIngresosTotales();
                this.imprimirMensaje("Ingresos calculados correctamente");
                }
                }
                break;

            case "4":
                if(!ventasRecibidas){
                this.imprimirMensaje("Todavía no has introducido cuántos productos hemos vendido, así que no podemos calcular los ingresos. ");
                }else{
                if(!preciosRecibidos){
                    this.imprimirMensaje("Todavía no has introducido el precio de los productos, así que no podemos calcular los ingresos. ");
                } else {
                this.imprimirMensaje("Los ingresos totales son de "+controlador.getModelo().getIngresosTotales()+" euros");
                }
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
