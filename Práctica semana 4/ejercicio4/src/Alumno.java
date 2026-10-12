import es.usal.progiii.tools.Esdia;

public class Alumno {

    private float parcial1;
    private float parcial2;
    private float examenFinal;

public Alumno (Float parcial1, Float parcial2, float examenFinal){
this.parcial1 = parcial1;
this.parcial2 = parcial2;
this.examenFinal = examenFinal;
}

public Float getParcial1 (){
    return this.parcial1;
}
public Float getParcial2 (){
    return this.parcial2;
}
public Float getExamenFinal (){
    return this.examenFinal;
}

public Float calcularNotaFinal(){
    float nota = (this.parcial1)/10 + (this.parcial2)/10 + 8*(this.examenFinal)/10;
    return nota;
}

    public static void main(String[] args) {
int i;
int numAlumnos;
float sumaParcial1 = 0;
float sumaParcial2 = 0;
float sumaExamenFinal = 0;
float sumaNotasFinales = 0;

numAlumnos = Esdia.readInt("¿Cuántos alumnos hay en el curso? ");
Alumno[] alumnos = new Alumno[numAlumnos];    

    for(i = 1; i<=numAlumnos ; i++){
        System.out.println("Alumno " + i + ":");
        float nota1 = Esdia.readFloat("Introduce la nota del primer parcial: ");
        float nota2 = Esdia.readFloat("Introduce la nota del segundo parcial: ");
        float notaExamenFinal = Esdia.readFloat("Introduce la nota del examen final: ");
        alumnos[i-1] = new Alumno(nota1, nota2, notaExamenFinal);

        sumaParcial1 += nota1;
        sumaParcial2 += nota2;
        sumaExamenFinal += notaExamenFinal;
        sumaNotasFinales += alumnos[i-1].calcularNotaFinal();
    }

     System.out.println("\nTABLA DE CALIFICACIONES");

        System.out.printf("%-10s %10s %10s %10s %12s%n",
                "Alumno", "Parcial 1", "Parcial 2",
                "Examen final", "Nota final");

        System.out.println(
                "---------------------------------------------------------------");

        for(i = 0; i< alumnos.length ; i++) {

            System.out.printf(String.format("%-10d %10.2f %10.2f %10.2f %12.2f%n", i + 1,
                    alumnos[i].getParcial1(),
                    alumnos[i].getParcial2(),
                    alumnos[i].getExamenFinal(),
                    alumnos[i].calcularNotaFinal()));
        }

        System.out.println(
                "---------------------------------------------------------------");

        // Calcular y mostrar las medias
        System.out.printf(String.format("%-10s %10.2f %10.2f %10.2f %12.2f%n",
                "Media",
                sumaParcial1 / numAlumnos,
                sumaParcial2 / numAlumnos,
                sumaExamenFinal / numAlumnos,
                sumaNotasFinales / numAlumnos));
    }
}
