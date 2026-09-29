import java.util.Scanner;

public class Suma {
    public static void main(String[] args)
{ 
    Scanner sc = new Scanner(System.in);

    System.out.println("Introduce el primer número: ");
    int n1 = sc.nextInt();

    System.out.println("Ahora introduce el segundo número: ");
    int n2 = sc.nextInt();

    int suma = n1+n2;

    System.out.println("La suma de los dos números es: " + suma);

}

}
