package tienda.dominio.componentes;

import tienda.dominio.enums.Procesadores;

public class Procesador extends Componente {

    private static int contador = 0;
    private final String MARCA;
    private final Integer HILOS;
    private final Double FRECUENCIA_BASE;
    private final Double FRECUENCIA_TURBO;

    public Procesador(Procesadores procesador) {
        super();
        this.id = contador++;
        this.MARCA = procesador.getMARCA();
        this.MODELO = procesador.getMODELO();
        this.HILOS = procesador.getHILOS();
        this.FRECUENCIA_BASE = procesador.getFRECUENCIA_BASE();
        this.FRECUENCIA_TURBO = procesador.getFRECUENCIA_TURBO();
        this.precio = procesador.getPRECIO();
    }

    @Override
    public void esAbstracto() {

    }
    public String getMARCA() {
        return MARCA;
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

    public static void resetearContador(){
        contador = 0;
    }

}
