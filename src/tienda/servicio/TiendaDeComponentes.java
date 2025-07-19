package tienda.servicio;

import tienda.dominio.componentes.Componente;
import tienda.dominio.paquetes.Paquete;
import tienda.exceptions.CapacidadSuperadaException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class TiendaDeComponentes {
    private final Map<String, List<Componente>> stock = new TreeMap<>();
    private Integer capacidadActualDeProcesadores = 2;
    private Integer capacidadActualDeAlmacenamientos = 5;
    private Integer capacidadActualDeGabinetes = 3;
    private Set<Paquete> paquetes = new TreeSet<>();
    //-----------

    public TiendaDeComponentes(){
        this.stock.put("Almacenamiento", new ArrayList<>());
        this.stock.put("Gabinete", new ArrayList<>());
        this.stock.put("MemoriaRam", new ArrayList<>());
        this.stock.put("Motherboard", new ArrayList<>());
        this.stock.put("PlacaDeVideo", new ArrayList<>());
        this.stock.put("Procesador", new ArrayList<>());
        this.stock.put("Refrigeracion", new ArrayList<>());
    }

    public Boolean agregarUnComponenteAlStock(Componente componente) throws CapacidadSuperadaException {

        switch (componente.getCategoria()){
            case "Procesador":
                if(this.capacidadActualDeProcesadores >= 1){
                    this.capacidadActualDeProcesadores--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                }else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más Procesadores. Se alcanzo el limite en el deposito");
                }
            case "Almacenamiento":
                if (this.capacidadActualDeAlmacenamientos >= 1){
                    this.capacidadActualDeAlmacenamientos--;
                    return  this.stock.get(componente.getCategoria()).add(componente);
                }else{
                    throw new CapacidadSuperadaException("No se pueden almacenar más unidades de almacenamiento. Se alcanzo el limite en el deposito");
                }
            case "Gabinete":
                if(this.capacidadActualDeGabinetes >= 1){
                    this.capacidadActualDeGabinetes--;
                    return  this.stock.get(componente.getCategoria()).add(componente);
                }else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más gabinetes. Se alcanzo el limite en el deposito");
                }
            default:
                return false;
        }
    }

    //Cambiar después el parametro con un enum?
    public List<Componente> buscarComponentesPorCategoria(String componente) {

        return this.stock.get(componente);
    }

    public Boolean eliminarComponenteDeStock(String componente, Integer idComponente) {

        if(this.stock.get(componente) != null){
            Predicate<Componente> mismoId = componenteStock -> componenteStock.getId().equals(idComponente);

            return this.stock.get(componente).removeIf(mismoId);
        }else{
            return false;
        }
    }
    public Boolean crearUnPaquete(LocalDateTime creacionDelPaquete, Set<Componente> componentesAlPaquete) {
        return this.paquetes.add(new Paquete(creacionDelPaquete, componentesAlPaquete));
    }

    public Set<Paquete> getPaquetes() {
        return this.paquetes;
    }
}
