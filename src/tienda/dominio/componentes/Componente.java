package tienda.dominio.componentes;

import java.util.Objects;

public abstract class Componente {
    //Hacer una lista de precios para obtenerla desde el enum?
    protected Double precio;
    protected Integer id;

    public abstract void esAbstracto();

    public Integer getId() {
        return this.id;
    }

    public Double getPrecio(){
        return this.precio;
    }
    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public String getCategoria(){
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Componente that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
