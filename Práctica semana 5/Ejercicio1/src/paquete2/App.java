package paquete2;

import paquete1.Clase1; //La clase1 la podemos importar sin problema, porque lleva el modificador public
import paquete1.Clase2; // La clase2 no la puede importar, porque al no haberle puesto modificador, tiene el default, y solo se puede acceder a ella desde el mismo paquete


public class App {
    public static void main(String[] args) {
        Clase1 clase = new Clase1();
        clase.publ = 0; // El atributo con modificador es el único al que se puede acceder desde este paquete
        clase.publico(); // El método con modificador también es el único al que se puede acceder desde aquí

        clase.prot = "abcd";
        clase.protegido();
        clase.q = 1;
        clase.nada();
        clase.priv = "abcd";
        clase.privado(); //En el resto de casos, los atributos y los métodos no son visibles desde este paquete

    }
}
// Los modificadores de visibilidad sirven para controlar quién puede acceder a determinados atributos o métodos, para que no cualquiera pueda ver o cambiar el valor de un atributo o utilizar un método, o todo lo contrario, para asegurarse de que todo el mundo pueda trabajar con los datos definidos en otro sitio
//