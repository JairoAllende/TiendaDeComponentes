package tienda.dominio.comparators;

import tienda.dominio.componentes.Componente;

import java.util.Comparator;

public class ComparadorPorPrecio implements Comparator<Componente> {

    @Override
    public int compare(Componente o1, Componente o2) {
        int porPrecio = o2.getPrecio().compareTo(o1.getPrecio());

        if(porPrecio == 0){
            return o1.getId().compareTo(o2.getId());
        }else{
            return porPrecio;
        }
    }
}
