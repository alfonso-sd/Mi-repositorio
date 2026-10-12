public class Suma {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: el número de parámetros no es el correcto");
        }
       try{
float n1 = Float.parseFloat(args[0]);
float n2 = Float.parseFloat(args[1]);

float suma = n1 + n2;

System.out.println("La suma de " + n1 + " y " + n2 + " es " + suma);
       } catch (NumberFormatException e) {
        System.err.println("Error: uno o ambos parámetros no son números válidos");
       }
    }
}
