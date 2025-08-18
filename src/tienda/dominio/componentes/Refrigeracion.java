package tienda.dominio.componentes;

import tienda.dominio.enums.Refrigeraciones;

public class Refrigeracion extends Componente {

    private static Integer contador = 0;
    private final String MARCA;
    private final String TIPO;
    private final Integer DIAMETRO;
    private final Boolean TIENE_RGB;
    private final String COLOR;

    public Refrigeracion(Refrigeraciones refrigeraciones) {
        super();
        this.id = contador++;
        this.MARCA = refrigeraciones.getMARCA();
        this.MODELO = refrigeraciones.getMODELO();
        this.TIPO = refrigeraciones.getTIPO();
        this.DIAMETRO = refrigeraciones.getDIAMETRO();
        this.TIENE_RGB = refrigeraciones.getTIENE_RGB();
        this.COLOR = refrigeraciones.getCOLOR();
        this.precio = refrigeraciones.getPRECIO();
    }

    @Override
    public void esAbstracto() {

    }

    public static Integer getContador() {
        return contador;
    }

    public String getMARCA() {
        return MARCA;
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
}
