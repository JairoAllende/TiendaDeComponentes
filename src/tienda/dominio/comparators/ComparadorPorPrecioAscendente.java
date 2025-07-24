package tienda.dominio.comparators;

import tienda.dominio.componentes.Componente;

import java.util.Comparator;

public class ComparadorPorPrecioAscendente implements Comparator<Componente> {

    @Override
    public int compare(Componente o1, Componente o2) {
        int porPrecio = o1.getPrecio().compareTo(o2.getPrecio());

        if(porPrecio == 0){
            return o1.getId().compareTo(o2.getId());
        }else{
            return porPrecio;
        }
    }
}
