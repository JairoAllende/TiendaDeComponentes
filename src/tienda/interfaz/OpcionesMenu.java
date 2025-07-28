package tienda.interfaz;

public enum OpcionesMenu {

    AGREGAR_COMPONENTE_STOCK("Agregar componente al stock"),
    COMPONENTES("Componentes"), // Subopciones:Agregar Componente - Mostrar - eliminar - Modificar Precio- Aplicar Descuento
    PAQUETES("Paquetes"),
    ; // Subopciones: Crear - Mostrar paquetes - Buscar paquetes

    private final String nombreOpcion;

    OpcionesMenu(String nombreOpcion){
        this.nombreOpcion = nombreOpcion;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }
}
