public class Almacen {

    private Producto[] productos = new Producto[2];

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public Almacen (){
        for (int i =0 ; i<2 ; i++){
            productos[i] = new Producto();
        }
    }
    
}
