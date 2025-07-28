package tienda.dominio.componentes;

import tienda.dominio.enums.MemoriasRam;

public class MemoriaRam extends Componente {

    private static Integer contador = 0;
    private final Boolean DE_NOTEBOOK;
    private final String TIPO;
    private final String MARCA;
    private final String MODELO;
    private final Integer CAPACIDAD;
    private final Integer FRECUENCIA;

    public MemoriaRam(MemoriasRam memoriasRam) {
        super();
        this.id = contador++;
        this.DE_NOTEBOOK = memoriasRam.getDE_NOTEBOOK();
        this.TIPO = memoriasRam.getTIPO();
        this.MARCA = memoriasRam.getMARCA();
        this.MODELO = memoriasRam.getMODELO();
        this.CAPACIDAD = memoriasRam.getCAPACIDAD();
        this.FRECUENCIA = memoriasRam.getFRECUENCIA();
        this.precio = memoriasRam.getPRECIO();
    }

    public Boolean getDE_NOTEBOOK() {
        return DE_NOTEBOOK;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public Integer getCAPACIDAD() {
        return CAPACIDAD;
    }

    public Integer getFRECUENCIA() {
        return FRECUENCIA;
    }

    public static void resetearContador(){
        contador = 0;
    }
    @Override
    public void esAbstracto() {

    }
}
