package tienda.dominio.enums;

public enum NombreProcesadores {
    RYZEN_3_3200G("AMD", "Ryzen 3 3200g", 4, 4, 3.6, 4.0);

    private final String MARCA;
    private final String MODELO;
    private final Integer NUCLEOS;
    private final Integer HILOS;
    private final Double FRECUENCIA_BASE;
    private final Double FRECUENCIA_TURBO;

    NombreProcesadores(String marca, String modelo, Integer nucleos, Integer hilos, Double frecuenciaBase, Double frecuenciaTurbo) {
        this.MARCA = marca;
        this.MODELO = modelo;
        this.NUCLEOS = nucleos;
        this.HILOS = hilos;
        this.FRECUENCIA_BASE = frecuenciaBase;
        this.FRECUENCIA_TURBO = frecuenciaTurbo;
    }

    public String getMARCA() {
        return MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public Integer getNUCLEOS() {
        return NUCLEOS;
    }

    public String getHILOS() {
        return HILOS;
    }

    public Double getFRECUENCIA_BASE() {
        return FRECUENCIA_BASE;
    }

    public String getFRECUENCIA_TURBO() {
        return FRECUENCIA_TURBO;
    }
}
