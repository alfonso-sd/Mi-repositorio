public class Modelo {
    
    private int numero1;
    private int numero2;
    private int suma;

    public int getNumero1 (){
        return numero1;
    }

    public int getNumero2 (){
        return numero2;
    }

    public void setNumero1 (int numero){
        this.numero1 = numero;
    }

    public void setNumero2 (int numero){
        this.numero2 = numero;
    }

    public int getSuma (){
        return suma;
    }

    public void calcularSuma (){
        this.suma = this.numero1 + this.numero2;
    }
}
