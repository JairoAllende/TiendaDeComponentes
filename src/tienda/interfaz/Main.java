package tienda.interfaz;

import tienda.dominio.componentes.*;
import tienda.dominio.enums.*;
import tienda.exceptions.CapacidadSuperadaException;
import tienda.exceptions.ComponenteNoEncontradoException;
import tienda.exceptions.DescuentoInvalidoException;
import tienda.exceptions.PrecioInvalidoException;
import tienda.servicio.TiendaDeComponentes;

import java.util.*;

public class Main {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final TiendaDeComponentes tiendaDeComponentes = new TiendaDeComponentes();

    public static void main(String[] args){
        //Seguir con el menu para modificar el precio
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
                    System.out.println("\n" + e.getMessage() +"\n");
                    menuAgregarComponente();
                } catch (NullPointerException e){
                    menuAgregarComponente();
                }
            }
        }while (opcionIngresada < 0 || opcionIngresada > indiceOpciones);

        if(opcionIngresada == 0){
            menuPrincipal();
        }
    }

    private static Componente crearComponente(Enum<?> enumComponente) {
        Componente componente = null;

        try{
            switch (enumComponente.getClass().getSimpleName()){
                case "Almacenamientos" -> componente = new Almacenamiento((Almacenamientos) enumComponente);
                case "Gabinetes" -> componente =  new Gabinete((Gabinetes) enumComponente);
                case "MemoriasRam" -> componente =  new MemoriaRam((MemoriasRam) enumComponente);
                case "Motherboards" -> componente =  new Motherboard((Motherboards) enumComponente);
                case "PlacaDeVideos" -> componente =  new PlacaDeVideo((PlacaDeVideos) enumComponente);
                case "Procesadores" -> componente =  new Procesador((Procesadores) enumComponente);
            }
        }catch (NullPointerException e){
            System.err.println("Ingrese una opción valida\n");
        }

        return componente;
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
                case 2 -> eliminarComponente();
                case 3 -> modificarPrecioComponente();
                case 4 -> aplicarDescuentoComponente();
            }
        }while (opcionIngresada < 0 || opcionIngresada > OpcionesMenuComponentes.values().length);

        if(opcionIngresada == 0){
            menuPrincipal();
        }
    }

    private static void buscarComponente(){
        int opcionIngresada = 0;
        List <Class<? extends Componente>> categoriasComponentes = mostrarListaCategoriasDeComponentes(opcionIngresada);

        do {
            opcionIngresada = TECLADO.nextInt();
            try{
                Set<Componente> componentesPorCategoria = tiendaDeComponentes.buscarComponentesPorCategoria(categoriasComponentes.get(opcionIngresada-1).getSimpleName());

                if(componentesPorCategoria.isEmpty()){
                    System.err.println("No hay componentes de la categoria " + categoriasComponentes.get(opcionIngresada-1).getSimpleName());
                }else {
                    System.out.println("Componentes en stock: ");
                    for (Componente componente: componentesPorCategoria) {
                        System.out.println("- " + componente.toString());
                    }
                }

                do {
                    System.out.println("\nIngrese 0 para ir hacia atrás:");
                    opcionIngresada = TECLADO.nextInt();
                    if(opcionIngresada == 0){
                        buscarComponente();
                    }
                }while (opcionIngresada != 0);
            }catch (ArrayIndexOutOfBoundsException e){
                menuComponentes();
            }

        }while (opcionIngresada < 0 || opcionIngresada > categoriasComponentes.size());
    }

    private static void eliminarComponente(){
        int opcionCategoria = 0;
        int opcionId;
        List <Class<? extends Componente>> categoriasComponentes = mostrarListaCategoriasDeComponentes(opcionCategoria);

        opcionCategoria = TECLADO.nextInt();

        if(opcionCategoria == 0){
            menuComponentes();
        }

        if(opcionCategoria > categoriasComponentes.size() || opcionCategoria < 0){
            System.err.println("Ingrese una opcion correcta\n");
            eliminarComponente();
        }

        try {
            System.out.println("Ingrese el id del componente que desea eliminar");
            opcionId = TECLADO.nextInt();
            Boolean componenteEliminado = tiendaDeComponentes.eliminarComponenteDeStock(categoriasComponentes.get(opcionCategoria-1).getSimpleName(), opcionId);
            if (componenteEliminado){
                System.out.println("Se elimino el componente de la categoria " + categoriasComponentes.get(opcionCategoria-1).getSimpleName() + " con el Id:" + opcionId + "\n");
                eliminarComponente();
            }
        }catch (ComponenteNoEncontradoException e) {
            System.err.println(e.getMessage() + "\n");
            eliminarComponente();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Ingrese una opcion valida");
        }
    }

    private static void modificarPrecioComponente(){
        int opcionCategoria = 0;
        List <Class<? extends Componente>> categoriasComponentes = mostrarListaCategoriasDeComponentes(opcionCategoria);

        opcionCategoria = TECLADO.nextInt();

        if (opcionCategoria == 0){
            menuComponentes();
        }

        if(opcionCategoria > categoriasComponentes.size() || opcionCategoria < 0){
            System.err.println("Ingrese una opcion correcta\n");
            modificarPrecioComponente();
        }

        try {
            int opcionId;
            double precioComponente;
            System.out.println("Ingrese el id del componente:");

            opcionId = TECLADO.nextInt();
            Componente componente = tiendaDeComponentes.buscarComponente(categoriasComponentes.get(opcionCategoria-1).getSimpleName(), opcionId);

            System.out.println("Ingrese el nuevo precio del componente: ");
            precioComponente = TECLADO.nextDouble();

            tiendaDeComponentes.modificarPrecio(componente, precioComponente);

            System.out.println("El precio del componente: " + componente + " se modifico correctamente. Precio actual " + componente.getPrecio() + "$\n");

            do {
                System.out.println("Ingrese 1 para modificar otro precio o 0 para ir al menu de Componentes");
                opcionId = TECLADO.nextInt();

                if (opcionId == 1){
                    modificarPrecioComponente();
                }

                if(opcionId == 0){
                    menuComponentes();
                }
            }while (opcionId != 1 && opcionId != 0);

        }catch (ComponenteNoEncontradoException e) {
            System.err.println(e.getMessage() + "\n");
            modificarPrecioComponente();
        }catch (PrecioInvalidoException e){
            System.err.println(e.getMessage() + " \n");
            modificarPrecioComponente();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Ingrese una opcion valida");
        }
    }

    private static void aplicarDescuentoComponente(){
        int opcionCategoria = 0;
        List <Class<? extends Componente>> categoriasComponentes = mostrarListaCategoriasDeComponentes(opcionCategoria);

        opcionCategoria = TECLADO.nextInt();

        if (opcionCategoria == 0){
            menuComponentes();
        }

        if(opcionCategoria > categoriasComponentes.size() || opcionCategoria < 0){
            System.err.println("Ingrese una opcion correcta\n");
            aplicarDescuentoComponente();
        }

        try {
            int opcionId;
            String porcentajeDescuento;

            System.out.println("Ingrese el id del componente:");
            opcionId = TECLADO.nextInt();
            Componente componente = tiendaDeComponentes.buscarComponente(categoriasComponentes.get(opcionCategoria-1).getSimpleName(), opcionId);

            System.out.println("Ingrese el porcentaje de descuento a aplicar");
            porcentajeDescuento = TECLADO.next();
            tiendaDeComponentes.aplicarDescuento(componente, porcentajeDescuento);

            System.out.println("Se aplico el descuento a: " + componente + ".Descuento aplicado: " + porcentajeDescuento + ". Precio actual: " + componente.getPrecio() + "$\n");

            do {
                System.out.println("Ingrese 1 aplicar otro descuento o 0 para ir al menu de Componentes");
                opcionId = TECLADO.nextInt();

                if (opcionId == 1){
                    aplicarDescuentoComponente();
                }

                if(opcionId == 0){
                    menuComponentes();
                }
            }while (opcionId != 1 && opcionId != 0);

        }catch (ComponenteNoEncontradoException e) {
            System.err.println(e.getMessage() + "\n");
            aplicarDescuentoComponente();
        }catch (DescuentoInvalidoException e){
            System.err.println(e.getMessage() + " \n");
            aplicarDescuentoComponente();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Ingrese una opcion valida");
        }catch (NumberFormatException e){
            System.err.println("Debe ingresar un número\n");
            aplicarDescuentoComponente();
        }
    }

    private static List <Class<? extends Componente>> mostrarListaCategoriasDeComponentes(Integer opcionCategoria){
        List <Class<? extends Componente>> categoriasComponentes = tiendaDeComponentes.obtenerCategoriasDeComponentes();

        System.out.println("Ingrese el numero de la categoria del componente o el Nro. 0 para ir hacia atrás\n");
        for (Class<? extends Componente> categorias: categoriasComponentes) {
            System.out.println(++opcionCategoria + "- " + categorias.getSimpleName());
        }

        return categoriasComponentes;
    }

    private static void menuPaquetes() {
    }
}
