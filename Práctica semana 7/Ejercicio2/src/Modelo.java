public class Modelo {
    private Almacen[] almacenes =  new Almacen[5];

    double sum = 0;

    public void setAlmacenes(Almacen[] almacenes) {
        this.almacenes = almacenes;
    }

    public Almacen[] getAlmacenes() {
        return almacenes;
    }

    public void calcularIngresosTotales(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<2; j++){
                this.sum = this.sum + (almacenes[i].getProductos()[j].getNumVentas()*almacenes[i].getProductos()[j].getPrecio());
            }
        }
    }

    public double getIngresosTotales(){
        return sum;
    }

    public Modelo(){
        for(int i = 0 ; i<5 ; i++){
            almacenes[i] = new Almacen();
        }
    }
}
