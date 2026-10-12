import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       System.out.println("Introduce tu edad:");
int edad = sc.nextInt();

System.out.println("Introduce tu nombre");
String nombre = sc.nextLine();

System.out.println("Tu nombre es " + nombre + " y tu edad + "+ edad +" años.");

    }
}
