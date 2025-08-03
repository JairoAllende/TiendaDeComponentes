package tienda.dominio.componentes;

import tienda.dominio.enums.Gabinetes;

public class Gabinete extends Componente {
    private static Integer contador = 0;
    private final String FACTOR_MOTHER;
    private final String TAMANIO_GABINETE;
    private final Double ANCHO;
    private final Double ALTO;
    private final Double PROFUNDIDAD;
    private final String FUENTE_ADMITIDA;
    private final String COLOR;

    public Gabinete(Gabinetes gabinete) {
        super();
        this.id = contador++;
        this.MODELO = gabinete.getMODELO();
        this.FACTOR_MOTHER = gabinete.getFACTOR_MOTHER();
        this.TAMANIO_GABINETE = gabinete.getTAMANIO_GABINETE();
        this.ANCHO = gabinete.getANCHO();
        this.ALTO = gabinete.getALTO();
        this.PROFUNDIDAD = gabinete.getPROFUNDIDAD();
        this.FUENTE_ADMITIDA = gabinete.getFUENTE_ADMITIDA();
        this.COLOR = gabinete.getCOLOR();
        this.precio = gabinete.getPRECIO();
    }
    @Override
    public void esAbstracto() {

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

    public static void resetearContador(){
        contador = 0;
    }
}
