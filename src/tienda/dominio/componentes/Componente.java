package tienda.dominio.componentes;

import java.util.Objects;

public abstract class Componente {
    //Hacer una lista de precios para obtenerla desde el enum?
    protected Double precio;
    protected Integer id;
    protected String MODELO;

    public abstract void esAbstracto();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componente that = (Componente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", MODELO='" + MODELO + '\'' +
                '}';
    }

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

    public String getMODELO(){return this.MODELO;}
}
