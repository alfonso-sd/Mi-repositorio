public class Animal {
    private Cuidador cuidador;
    private String nombre;
    private String especie;
    private float peso;
    private float consumo;

    public float getConsumo() {
        return consumo;
    }
    public Cuidador getCuidador() {
        return cuidador;
    }
    public String getEspecie() {
        return especie;
    }
    public String getNombre() {
        return nombre;
    }
    public float getPeso() {
        return peso;
    }
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Animal(Cuidador cuidador, String nombre, String especie, Float consumo, Float peso){
        this.cuidador = cuidador;
        this.nombre = nombre;
        this.especie = especie;
        this.consumo = consumo;
        this.peso = peso;
    }

    public Float CosteDiario (Float precio){
        return (precio*this.consumo);
    }

    public String getEstadoComoString (){
        return "Animal [especie=" + especie + ", nombre=" + nombre + ", consumo= " + consumo + ", peso=" + peso + ", nombre del cuidador=" + cuidador.getNombre() + cuidador.getApellidos() + "]";
    }
}
