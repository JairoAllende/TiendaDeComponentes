package tienda.dominio.enums;

public enum Motherboards {

    ASROCK_A520_AM4("AMD", "Asrcok A520M-HDV AM4", "AM4", "M-ATX", "DDR4", 2, 76000d),
    ASUS_X870E_AM5("AMD", "Asus", "AM5", "ATX", "DDR5", 4, 1120550d),
    ASUS_B760M_RAPTOR_LAKE("Intel", "ASUS", "1700 Raptor Lake", "M-ATX","DDR5", 4, 210400d);
    ;

    private final String MARCA;
    private final String MODELO;
    private final String SOCKET;
    private final String FACTOR;
    private final String TIPO_MEMORIA;
    private final Integer CANTIDAD_SLOT_MEMORIA;
    private final Double PRECIO;

    Motherboards(String marca, String modelo, String socket, String factor, String tipoMemoria, Integer cantidadSlotMemoria, Double precio) {
        MARCA = marca;
        MODELO = modelo;
        SOCKET = socket;
        FACTOR = factor;
        TIPO_MEMORIA = tipoMemoria;
        CANTIDAD_SLOT_MEMORIA = cantidadSlotMemoria;
        PRECIO = precio;
    }

    public String getMARCA() {
        return MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public String getSOCKET() {
        return SOCKET;
    }

    public String getFACTOR() {
        return FACTOR;
    }

    public String getTIPO_MEMORIA() {
        return TIPO_MEMORIA;
    }

    public Integer getCANTIDAD_SLOT_MEMORIA() {
        return CANTIDAD_SLOT_MEMORIA;
    }

    public Double getPRECIO() {
        return PRECIO;
    }
}
