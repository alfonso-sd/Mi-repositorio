import model.*;

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


    public void inicializarLista(){
        modelo.inicializarLista();
    }

    public int exportarDatosPersonales(){
        return modelo.exportarDatosPersonalesCSV();
    }

    public int exportarDirecciones(){
        return modelo.exportarDireccionesCSV();
    }

    
    }
