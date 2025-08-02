package tienda.dominio.enums;

public enum Almacenamientos {

    DISCO_RIGIDO_1TB_ADATA(true, "Rigido", "Adata", "HDD ADATA 1TB", 1000, 2000, 1800, "USB 3.1", 90000d),
    DISCO_SOLIDO_2TB_ADATA(true, "Solido", "Adata", "SSD ADATA 2TB",2000, 3000, 2000, "USB 3.2", 225800d),
    DISCO_RIGIDO_2TB_SEAGATE(false, "Rigido", "Seagate", "HDD SEAGATE 2TB",2000, 1000, 500, "SATA", 83000d),
    DISCO_SOLIDO_256G_TEAM(false, "Solido", "Team", "SSD TEAM 256GB",256, 520, 430, "SATA", 25000d),
    DISCO_SOLIDO_1TB_WESTERNDIGITAL(false, "Rigido", "Western Digital","SSD WESTERN DIGITAL 1TB", 1000, 2400, 1850, "NVMe", 71000d),
    ;

    private final Boolean ES_EXTERNO;
    private final String TIPO;
    private final String MARCA;
    private final String MODELO;
    private final Integer CAPACIDAD_GIGAS;
    private final Integer VELOCIDAD_LECTURA;
    private final Integer VELOCIDAD_ESCRITURA;
    private final String TIPO_DE_CONEXION;
    private final Double PRECIO;

    Almacenamientos(Boolean ES_EXTERNO , String TIPO, String MARCA, String MODELO, Integer CAPACIDAD_GIGAS, Integer VELOCIDAD_LECTURA,Integer VELOCIDAD_ESCRITURA, String TIPO_DE_CONEXION, Double PRECIO) {
        this.ES_EXTERNO = ES_EXTERNO;
        this.TIPO = TIPO;
        this.MARCA = MARCA;
        this.MODELO = MODELO;
        this.CAPACIDAD_GIGAS = CAPACIDAD_GIGAS;
        this.VELOCIDAD_LECTURA = VELOCIDAD_LECTURA;
        this.VELOCIDAD_ESCRITURA = VELOCIDAD_ESCRITURA;
        this.TIPO_DE_CONEXION = TIPO_DE_CONEXION;
        this.PRECIO = PRECIO;
    }

    public Boolean getES_EXTERNO() {
        return ES_EXTERNO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public String getMODELO(){return MODELO;}

    public Integer getCAPACIDAD_GIGAS() {
        return CAPACIDAD_GIGAS;
    }

    public Integer getVELOCIDAD_LECTURA() {
        return VELOCIDAD_LECTURA;
    }

    public Integer getVELOCIDAD_ESCRITURA() {
        return VELOCIDAD_ESCRITURA;
    }

    public String getTIPO_DE_CONEXION() {
        return TIPO_DE_CONEXION;
    }

    public Double getPRECIO() {
        return PRECIO;
    }

    @Override
    public String toString() {
        return MODELO;
    }
}
