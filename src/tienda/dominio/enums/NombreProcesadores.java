package tienda.dominio.enums;

public enum NombreProcesadores {
    RYZEN_3_3200G("AMD", "Ryzen 3 3200g", 4, 4, 3.6, 4.0, 85300d),
    RYZEN_5_5600G("AMD","Ryzen 5 5600g",6,12,3.9,4.4, 168500d),
    CORE_I3_12100f("INTEL","Core I5 12100F",4,8,3.3,4.3, 117450d),
    CORE_I5_12400("INTEL","Core I5 12400",6,12,2.5,4.4, 200960d);

    private final String MARCA;
    private final String MODELO;
    private final Integer NUCLEOS;
    private final Integer HILOS;
    private final Double FRECUENCIA_BASE;
    private final Double FRECUENCIA_TURBO;
    private Double precio;

    NombreProcesadores(String marca, String modelo, Integer nucleos, Integer hilos, Double frecuenciaBase, Double frecuenciaTurbo, Double precio) {
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

    public Integer getHILOS() {
        return HILOS;
    }

    public Double getFRECUENCIA_BASE() {
        return FRECUENCIA_BASE;
    }

    public Double getFRECUENCIA_TURBO() {
        return FRECUENCIA_TURBO;
    }

    public Double precio(){
        return this.precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }
}
