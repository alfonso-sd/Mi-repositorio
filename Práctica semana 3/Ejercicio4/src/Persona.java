import es.usal.progiii.tools.Esdia;

public class Persona {
    private String nombre = "Alfonso";
    private float pesoEnKg = 60;
    private float alturaEnCm = 171;

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
try { peso = Esdia.readFloat("Introduce el peso de la primera persona: ");
} catch (Exception e){
    System.err.println("Se ha producido un error.");
}
try { altura = Esdia.readFloat("Introduzca la altura de la primera persona: ");
} catch (Exception e){
    System.err.println("Se ha producido un error.");
}
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
            System.out.println("La persona más alta es " + Persona1.getNombre());
        }
        else{
            if (n3>n1) System.out.println("La persona más alta de las que has introducido es "+ Persona3.getNombre());
        else System.out.println("Las personas más altas son " + Persona1.getNombre() + " y " + Persona3.getNombre());
    }
    }

    if (n2>n1) {
        if (n2>n3) {
            System.out.println("La persona más alta de las que has introducido es " + Persona2.getNombre());
        }
        else{
            if (n3>n2) System.out.println("La persona más alta de las que has introducido es "+ Persona3.getNombre());
        else System.out.println("Las personas más altas son " + Persona2.getNombre() + " y " + Persona3.getNombre());
    }
    }

if (n1==n2) {
        if (n1>n3) {
            System.out.println("Las personas más altas son " + Persona1.getNombre() + " y " + Persona2.getNombre());
        }
        else{
            if (n3>n1) System.out.println("La persona más alta es "+ Persona3.getNombre());
        else System.out.println("Las tres personas miden lo mismo, " + n1);
    }
    }



Float p1 = Persona1.getPeso();
Float p2 = Persona2.getPeso();
Float p3 = Persona3.getPeso();

if (p1>p2) {
        if (p1>p3) {
            System.out.println("La persona que más pesa es " + Persona1.getNombre());
        }
        else{
            if (p3>p1) System.out.println("La persona que más pesa de las que has introducido es "+ Persona3.getNombre());
        else System.out.println("Las personas que más pesan son " + Persona1.getNombre() + " y " + Persona3.getNombre());
    }
    }

    if (p2>p1) {
        if (p2>p3) {
            System.out.println("La persona que más pesa de las que has introducido es " + Persona2.getNombre());
        }
        else{
            if (p3>p2) System.out.println("La persona que más pesa de las que has introducido es "+ Persona3.getNombre());
        else System.out.println("Las personas que más pesan son " + Persona2.getNombre() + " y " + Persona3.getNombre());
    }
    }

if (p1==p2) {
        if (p1>p3) {
            System.out.println("Las personas que más pesan son " + Persona1.getNombre() + " y " + Persona2.getNombre());
        }
        else{
            if (p3>p1) System.out.println("La persona que más pesa es "+ Persona3.getNombre());
        else System.out.println("Las tres personas pesan lo mismo, " + p1);
    }
    }
}

}
