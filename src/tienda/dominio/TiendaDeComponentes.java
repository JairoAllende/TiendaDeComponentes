package tienda.dominio;

import tienda.dominio.componentes.Componente;
import tienda.exceptions.CapacidadSuperadaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TiendaDeComponentes {
    private final Map<String, List<Componente>> stock = new TreeMap<>();
    private Integer capacidadActualDeComponente = 2;

    public TiendaDeComponentes(){
        this.stock.put("Componente", new ArrayList<>());
    }

    public Boolean agregarUnComponenteAlStock(Componente componente) throws CapacidadSuperadaException {

        if(componente instanceof Componente && this.capacidadActualDeComponente >= 1){
            this.capacidadActualDeComponente--;
            return this.stock.get("Componente").add(componente);
        }else {
            throw new CapacidadSuperadaException("No se pudo agregar el componente. La capacidad actual de almacenamiento no es suficiente");
        }
    }
}
