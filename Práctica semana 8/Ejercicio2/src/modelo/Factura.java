package modelo;

import java.util.Locale;

public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String NIF;
    private String nombre;
    private String direccion;
    private double IVA;

    public String getConcepto() {
        return concepto;
    }
    public double getDescuento() {
        return descuento;
    }
    public String getDirección() {
        return direccion;
    }
    public String getFecha() {
        return fecha;
    }
    public double getIVA() {
        return IVA;
    }
    public double getImporte() {
        return importe;
    }
    public String getNIF() {
        return NIF;
    }
    public String getNombre() {
        return nombre;
    }
    
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public void setDirección(String direccion) {
        this.direccion = direccion;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setIVA(double iVA) {
        IVA = iVA;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public void setNIF(String nIF) {
        NIF = nIF;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Factura (String concepto, double descuento, String fecha, double importe, String NIF, String nombre, String direccion, double IVA){
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.NIF = NIF;
        this.nombre = nombre;
        this.direccion = direccion;
        this.IVA = IVA;
    }

    public static Factura getFacturaFromDelimitedString(String delimitedString, String delimiter){
        
        String[] chunks = delimitedString.split(delimiter);
        
        if(chunks.length != 8){
            return null;
        }
        
        try{
            String concepto = chunks[0];
            double descuento = Double.parseDouble(chunks[1]);
            String fecha = chunks[2];
            double importe = Double.parseDouble(chunks[3]);
            String NIF = chunks[4];
            String nombre = chunks[5];
            String direccion = chunks[6];
            double IVA = Double.parseDouble(chunks[7]);
            Factura f = new Factura(concepto, descuento, fecha, importe, NIF, nombre, direccion, IVA);
            return f;
        }
        catch(Exception e){
            return null;
        }
    }

    public String getInstanceAsDelimitedString(String delimiter){
        return String.format(Locale.of("es", "ES"),"%s"+delimiter+"%f"+delimiter+"%s"+delimiter+"%f"+delimiter+"%s"+delimiter+"%s"+delimiter+"%s"+delimiter+"%f", concepto,descuento,fecha, importe, NIF, nombre, direccion, IVA);
    }

}
