package tienda.dominio.paquetes;

import tienda.dominio.componentes.Componente;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Paquete implements Comparable<Paquete>{
    private static Integer contador = 0;
    private final Integer id;
    private final LocalDateTime creacionDelPaquete;
    private Set<Componente> componentesDelPaquete;

    public Paquete(LocalDateTime creacionDelPaquete, Set<Componente> componentesDelPaquete) {
        this.id = contador++;
        this.creacionDelPaquete = creacionDelPaquete;
        this.componentesDelPaquete = new HashSet<>(componentesDelPaquete);
    }

    public static void resetearContador(){
        contador = 0;
    }

    public LocalDateTime getCreacionDelPaquete(){
        return  this.creacionDelPaquete;
    }

    public Integer getId() {
        return this.id;
    }

    public Double getPrecioFinal() {
        Double precio = 0d;
        for (Componente componente : this.componentesDelPaquete) {
            precio += componente.getPrecio();
        }
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paquete paquete)) return false;
        return Objects.equals(id, paquete.id) && Objects.equals(creacionDelPaquete, paquete.creacionDelPaquete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creacionDelPaquete);
    }

    @Override
    public int compareTo(Paquete o) {
        int porFecha =  this.creacionDelPaquete.compareTo(o.creacionDelPaquete);

        if(porFecha == 0){
            return  this.id.compareTo(o.id);
        }else{
            return porFecha;
        }
    }
}
