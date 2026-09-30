import java.util.Scanner;

public class Edad 
{
    public static void main(String[] args)
{   
    Scanner sc = new Scanner(System.in);
    int edad = 0;
    do {
    int añonacimiento = 0;
    int añoactual = 0;


    do 
    {
    System.out.printf( "Introduce tu año de nacimiento:");
    boolean resultado1 = sc.hasNextInt();
    if(resultado1 == true)
    {
        añonacimiento = sc.nextInt();
    }
} while (añonacimiento == 0);
    do 
    {
    System.out.printf( "Introduce el año actual:");
    boolean resultado2 = sc.hasNextInt();
    if(resultado2 == true)
    {
        añoactual = sc.nextInt();
    }
} while (añoactual == 0);

edad = añoactual - añonacimiento;

    } while (edad < 0);

System.out.printf("Tu edad es " + edad + " años");

}


}