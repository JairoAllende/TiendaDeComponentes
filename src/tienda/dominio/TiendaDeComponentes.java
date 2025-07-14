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
        this.stock.put("Procesador", new ArrayList<>());
    }

    public Boolean agregarUnComponenteAlStock(Componente componente) throws CapacidadSuperadaException {


        switch (componente.getCategoria()){
            case "Procesador":
                if(this.capacidadActualDeProcesadores >= 1){
                    this.capacidadActualDeProcesadores--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                }else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más procesadores. Se alcanzo el limite de almacenamiento");
                }

        }

        return null;
    }

    //Cambiar después el parametro con un enum?
    public List<Componente> buscarComponentesPorCategoria(String procesador) {
        return this.stock.get(procesador);
    }
}
