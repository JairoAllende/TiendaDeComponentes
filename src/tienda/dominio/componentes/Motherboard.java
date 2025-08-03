package tienda.dominio.componentes;

import tienda.dominio.enums.Motherboards;

public class Motherboard extends Componente {

    private static Integer contador = 0;
    private final String MARCA;
    private final String SOCKET;
    private final String FACTOR;
    private final String TIPO_MEMORIA;
    private final Integer CANTIDAD_SLOT_MEMORIA;

    public Motherboard(Motherboards motherboards) {
        super();
        this.id = contador++;
        MARCA = motherboards.getMARCA();
        MODELO = motherboards.getMODELO();
        SOCKET = motherboards.getSOCKET();
        FACTOR = motherboards.getFACTOR();
        TIPO_MEMORIA = motherboards.getTIPO_MEMORIA();
        CANTIDAD_SLOT_MEMORIA = motherboards.getCANTIDAD_SLOT_MEMORIA();
        this.precio = motherboards.getPRECIO();
    }

    @Override
    public void esAbstracto() {

    }

    public String getMARCA() {
        return MARCA;
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

}
