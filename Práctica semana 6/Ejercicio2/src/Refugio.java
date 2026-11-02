public class Refugio {
    private float precioAlimento = 3;
    private int numeroAnimales;
    Animal[] animales;

    public Animal[] getAnimales() {
        return animales;
    }
    public int getNumeroAnimales() {
        return numeroAnimales;
    }
    public float getPrecioAlimento() {
        return precioAlimento;
    }
    public void setAnimales() {
        this.animales = new Animal[this.numeroAnimales];
    }
    public void setNumeroAnimales(int numeroAnimales) {
        this.numeroAnimales = numeroAnimales;
    }
    public void setPrecioAlimento(float precioAlimento) {
        this.precioAlimento = precioAlimento;
    }

    public void nuevoAnimal(Cuidador cuidador, String nombre, String especie, Float consumo, Float peso, int posicion){
        animales[posicion] = new Animal(cuidador, nombre, especie, consumo, peso);
    }

}
