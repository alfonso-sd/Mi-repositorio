package model;

import java.util.Set;

public class DatosDeAlumno {
    private Direccion direccion;
    private DatosPersonales datosPersonales;

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public DatosDeAlumno(DatosPersonales datosPersonales, Direccion dirección) {
        this.datosPersonales = datosPersonales;
        this.direccion = dirección;
    }


    public static DatosDeAlumno crearAleatorio(Set<String> nifsExistentes) {
        return new DatosDeAlumno(
            DatosPersonales.crearAleatorio(nifsExistentes), 
            Direccion.crearAleatoria());
    }

}
