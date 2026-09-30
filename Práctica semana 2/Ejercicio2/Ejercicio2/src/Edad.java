import java.io.Console;

public class Edad 
{
    public static void main(String[] args)
{   
    Console teclado = System.console();
    int edad = 0;
    do {
    int añonacimiento = 0;
    int añoactual = 0;


    do 
    {
    teclado.printf( "Introduce tu año de nacimiento:");
    String nacimiento = teclado.readLine();
    añonacimiento = Integer.parseInt(nacimiento);
} while (añonacimiento == 0);
    
do 
    {
    teclado.printf( "Introduce el año actual: ");
    String fecha = teclado.readLine();
    añoactual = Integer.parseInt(fecha);
} while (añoactual == 0);
    
edad = añoactual - añonacimiento;

    } while (edad < 0);

teclado.printf("Tu edad es " + edad + " años");

}


}