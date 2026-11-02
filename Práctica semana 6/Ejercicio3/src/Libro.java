public class Libro {
    String título;
    String género;
    int longitud;

    public Libro (String título, String género, int longitud){
        this.título = título;
        this.género = género;
        this.longitud = longitud;        
    }

    public String getGénero() {
        return género;
    }

    public String getTítulo() {
        return título;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getEstadoComoString (){
        return "Libro [título=" + título + ", género=" + género + ", longitud=" + longitud + "]";
    }

}
