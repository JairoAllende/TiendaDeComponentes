package tienda.interfaz;

import tienda.dominio.enums.*;
import tienda.servicio.TiendaDeComponentes;

import java.util.Scanner;

public class Main {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final TiendaDeComponentes tiendaDeComponentes = new TiendaDeComponentes();

    public static void main(String[] args){

        menuPrincipal();
    }

    private static void menuPrincipal(){
        int opcionIngresada;
        System.out.println("Bienvenido al Gestor de Componentes\nSeleccione una opcion:\n");
        do {
            for (OpcionesMenu opcion : OpcionesMenu.values()) {
                System.out.println(opcion.ordinal() + 1 + "- " + opcion.getNombreOpcion());
            }
            System.out.println("Ingrese el numero de la opcion deseada:");
            opcionIngresada = TECLADO.nextInt();
            switch (opcionIngresada) {
                case 1 -> {
                    menuAgregarComponente();
                }
            }
        }while (opcionIngresada < 1 || opcionIngresada > 3);
    }

    private static void menuAgregarComponente(){
        int indice = 0;
        int opcionIngresada;

        do {
            System.out.println("Ingrese el numero del componente que desee agregar o 0 si desea ir hacia atrás:\n");
            for (Almacenamientos opcion : Almacenamientos.values()) {
                System.out.println(++indice + "- " + opcion.getMODELO());
            }
            for (Gabinetes opcion : Gabinetes.values()) {
                System.out.println(++indice + "- " + opcion.getMODELO());
            }
            for (MemoriasRam opcion : MemoriasRam.values()) {
                System.out.println(++indice + "- " + opcion.getMODELO());
            }
            for (Motherboards opcion : Motherboards.values()) {
                System.out.println(++indice + "- " + opcion.getMODELO());
            }
            for (Procesadores opcion : Procesadores.values()) {
                System.out.println(++indice + "- " + opcion.getMODELO());
            }
            opcionIngresada = TECLADO.nextInt();
        }while (opcionIngresada < 0 || opcionIngresada > indice);

        if(opcionIngresada == 0){
            menuPrincipal();
        }
    }
}
