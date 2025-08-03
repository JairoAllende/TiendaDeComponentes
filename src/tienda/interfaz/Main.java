package tienda.interfaz;

import tienda.dominio.componentes.*;
import tienda.dominio.enums.*;
import tienda.exceptions.CapacidadSuperadaException;
import tienda.servicio.TiendaDeComponentes;

import java.util.*;

public class Main {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final TiendaDeComponentes tiendaDeComponentes = new TiendaDeComponentes();

    public static void main(String[] args){

        menuPrincipal();
    }

    private static void menuPrincipal(){
        int opcionIngresada;
        System.out.println("Bienvenido al Gestor de Componentes\nIngrese el numero de la opcion deseada:\n");
        do {
            for (OpcionesMenuPrincipal opcion : OpcionesMenuPrincipal.values()) {
                System.out.println(opcion.ordinal() + 1 + "- " + opcion.getNOMBRE_OPCION());
            }
            opcionIngresada = TECLADO.nextInt();
            switch (opcionIngresada) {
                case 1 -> menuAgregarComponente();
                case 2 -> menuComponentes();
                case 3 -> menuPaquetes();
            }
        }while (opcionIngresada < 1 || opcionIngresada > OpcionesMenuPrincipal.values().length);
    }

    private static void menuAgregarComponente(){
        int indiceOpciones = 0;
        int opcionIngresada;
        Map < Integer, Enum<?>> componentes = new HashMap<>();

        do {
            System.out.println("Ingrese el numero del componente que desee agregar o el Nro. 0 si desea ir hacia atrás:\n");
            for (Almacenamientos opcion : Almacenamientos.values()) {
                System.out.println(++indiceOpciones + "- " + opcion.getMODELO());
                componentes.put(indiceOpciones, opcion);
            }
            for (Gabinetes opcion : Gabinetes.values()) {
                System.out.println(++indiceOpciones + "- " + opcion.getMODELO());
                componentes.put(indiceOpciones, opcion);
            }
            for (MemoriasRam opcion : MemoriasRam.values()) {
                System.out.println(++indiceOpciones + "- " + opcion.getMODELO());
                componentes.put(indiceOpciones, opcion);
            }
            for (Motherboards opcion : Motherboards.values()) {
                System.out.println(++indiceOpciones + "- " + opcion.getMODELO());
                componentes.put(indiceOpciones, opcion);
            }
            for (Procesadores opcion : Procesadores.values()) {
                System.out.println(++indiceOpciones + "- " + opcion.getMODELO());
                componentes.put(indiceOpciones, opcion);
            }

            opcionIngresada = TECLADO.nextInt();
            if(opcionIngresada != 0){
                Componente componente = crearComponente(componentes.getOrDefault(opcionIngresada, null));
                try {
                    tiendaDeComponentes.agregarUnComponenteAlStock(componente);
                    System.out.println("Se agrego el " + componentes.get(opcionIngresada).toString() + " al stock");
                    menuAgregarComponente();
                } catch (CapacidadSuperadaException e) {
                    throw new RuntimeException(e);
                }
            }
        }while (opcionIngresada < 0 || opcionIngresada > indiceOpciones);

        if(opcionIngresada == 0){
            menuPrincipal();
        }
    }

    private static void menuComponentes() {
        int opcionIngresada;
        do{
            System.out.println("Ingrese el numero de la opcion deseada o el Nro. 0 para ir hacia atrás\n");
            for (OpcionesMenuComponentes opcion : OpcionesMenuComponentes.values()){
                System.out.println(opcion.ordinal() + 1 + "- "+ opcion.getNOMBRE_OPCION());
            }
            opcionIngresada = TECLADO.nextInt();
            switch (opcionIngresada){
                case 1 -> buscarComponente();
                case 2 -> System.out.println("Eliminar componente");
                case 3 -> System.out.println("Modificar precio");
                case 4 -> System.out.println("Aplicar descuento");
            }
        }while (opcionIngresada < 0 || opcionIngresada > OpcionesMenuComponentes.values().length);

        if(opcionIngresada == 0){
            menuPrincipal();
        }
    }

    private static void menuPaquetes() {
    }

    private static Componente crearComponente(Enum<?> enumComponente) {
        Componente componente = null;

        switch (enumComponente.getClass().getSimpleName()){
            case "Almacenamientos" -> componente = new Almacenamiento((Almacenamientos) enumComponente);
            case "Gabinetes" -> componente =  new Gabinete((Gabinetes) enumComponente);
            case "MemoriasRam" -> componente =  new MemoriaRam((MemoriasRam) enumComponente);
            case "Motherboards" -> componente =  new Motherboard((Motherboards) enumComponente);
            case "PlacaDeVideos" -> componente =  new PlacaDeVideo((PlacaDeVideos) enumComponente);
            case "Procesadores" -> componente =  new Procesador((Procesadores) enumComponente);
        }

        return componente;
    }

    private static void buscarComponente(){
        int opcionIngresada = 0;
        List <Class<? extends Componente>> categoriasComponentes = List.of(
                Almacenamiento.class,
                Gabinete.class,
                MemoriaRam.class,
                Motherboard.class,
                PlacaDeVideo.class,
                Procesador.class,
                Refrigeracion.class
        );

        do {
            System.out.println("Ingrese el numero de la opcion deseada o el Nro. 0 para ir hacia atrás\n");
            for (Class<? extends Componente> categorias: categoriasComponentes) {
                System.out.println(++opcionIngresada + "- " + categorias.getSimpleName());
            }
            opcionIngresada = TECLADO.nextInt();
            Set<Componente> componentesPorCategoria = tiendaDeComponentes.buscarComponentesPorCategoria(categoriasComponentes.get(opcionIngresada-1).getSimpleName());
            for (Componente componente: componentesPorCategoria) {
                System.out.println("- " + componente.getMODELO());
            }
        }while (opcionIngresada < 0 || opcionIngresada > categoriasComponentes.size());

        if(opcionIngresada == 0){
            menuComponentes();
        }


    }
}
