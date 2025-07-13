package tienda.dominio.componentes;

public abstract class Componente {

    protected Double precio;

    public  abstract void setPrecio(Double precio);

    public String getCategoria(){
        return this.getClass().getSimpleName();
    }

}
