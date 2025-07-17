package tienda.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tienda.dominio.componentes.*;
import tienda.dominio.enums.Almacenamientos;
import tienda.dominio.enums.Gabinetes;
import tienda.dominio.enums.Procesadores;
import tienda.exceptions.CapacidadSuperadaException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaDeComponentesTest {

    private TiendaDeComponentes tiendaDeComponentes;
    private Procesador ryzen33200g;
    private Componente ryzen55600g;
    private Componente corei512100f;

    @BeforeEach
    public void init(){
        this.tiendaDeComponentes = new TiendaDeComponentes();
        this.ryzen33200g = new Procesador(Procesadores.RYZEN_3_3200G);
        this.ryzen55600g = new Procesador(Procesadores.RYZEN_5_5600G);
        this.corei512100f = new Procesador(Procesadores.CORE_I3_12100f);
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
            Componente pruebaComponenteProcesador = new Procesador(Procesadores.RYZEN_3_3200G);

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
            Componente pruebaComponenteAlmacenamiento = new Almacenamiento(Almacenamientos.DISCO_RIGIDO_2TB_SEAGATE);

            assertNotNull(pruebaComponenteAlmacenamiento);
        }

        @Test
        public void queSePuedaCrearUnaRefrigeracion(){
            Componente pruebaComponenteRefrigeracion = new Refrigeracion();

            assertNotNull(pruebaComponenteRefrigeracion);
        }

        @Test
        public void queSePuedaCrearUnGabinete(){
            Componente pruebaComponenteGabinete = new Gabinete(Gabinetes.DEEPCOOL_CH260);

            assertNotNull(pruebaComponenteGabinete);
        }
    }

    @Test
    public void dadoQueSeIntentaAgregarUnAlmacenamientoAlStockCuandoLoHagoObtengoUnResultadoPositivo() throws CapacidadSuperadaException {
        Componente pruebaComponente = new Almacenamiento(Almacenamientos.DISCO_RIGIDO_1TB_ADATA);

        Boolean almacenamientoAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente);

        assertTrue(almacenamientoAgregado);
    }

    @Test
    public void dadoQueSeIntentaAgregarMasAlmacenamientosDeLosSoportadosPorLaCapacidadActualDeAlmacenamientoSeLanzaUnCapacidadSuperadaException() throws CapacidadSuperadaException {
        Componente pruebaComponente1 = new Almacenamiento(Almacenamientos.DISCO_RIGIDO_2TB_SEAGATE);
        Componente pruebaComponente2 = new Almacenamiento(Almacenamientos.DISCO_SOLIDO_1TB_WESTERNDIGITAL);
        Componente pruebaComponente3 = new Almacenamiento(Almacenamientos.DISCO_RIGIDO_1TB_ADATA);
        Componente pruebaComponente4 = new Almacenamiento(Almacenamientos.DISCO_SOLIDO_2TB_ADATA);
        Componente pruebaComponente5 = new Almacenamiento(Almacenamientos.DISCO_SOLIDO_256G_TEAM);
        Componente pruebaComponente6 = new Almacenamiento(Almacenamientos.DISCO_SOLIDO_256G_TEAM);

        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente1);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente2);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente3);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente4);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente5);

        Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente6));

        assertEquals("No se pueden almacenar más componentes. Se alcanzo el limite en el deposito", exception.getMessage());
    }

    @Test
    public void dadoQueSeIntentaAgregarUnGabineteAlStockCuandoLoHagoObtengoUnResultadoPositivo() throws CapacidadSuperadaException {
        Componente pruebaComponente = new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350);

        Boolean almacenamientoAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente);

        assertTrue(almacenamientoAgregado);
    }

    @Test
    public void dadoQueSeIntentaAgregarUnProcesadorAlStockCuandoLoHagoObtengoUnResultadoPositivo() throws CapacidadSuperadaException {
        Componente pruebaComponente = new Procesador(Procesadores.CORE_I3_12100f);

        Boolean procesadorAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente);

        assertTrue(procesadorAgregado);
    }

    @Test
    public void dadoQueSeIntentaAgregarMasProcesadoresDeLosSoportadosPorLaCapacidadActualDeAlmacenamientoSeLanzaUnCapacidadSuperadaException() throws CapacidadSuperadaException {
        Componente pruebaComponente1 = new Procesador(Procesadores.RYZEN_3_3200G);
        Componente pruebaComponente2 = new Procesador(Procesadores.RYZEN_5_5600G);
        Componente pruebaComponente3 = new Procesador(Procesadores.CORE_I3_12100f);

        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente1);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente2);

        Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente3));

        assertEquals("No se pueden almacenar más componentes. Se alcanzo el limite en el deposito", exception.getMessage());
    }

   @Test
    public void dadoQueSeBuscanTodosLosComponentesDeUnaCategoriaCuandoHagoLaBusquedaObtengoUnaListaDeTodosLosComponentesDeEsaCategoria() throws CapacidadSuperadaException {
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen33200g);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen55600g);

        List<Componente> listaDeProcesadores = this.tiendaDeComponentes.buscarComponentesPorCategoria("Procesador");
        Integer procesadoresEsperados = 2;
        Integer procesadoresObtenidos = listaDeProcesadores.size();

        assertEquals(procesadoresEsperados, procesadoresObtenidos);
        assertTrue(listaDeProcesadores.contains(this.ryzen33200g));
        assertTrue(listaDeProcesadores.contains(this.ryzen55600g));
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