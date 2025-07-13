package tienda.dominio.componentes;

import tienda.dominio.enums.NombreProcesadores;

public class Procesador extends Componente {

    private final String MARCA;
    private final String MODELO;
    private final Integer HILOS;
    private final Double FRECUENCIA_BASE;
    private final Double FRECUENCIA_TURBO;

    public Procesador(NombreProcesadores procesador) {
        super();
        this.MARCA = procesador.getMARCA();
        this.MODELO = procesador.getMODELO();
        this.HILOS = procesador.getHILOS();
        this.FRECUENCIA_BASE = procesador.getFRECUENCIA_BASE();
        this.FRECUENCIA_TURBO = procesador.getFRECUENCIA_TURBO();
        this.precio = procesador.precio();
    }

    public String getMARCA() {
        return MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public Integer getHILOS() {
        return HILOS;
    }

    public Double getFRECUENCIA_BASE() {
        return FRECUENCIA_BASE;
    }

    public Double getFRECUENCIA_TURBO() {
        return FRECUENCIA_TURBO;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
