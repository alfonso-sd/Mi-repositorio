import modelo.*;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador (Modelo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Vista getVista() {
        return vista;
    }

    public void leerFacturas(){
        modelo.leerFacturas();
    }

    public void calcularFacturasMinimas(){
        modelo.calcularFacturasMinimas();
    }

    public int exportarAcsv (){
        return modelo.exportarAcsv();
    }

    public int exportarHtml(){
        return modelo.exportarHtml();
    }
    
    }
