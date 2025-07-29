package tienda.dominio.componentes;

import tienda.dominio.enums.PlacaDeVideos;

public class PlacaDeVideo extends Componente {

    private final String MARCA;
    private final String GPU;
    private final String MODELO;
    private final Integer VRAM;
    private final String TIPO_RAM;
    private final Integer CONSUMO_APROX;

    public PlacaDeVideo(PlacaDeVideos placaDeVideos) {
        super();
        this.MARCA = placaDeVideos.getMARCA();
        this.GPU = placaDeVideos.getGPU();
        this.MODELO = placaDeVideos.getMODELO();
        this.VRAM = placaDeVideos.getVRAM();
        this.TIPO_RAM = placaDeVideos.getTIPO_RAM();
        this.CONSUMO_APROX = placaDeVideos.getCONSUMO_APROX();
        this.precio = placaDeVideos.getPRECIO();
    }

    @Override
    public void esAbstracto() {

    }

    public String getMARCA() {
        return MARCA;
    }

    public String getGPU() {
        return GPU;
    }

    public String getMODELO() {
        return MODELO;
    }

    public Integer getVRAM() {
        return VRAM;
    }

    public String getTIPO_RAM() {
        return TIPO_RAM;
    }

    public Integer getCONSUMO_APROX() {
        return CONSUMO_APROX;
    }
}
