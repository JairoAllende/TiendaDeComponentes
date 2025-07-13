package tienda.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tienda.dominio.componentes.*;
import tienda.dominio.enums.NombreProcesadores;
import tienda.exceptions.CapacidadSuperadaException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            Componente pruebaComponenteProcesador = new Procesador(NombreProcesadores.RYZEN_3_3200G);

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
    public void dadoQueSeIntentaAgregarMasComponentesDeLosSoportadosPorLaCapacidadActualDeAlmacenamientoSeLanzaUnCapacidadSuperadaException() throws CapacidadSuperadaException {
        Componente pruebaComponente1 = new Componente();
        Componente pruebaComponente2 = new Componente();
        Componente pruebaComponente3 = new Componente();

        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente1);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente2);

        Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente3));

        assertEquals("No se pudo agregar el componente. La capacidad actual de almacenamiento no es suficiente", exception.getMessage());
    }

    @Test
    public void dadoQueSeBuscanTodosLosComponentesDeUnaCategoriaCuandoHagoLaBusquedaObtengoUnaListaDeTodosLosComponentesDeEsaCategoria() throws CapacidadSuperadaException {
        Componente pruebaProcesador = new Procesador(NombreProcesadores.RYZEN_3_3200G);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaProcesador);

        List<Componente> listaDeProcesadores = this.tiendaDeComponentes.buscarComponentesPorCategoria("Procesador");
        Integer procesadoresEsperados = 4;
        Integer procesadoresObtenidos = listaDeProcesadores.size();

        assertEquals(procesadoresEsperados, procesadoresObtenidos);

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