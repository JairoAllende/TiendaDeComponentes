package tienda.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TiendaDeComponentesTest {

    private TiendaDeComponentes tiendaDeComponentes;

    @BeforeEach
    public void init(){
        this.tiendaDeComponentes = new TiendaDeComponentes();
    }

    @Test
    public void queExistaUnaTiendaDeComponentes(){
        TiendaDeComponentes pruebaTiendaDeComponentes = new TiendaDeComponentes();
        assertNotNull(pruebaTiendaDeComponentes);
    }
    @Nested
    class CreacionDeComponentes{
        @Test
        public void queSePuedaCrearUnProcesador(){
            Componente pruebaComponenteProcesador = new Procesador();

            assertNotNull(pruebaComponenteProcesador);
        }

        @Test
        public void queSePuedaCrearUnaMotherboard(){
            Componente pruebaComponenteMotherboard = new Motherboard();

            assertNotNull(pruebaComponenteMotherboard);
        }

        @Test
        public void queSePuedaCrearUnaPlacaDeVideo(){
            Componente pruebaComponentePlacaDeVideo = new PlacaDeVideo();

            assertNotNull(pruebaComponentePlacaDeVideo);
        }

        @Test
        public void queSePuedaCrearUnaMemoriaRam(){
            Componente pruebaComponentePlacaDeVideo = new MemoriaRam();

            assertNotNull(pruebaComponentePlacaDeVideo);
        }

        @Test
        public void queSePuedaCrearUnAlmacenamiento(){
            Componente pruebaComponenteAlmacenamiento = new Almacenamiento();

            assertNotNull(pruebaComponenteAlmacenamiento);
        }

        @Test
        public void queSePuedaCrearUnaRefrigeracion(){
            Componente pruebaComponenteRefrigeracion = new Refrigeracion();

            assertNotNull(pruebaComponenteRefrigeracion);
        }

        @Test
        public void queSePuedaCrearUnGabinete(){
            Componente pruebaComponenteGabinete = new Gabinete();

            assertNotNull(pruebaComponenteGabinete);
        }
    }

    @Test
    public void agregarUnComponenteAlStock(){
        Componente pruebaComponente = new Componente();

        Boolean componenteAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente);

        assertTrue(componenteAgregado);
    }



}
/*✅ 1. Gestión de componentes
        Quiero poder:

        Agregar un componente nuevo indicando:

        Nombre

        Categoría (por ejemplo: Procesador, Memoria RAM, Placa de video)

        Marca

        Precio

        Listar todos los componentes en el sistema

        Buscar componentes por nombre o categoría

        Eliminar un componente si fue mal cargado

        ✅ 2. Armado de paquetes
        Quiero poder:

        Crear un paquete con uno o más componentes seleccionados del inventario

        Ver el contenido del paquete (componentes y total en $)

        Guardar el paquete en un archivo .txt (uno por paquete o todos juntos, como prefieras)

        Leer los paquetes guardados desde el archivo

        ✅ 3. Interfaz del sistema
        Quiero un menú de consola claro que me permita elegir acciones fácilmente

        Cada acción debería pedirme los datos necesarios y confirmar si fue exitosa

        ✅ 4. Extras opcionales (más adelante)
        No es urgente, pero en el futuro me gustaría:

        Exportar datos a CSV

        Tener control de stock

        Registrar qué empleado creó cada paquete

        Agregar validaciones (por ejemplo, que el precio no sea negativo)
 */