package tienda.dominio;

import tienda.dominio.componentes.Componente;
import tienda.dominio.componentes.Procesador;
import tienda.exceptions.CapacidadSuperadaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TiendaDeComponentes {
    private final Map<String, List<Componente>> stock = new TreeMap<>();
    private Integer capacidadActualDeProcesadores = 2;
    //-----------

    public TiendaDeComponentes(){
        this.stock.put("Componente", new ArrayList<>());
    }

    public Boolean agregarUnComponenteAlStock(Componente componente) throws CapacidadSuperadaException {


        switch (componente instanceof Procesador){

        }
    }

    //Cambiar después el parametro con un enum?
    public List<Componente> buscarComponentesPorCategoria(String procesador) {
        return this.stock.get(procesador);
    }
}
