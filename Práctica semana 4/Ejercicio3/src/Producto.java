import es.usal.progiii.tools.Esdia;

public class Producto {

public float precioKg;
public static float IVA = 0.1f;
public float cantidad;

public Producto() {
}
 public float precioKgConIVA (){
    float p = this.precioKg + this.precioKg * IVA;
    return p;
 }

 public float precioTotal (){
float p = this.precioKgConIVA()*this.cantidad;
return p;

 }

   public static void main(String[] args) {
    int i = 1;
    int seguir = 1;
Producto [] frutas =  new Producto[2];
frutas[0] = new Producto(); //Manzanas
frutas[1] = new Producto();  //Peras

frutas[0].precioKg = Esdia.readFloat("¿Cuál es el precio del kilo de manzanas hoy? ");
frutas[1].precioKg = Esdia.readFloat("¿Y a cuánto está el kilo de peras? ");

do{
    frutas[0].cantidad = Esdia.readFloat("Hola, ¿cuántos kilos de manzanas quieres comprar? ");
    frutas[1].cantidad = Esdia.readFloat("¿Y cuántos kilogramos de peras quieres? ");

float precioFinal = frutas[0].precioTotal() + frutas[1].precioTotal();

System.out.println("|--------------------------------------------------------------------------|");
System.out.println(String.format("|  Cliente                                            | %d  |", i));
System.out.println("|--------------------------------------------------------------------------|");
System.out.println(String.format("|  Manzanas  | %.2f kg | precio kg con IVA %.2f | %.2f \u20AC  |", frutas[0].cantidad, frutas[0].precioKgConIVA(), frutas[0].precioTotal()));
System.out.println(String.format("|  Peras     | %.2f kg | precio kg con IVA %.2f | %.2f \u20AC  |", frutas[1].cantidad, frutas[1].precioKgConIVA(), frutas[1].precioTotal()));
System.out.println("|--------------------------------------------------------------------------|");
System.out.println(String.format("|  Total con IVA: %.2f \u20AC %20 |", precioFinal));
System.out.println("|--------------------------------------------------------------------------|");

i = i++;
seguir = Esdia.readInt("Si hay otro cliente que quiera comprar en la frutería, pulse 1. Si ya no hay más clientes, pulse otro número. ");

} while (seguir == 1);

    }
}
