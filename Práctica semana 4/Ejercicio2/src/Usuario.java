import es.usal.progiii.tools.Esdia;

public class Usuario {
    private String nombre;
    private float peso;
    private float altura;

    public String getNombre() {
return this.nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
    public Float getPeso() {
return this.peso;
}
public void setPeso(Float peso) {
this.peso = peso;
}
public Float getAltura() {
return this.altura;
}
public void setAltura(Float altura) {
this.altura = altura;
}

public Usuario(String[] datos){
this.nombre = datos[0];
this.peso = Float.parseFloat(datos[1]);
this.altura = Float.parseFloat(datos[2]); 
}
    public static void main(String[] args) {
String[] datos = new String[3];
datos[0] = Esdia.readString("Introduce el nombre del usuario: ");
datos[1] = Esdia.readString("Introduce el peso del usuario (en kg): ");
datos[2] = Esdia.readString("Introduce la altura del usuario (en cm): ");

Usuario usuario = new Usuario(datos);

Float imc = 10000*(usuario.peso/(usuario.altura*usuario.altura));


System.out.println("Nombre  |  Peso  |  Altura  |  IMC");
System.out.printf("%s |   %.1f   |   %.0f   |   %.2f",usuario.nombre, usuario.peso, usuario.altura, imc );

    }
}
