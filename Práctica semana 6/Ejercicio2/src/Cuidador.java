public class Cuidador {
    private String nombre;
    private String apellidos;
    private boolean formacionEnCuidadoAnimal;

    public String getApellidos() {
        return apellidos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFormacionEnCuidadoAnimal(boolean formacionEnCuidadoAnimal) {
        this.formacionEnCuidadoAnimal = formacionEnCuidadoAnimal;
    }
    public Cuidador (String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public String formacionString (){
        if (!this.formacionEnCuidadoAnimal) {
            return "No";
        } else {return "Sí";}
    }

}
