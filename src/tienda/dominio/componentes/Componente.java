package tienda.dominio.componentes;

public abstract class Componente {
    //Hacer una lista de precios para obtenerla desde el enum?
    protected Double precio;

    public abstract void esAbstracto();

    public Double getPrecio(){
        return this.precio;
    }
    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public String getCategoria(){
        return this.getClass().getSimpleName();
    }

}
