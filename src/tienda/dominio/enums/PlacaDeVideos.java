package tienda.dominio.enums;

public enum PlacaDeVideos {
    ASUS_RTX3060_12GB("NVidea", "RTX3060", "Asus GeForce RTX3060 12GB GDDR6",12, "GDDR6", 180, 470000d),
    MSI_RTX5090_32GB("NVidea", "RTX5090", "MSI GeForce RTX5090 32GB GDDR7 Suprim Liquid",32, "GDDR7", 600, 4900000d),
    ASROCK_RX550_2GB("AMD", "RX550", "Asrock Radeon RX550 2GB GDDR5", 2, "GDDR5", 65, 68000d),
    ASROCK_RX9070XT_16GB("AMD", "RX9070XT", "Asrock Radeon RX9070XT 16GB GDDR6", 16, "GDDR6", 380, 1235000d);

    private final String MARCA;
    private final String GPU;
    private final String MODELO;
    private final Integer VRAM;
    private final String TIPO_RAM;
    private final Integer CONSUMO_APROX;
    private final Double PRECIO;

    PlacaDeVideos(String marca, String gpu, String modelo, Integer vram, String tipoRam, Integer consumoAprox, Double precio) {
        MARCA = marca;
        GPU = gpu;
        MODELO = modelo;
        VRAM = vram;
        TIPO_RAM = tipoRam;
        CONSUMO_APROX = consumoAprox;
        PRECIO = precio;
    }

    public String getMARCA() {
        return MARCA;
    }

    public String getGPU() {
        return GPU;
    }

    public String getMODELO(){
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

    public Double getPRECIO() {
        return PRECIO;
    }
}
