import es.usal.progiii.tools.Esdia;

public class Persona {
    private String nombre;
    private float pesoEnKg;
    private float alturaEnCm;

    public Persona (String nombre, float pesoEnKg, float alturaEnCm) {
this.nombre = nombre;
this.pesoEnKg = pesoEnKg;
this.alturaEnCm = alturaEnCm;
}

public String getNombre() {
return this.nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public Float getAltura() {
return this.alturaEnCm;
}
public void setAltura(Float altura) {
this.alturaEnCm = altura;
}
public Float getPeso() {
return this.pesoEnKg;
}
public void setPeso(Float peso) {
this.pesoEnKg = peso;
}

public static void main(String[] args) {
    String nombre;
    Float peso = 0f;
    Float altura = 0f;

nombre = Esdia.readString("Introduce el nombre de la primera persona: ");
peso = Esdia.readFloat("Introduce el peso de la primera persona: ");
altura = Esdia.readFloat("Introduzca la altura de la primera persona: ");
Persona Persona1 = new Persona(nombre, peso, altura);

nombre = Esdia.readString("Introduce el nombre de la segunda persona: ");
peso = Esdia.readFloat("Introduce el peso de la segunda persona: ");
altura = Esdia.readFloat("Introduzca la altura de la segunda persona: ");
Persona Persona2 = new Persona(nombre, peso, altura);

nombre = Esdia.readString("Introduce el nombre de la tercera persona: ");
peso = Esdia.readFloat("Introduce el peso de la tercera persona: ");
altura = Esdia.readFloat("Introduzca la altura de la tercera persona: ");
Persona Persona3 = new Persona(nombre, peso, altura);

Float n1 = Persona1.getAltura();
Float n2 = Persona2.getAltura();
Float n3 = Persona3.getAltura();

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
