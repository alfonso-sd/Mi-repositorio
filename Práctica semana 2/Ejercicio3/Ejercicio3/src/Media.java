import es.usal.progiii.tools.Esdia;
import java.util.Scanner;

public class Media
{
    public static void main(String[] args)
    {
Scanner sc = new Scanner(System.in);
int N = 0;
float suma = 0;
float media = 0;
float f = 0;

do{
    System.out.println("Introduzca un número entero mayor de 0:");
boolean entero = sc.hasNextInt();
    if(entero == true)
    {
        N = sc.nextInt();
    }
    if (N<=0) System.err.println("El número introducido no es correcto,");
} while (N<=0);

for(int i=1; i<=N; i++) {
f = Esdia.readFloat ("Introduzca el siguiente número real: ");
suma = suma + f;
}
media = suma/N;
System.out.println("La media de los números que has introducido es " + media);

    }
}
