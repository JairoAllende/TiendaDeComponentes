package tienda.interfaz;

public enum OpcionesMenuPrincipal {

    AGREGAR_COMPONENTE_STOCK("Agregar componente al stock"),
    COMPONENTES("Componentes"), // Subopciones:Agregar Componente - Mostrar - eliminar - Modificar Precio- Aplicar Descuento
    PAQUETES("Paquetes"),
    ; // Subopciones: Crear - Mostrar paquetes - Buscar paquetes

    private final String NOMBRE_OPCION;

    OpcionesMenuPrincipal(String nombreOpcion){
        this.NOMBRE_OPCION = nombreOpcion;
    }

    public String getNOMBRE_OPCION() {
        return NOMBRE_OPCION;
    }
}
