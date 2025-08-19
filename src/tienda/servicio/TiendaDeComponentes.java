package tienda.servicio;

import tienda.dominio.comparators.ComparadorPorPrecioAscendente;
import tienda.dominio.componentes.*;
import tienda.dominio.paquetes.Paquete;
import tienda.exceptions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class TiendaDeComponentes {
    private final Map<String, Set<Componente>> stock = new TreeMap<>();
    private Integer capacidadActualDeProcesadores = 2;
    private Integer capacidadActualDeAlmacenamientos = 5;
    private Integer capacidadActualDeGabinetes = 3;
    private Integer capacidadActualDeMemoriasRam = 4;
    private Integer capacidadActualDeMotherBoard = 3;
    private Integer capacidadActualDePlacasDeVideo = 5;
    private Integer capacidadActualDeRefrigeraciones = 4;
    private final Set<Paquete> paquetes = new TreeSet<>();

    public TiendaDeComponentes(){
        this.stock.put("Almacenamiento", new HashSet<>());
        this.stock.put("Gabinete", new HashSet<>());
        this.stock.put("MemoriaRam", new HashSet<>());
        this.stock.put("Motherboard", new HashSet<>());
        this.stock.put("PlacaDeVideo", new HashSet<>());
        this.stock.put("Procesador", new HashSet<>());
        this.stock.put("Refrigeracion", new HashSet<>());
    }

    public Boolean agregarUnComponenteAlStock(Componente componente) throws CapacidadSuperadaException {

        switch (componente.getCategoria()) {
            case "Almacenamiento" -> {
                if (this.capacidadActualDeAlmacenamientos >= 1) {
                    this.capacidadActualDeAlmacenamientos--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                } else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más unidades de almacenamiento. Se alcanzo el limite en el deposito");
                }
            }
            case "Gabinete" -> {
                if (this.capacidadActualDeGabinetes >= 1) {
                    this.capacidadActualDeGabinetes--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                } else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más gabinetes. Se alcanzo el limite en el deposito");
                }
            }
            case "MemoriaRam" -> {
                if (this.capacidadActualDeMemoriasRam >= 1) {
                    this.capacidadActualDeMemoriasRam--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                } else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más memorias ram. Se alcanzo el limite en el deposito");
                }
            }
            case "Motherboard" -> {
                if (this.capacidadActualDeMotherBoard >= 1) {
                    this.capacidadActualDeMotherBoard--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                } else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más motherboards. Se alcanzo el limite en el deposito");
                }
            }
            case "PlacaDeVideo" -> {
                if (this.capacidadActualDePlacasDeVideo >= 1){
                    this.capacidadActualDePlacasDeVideo--;
                    return  this.stock.get(componente.getCategoria()).add(componente);
                }else{
                    throw new CapacidadSuperadaException("No se pueden almacenar más placas de videos. Se alcanzo el limite en el deposito");
                }
            }
            case "Procesador" -> {
                if (this.capacidadActualDeProcesadores >= 1) {
                    this.capacidadActualDeProcesadores--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                } else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más Procesadores. Se alcanzo el limite en el deposito");
                }
            }
            case "Refrigeracion" ->{
                if(this.capacidadActualDeRefrigeraciones >= 1){
                    this.capacidadActualDeRefrigeraciones--;
                    return this.stock.get(componente.getCategoria()).add(componente);
                }else {
                    throw new CapacidadSuperadaException("No se pueden almacenar más Refrigeraciones. Se alcanzo el limite en el deposito");
                }
            }
            default -> {
                return false;
            }
        }
    }

    //Cambiar después el parametro con un enum?
    public Set<Componente> buscarComponentesPorCategoria(String componente) {
        return this.stock.get(componente);
    }

    public Componente buscarComponente(String categoria, Integer id) throws ComponenteNoEncontradoException {
        Set<Componente> componentes = buscarComponentesPorCategoria(categoria);

        for (Componente componente: componentes) {
            if(componente.getId().equals(id)){
                return componente;
            }
        }

        throw new ComponenteNoEncontradoException("No se ha encontrado ningún componente con ese Id");
    }

    public Boolean eliminarComponenteDeStock(String categoriaComponente, Integer idComponente) throws ComponenteNoEncontradoException {

        if(this.stock.get(categoriaComponente) != null){
            Predicate<Componente> mismoId = componenteStock -> componenteStock.getId().equals(idComponente);
            Set<Componente> componentes = this.stock.get(categoriaComponente);

            if(componentes.removeIf(mismoId)){
                return true;
            }else{
                throw new ComponenteNoEncontradoException("El componente de la cateogria " + categoriaComponente + " con el ID: " + idComponente + " no existe");
            }

        }else{
            return false;
        }
    }
    public Boolean crearUnPaquete(LocalDateTime creacionDelPaquete, Set<Componente> componentesAlPaquete){
        return this.paquetes.add(new Paquete(creacionDelPaquete, componentesAlPaquete));
    }

    public Paquete buscarPaquete(Integer idPaquete) throws PaqueteNoEncontradoException {

        for (Paquete paquete : this.paquetes) {
            if(paquete.getId().equals(idPaquete)){
                return paquete;
            }
        }

        throw new PaqueteNoEncontradoException("No se encontró ningún paquete con el Id: " + idPaquete);
    }

    public Set<Paquete> getPaquetes() {
        return this.paquetes;
    }

    public Set<Componente> buscarComponentesPorRangoDePrecio(Double precioMenor, Double precioMayor) {
        Set<Componente> componentesEnRango = new TreeSet<>(new ComparadorPorPrecioAscendente());

        stock.values().forEach(componentes -> {
            for (Componente componenteActual: componentes) {
                if(componenteActual.getPrecio() >= precioMenor && componenteActual.getPrecio() <= precioMayor){
                    componentesEnRango.add(componenteActual);
                }
            }
        });

        return componentesEnRango;
    }

    public void modificarPrecio(Componente componente, Double nuevoPrecio) throws PrecioInvalidoException {
        if(nuevoPrecio > 0){
            componente.setPrecio(nuevoPrecio);
        }else{
            throw new PrecioInvalidoException("El monto ingresado: " + nuevoPrecio + " es invalido. El monto debe ser mayor a 0");
        }

    }

    public void aplicarDescuento(Componente componente, String porcentajeDescuento) throws DescuentoInvalidoException {
        BigDecimal precioActual = new BigDecimal(componente.getPrecio().toString());
        BigDecimal porcentaje = new BigDecimal(porcentajeDescuento);

        if(porcentaje.intValue() > 0 && porcentaje.intValue() <= 100){
            BigDecimal descuento = precioActual.subtract(precioActual.multiply(porcentaje).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
            BigDecimal precioFinal = precioActual.subtract(descuento);
            componente.setPrecio(precioFinal.doubleValue());
        }else {
            throw new DescuentoInvalidoException("El descuento de: " + porcentajeDescuento +"% no es valido");
        }

    }

    public List<Class<? extends Componente>> obtenerCategoriasDeComponentes() {
        return List.of(
                Almacenamiento.class,
                Gabinete.class,
                MemoriaRam.class,
                Motherboard.class,
                PlacaDeVideo.class,
                Procesador.class,
                Refrigeracion.class
        );
    }

}
