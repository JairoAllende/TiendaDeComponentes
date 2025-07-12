package tienda.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TiendaDeComponentes {
    private final Map<String, List<Componente>> stock = new TreeMap<>();

    public TiendaDeComponentes(){
        this.stock.put("Componente", new ArrayList<>());
    }

    public Boolean agregarUnComponenteAlStock(Componente componente) {

        if(componente instanceof Componente){
            return this.stock.get("Componente").add(componente);
        }else {
            return false;
        }
    }
}
