package modelo;

import static es.usal.progiii.tools.OpMat.*;
import es.usal.progiii.tools.Rutas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Modelo {
    
    private ArrayList<Factura> facturas = new ArrayList<>();
    private ArrayList<Factura> facturasConImporteMinimo = new ArrayList<>();
    private double minimo;

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    public double getMinimo() {
        return minimo;
    }
    public ArrayList<Factura> getFacturasConImporteMinimo() {
        return facturasConImporteMinimo;
    }
    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
    public void setFacturasConImporteMinimo(ArrayList<Factura> facturasConImporteMinimo) {
        this.facturasConImporteMinimo = facturasConImporteMinimo;
    }
    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public void leerFacturas(){
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "facturas.tsv");

        String delimitador = "\t";        
        ArrayList<Factura> facturasLeidas = importarDelimitado(ruta, delimitador);
        this.facturas = facturasLeidas;
    }

    public static ArrayList<Factura> importarDelimitado(Path ruta, String delimitador) {

        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Factura f = Factura.getFacturaFromDelimitedString(linea, delimitador);
                if(f != null){
                    facturas.add(f);
                }
            }
        } catch (IOException e) {
            return null;
        }
         
        return facturas;
    }

    public void calcularFacturasMinimas(){
        ArrayList<Factura> facturasMinimas = new ArrayList<>();
        for(Factura factura: facturas){
            if (factura.getImporte()*(1-factura.getDescuento())*(1+factura.getIVA()) > minimo) {
                facturasMinimas.add(factura);
            }
        }
        this.facturasConImporteMinimo = facturasMinimas;
    }

    public int exportarAcsv (){
    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "facturas.txt");
        
    String delimitador = ",";
        
    return exportarDelimitado(ruta, facturas, delimitador);
    }

    public static int exportarDelimitado(Path ruta, List<Factura> facturas, String delimitador) {

        ArrayList<String> lineas = new ArrayList<>();
        for (Factura factura : facturas) {
            lineas.add(factura.getInstanceAsDelimitedString(delimitador));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return 1;
        } catch (IOException e) {
            return -1;
        }
        
    }

    public int exportarHtml(){
        String html = 
            "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Listado de Facturas</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <p>Listado de Facturas</p>\n" +
            "    %%TABLA%%\n" +
            "</body>\n" +
            "</html>";

        StringBuilder sbTabla = new StringBuilder();
        sbTabla.append("<table>\n");
        sbTabla.append("<tr><th>Concepto</th><th>Fecha</th><th>Cliente</th><th>NIF</th><th>Importe</th><th>Descuento</th><th>IVA</th><th>Dirección</th></tr>\n");
        
        for (Factura f : facturas) {
            sbTabla.append("<tr>")
                   .append("<td>").append(f.getConcepto()).append("</td>")
                   .append("<td>").append(f.getFecha()).append("</td>")
                   .append("<td>").append(f.getNombre()).append("</td>")
                   .append("<td>").append(f.getNIF()).append("</td>")
                   .append("<td>").append(String.format("%.2f", f.getImporte())).append("</td>")
                   .append("<td>").append(f.getDescuento()).append("</td>")
                   .append("<td>").append(f.getIVA()).append("</td>")
                   .append("<td>").append(f.getDirección()).append("</td>")
                   .append("</tr>\n");
        }
        sbTabla.append("</table>");

        String htmlFinal = html.replace("%%TABLA%%", sbTabla.toString());
        
        try {
            FileWriter writer = new FileWriter("facturas.html", StandardCharsets.UTF_8);
            writer.write(htmlFinal);
            writer.close();
            return 1;
        } catch (IOException e) {
            return -1;
            }
}
}
