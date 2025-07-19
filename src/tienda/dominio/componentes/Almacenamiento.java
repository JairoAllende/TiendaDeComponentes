package tienda.dominio.componentes;

import tienda.dominio.enums.Almacenamientos;

public class Almacenamiento extends Componente {

    private static Integer contador = 0;
    private final Boolean ES_EXTERNO;
    private final String TIPO;
    private final String MARCA;
    private final String MODELO;
    private final Integer CAPACIDAD_GIGAS;
    private final Integer VELOCIDAD_LECTURA;
    private final Integer VELOCIDAD_ESCRITURA;
    private final String TIPO_DE_CONEXION;

    public Almacenamiento(Almacenamientos almacenamiento) {
        super();
        this.id = contador++;
        this.ES_EXTERNO = almacenamiento.getES_EXTERNO();
        this.TIPO = almacenamiento.getTIPO();
        this.MARCA = almacenamiento.getMARCA();
        this.MODELO = almacenamiento.getMODELO();
        this.CAPACIDAD_GIGAS = almacenamiento.getCAPACIDAD_GIGAS();
        this.VELOCIDAD_LECTURA = almacenamiento.getVELOCIDAD_LECTURA();
        this.VELOCIDAD_ESCRITURA = almacenamiento.getVELOCIDAD_ESCRITURA();
        this.TIPO_DE_CONEXION = almacenamiento.getTIPO_DE_CONEXION();
        this.precio = almacenamiento.getPRECIO();
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

    public String getMOdelo(){
        return Modelo;
    }

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

    public static void resetearContador(){
        contador = 0;
    }

    @Override
    public void esAbstracto() {

    }
}
