import model.Modelo;
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

    public int leerDatos(){
        return modelo.leerDatos();
    }

    public int leerFichero(String s){
        return modelo.leerFichero(s);
    }

}