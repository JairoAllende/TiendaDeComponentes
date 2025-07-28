package tienda.interfaz;

import tienda.dominio.enums.Almacenamientos;
import tienda.servicio.TiendaDeComponentes;

import java.util.Scanner;

public class Main {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final TiendaDeComponentes tiendaDeComponentes = new TiendaDeComponentes();

    public static void main(String[] args){

        menuPrincipal();
    }

    private static void menuPrincipal(){
        System.out.println("Bienvenido al Gestor de Componentes\nSeleccione una opcion\n");
        for (OpcionesMenu opcion: OpcionesMenu.values()) {
            System.out.println(opcion.ordinal()+1 + "- "+ opcion.getNombreOpcion());
        }
        int opcion = TECLADO.nextInt();
        switch (opcion){
            case 1 ->{

            }
        }
    }

    private static void menuAgregarComponente(){
        for (Almacenamientos opcion: Almacenamientos.values()) {
            System.out.println(opcion.ordinal()+1 + "- "+ opcion.getNombreOpcion());
        }
    }
}
