package tienda.dominio.enums;

public enum MemoriasRam {
    GSKILL_8GB_3200MHZ(false, "DDR4", "GSKILL", 8, 3200, 24900d),
    TEAM_32GB_26666MHZ(true, "DDR4", "Team", 32, 2666,103700d),
    ADATA_24GB_9200MHZ(false, "DD5", "ADATA", 24, 9200,150000d);

    private final Boolean DE_NOTEBOOK;
    private final String TIPO;
    private final String MARCA;
    private final Integer CAPACIDAD;
    private final Integer FRECUENCIA;
    private final Double PRECIO;

    MemoriasRam(Boolean deNotebook, String tipo, String marca, Integer capacidad, Integer frecuencia, Double precio) {
        this.DE_NOTEBOOK = deNotebook;
        this.TIPO = tipo;
        this.MARCA = marca;
        this.CAPACIDAD = capacidad;
        this.FRECUENCIA = frecuencia;
        this.PRECIO = precio;
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

    public Double getPRECIO() {
        return PRECIO;
    }
}
