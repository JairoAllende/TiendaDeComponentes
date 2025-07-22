package tienda.dominio.enums;
public enum Gabinetes {
    CHECKPOINT_NEBULA_350("Nebula 350","ITX,M-ATX,ATX", "Mid-Tower", 185d, 420d, 350d, "ATX", "Negro", 37000d),
    DEEPCOOL_MACUBE_110("Macube 110","M-ATX,ATX", "Mid-Tower", 225d, 431d, 400d, "ATX", "Blanco", 60000d),
    DEEPCOOL_CH260("CH260","M-ATX,ATX", "Mini-Tower", 225d, 312d, 438d, "ATX", "Blanco", 92000d);

    private final String MODELO;
    private final String FACTOR_MOTHER;
    private final String TAMANIO_GABINETE;
    private final Double ANCHO;
    private final Double ALTO;
    private final Double PROFUNDIDAD;
    private final String FUENTE_ADMITIDA;
    private final String COLOR;
    private final Double PRECIO;

    Gabinetes(String MODELO, String FACTOR_MOTHER, String TAMANIO_GABINETE, Double ANCHO, Double ALTO, Double PROFUNDIDAD, String FUENTE_ADMITIDA, String COLOR, Double PRECIO) {
        this.MODELO = MODELO;
        this.FACTOR_MOTHER = FACTOR_MOTHER;
        this.TAMANIO_GABINETE = TAMANIO_GABINETE;
        this.ANCHO = ANCHO;
        this.ALTO = ALTO;
        this.PROFUNDIDAD = PROFUNDIDAD;
        this.FUENTE_ADMITIDA = FUENTE_ADMITIDA;
        this.COLOR = COLOR;
        this.PRECIO = PRECIO;
    }

    public String getMODELO(){
        return this.MODELO;
    }

    public String getFACTOR_MOTHER() {
        return FACTOR_MOTHER;
    }

    public String getTAMANIO_GABINETE() {
        return TAMANIO_GABINETE;
    }

    public Double getANCHO() {
        return ANCHO;
    }

    public Double getALTO() {
        return ALTO;
    }

    public Double getPROFUNDIDAD() {
        return PROFUNDIDAD;
    }

    public String getFUENTE_ADMITIDA() {
        return FUENTE_ADMITIDA;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public Double getPRECIO() {
        return PRECIO;
    }
}
