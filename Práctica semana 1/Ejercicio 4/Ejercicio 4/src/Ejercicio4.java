import java.util.Scanner;

public class Ejercicio4{
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    System.out.println("Introduce el primer número, por favor: ");
    int n1 = sc.nextInt();
    System.out.println("Introduce el segundo número, por favor: ");
    int n2 = sc.nextInt();
    System.out.println("Introduce el tercer número, por favor: ");
    int n3 = sc.nextInt();
    
    if (n1>n2) {
        if (n1>n3) {
            System.out.println("El mayor número de los que has introducido es el primero, " + n1);
        }
        else{
            if (n3>n1) System.out.println("El mayor número de los que has introducido es el último, "+ n3);
        else System.out.println("El mayor número de los que has introducido son el primero y el último, " + n1);
    }
    }

    if (n2>n1) {
        if (n2>n3) {
            System.out.println("El mayor número de los que has introducido es el segundo, " + n2);
        }
        else{
            if (n3>n2) System.out.println("El mayor número de los que has introducido es el último, "+ n3);
        else System.out.println("El mayor número de los que has introducido son el segundo y el último, " + n2);
    }
    }

if (n1==n2) {
        if (n1>n3) {
            System.out.println("El mayor número de los que has introducido son el primero y el segundo, " + n1);
        }
        else{
            if (n3>n1) System.out.println("El mayor número de los que has introducido es el último, "+ n3);
        else System.out.println("Los tres números que has introducido son el mismo, " + n1);
    }
    }

    }
    }
