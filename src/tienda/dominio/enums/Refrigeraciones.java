package tienda.dominio.enums;

public enum Refrigeraciones {
    BEQUIET_LIGHTWINGS_140MM("Be Quiet!", "Be Quiet! Light Wings 140mm White", "Cooler FAN", 140, true, "Blanco", 118000d);

    private final String MARCA;
    private final String MODELO;
    private final String TIPO;
    private final Integer DIAMETRO;
    private final Boolean TIENE_RGB;
    private final String COLOR;
    private final Double PRECIO;

    Refrigeraciones(String marca, String modelo, String tipo, Integer diametro, Boolean tieneRgb, String color, Double precio) {
        MARCA = marca;
        MODELO = modelo;
        TIPO = tipo;
        DIAMETRO = diametro;
        TIENE_RGB = tieneRgb;
        COLOR = color;
        PRECIO = precio;
    }

    public String getMARCA() {
        return MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public Integer getDIAMETRO() {
        return DIAMETRO;
    }

    public Boolean getTIENE_RGB() {
        return TIENE_RGB;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public Double getPRECIO() {
        return PRECIO;
    }
}
