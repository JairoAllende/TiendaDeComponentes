package tienda.interfaz;

public enum OpcionesMenuComponentes {
    //Mostrar - eliminar - Modificar Precio- Aplicar Descuento

    BUSCAR_COMPONENTES_CATEGORIA("Buscar componentes en stock por categoria"),
    ELIMINAR_COMPONENTE("Eliminar componente de stock"),
    MODIFICAR_PRECIO("Modificar precio de un componente"),
    APLICAR_DESCUENTO("Aplicar descuento a un componente");

    private final String NOMBRE_OPCION;

    OpcionesMenuComponentes(String nombreOpcion) {
        NOMBRE_OPCION = nombreOpcion;
    }

    public String getNOMBRE_OPCION() {
        return NOMBRE_OPCION;
    }
}
