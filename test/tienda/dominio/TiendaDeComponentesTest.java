package tienda.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tienda.dominio.componentes.*;
import tienda.dominio.enums.Almacenamientos;
import tienda.dominio.enums.Gabinetes;
import tienda.dominio.enums.Procesadores;
import tienda.dominio.paquetes.Paquete;
import tienda.exceptions.CapacidadSuperadaException;
import tienda.exceptions.ComponenteNoEncontradoException;
import tienda.exceptions.PaqueteNoEncontradoException;
import tienda.servicio.TiendaDeComponentes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaDeComponentesTest {

    private TiendaDeComponentes tiendaDeComponentes;
    private Procesador ryzen33200g;
    private Componente ryzen55600g;

    @BeforeEach
    public void init(){
        this.tiendaDeComponentes = new TiendaDeComponentes();
        this.ryzen33200g = new Procesador(Procesadores.RYZEN_3_3200G);
        this.ryzen55600g = new Procesador(Procesadores.RYZEN_5_5600G);
        Procesador.resetearContador();
        Almacenamiento.resetearContador();
        Gabinete.resetearContador();
        Paquete.resetearContador();
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

    @Nested // Agregar otros componentes
    class AgregarComponentesAlStock{
        private TiendaDeComponentes tiendaDeComponentes = new TiendaDeComponentes();

        @BeforeEach
        public void init(){
            this.tiendaDeComponentes = new TiendaDeComponentes();
            Almacenamiento.resetearContador();
            Gabinete.resetearContador();
            Procesador.resetearContador();
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

            assertEquals("No se pueden almacenar más unidades de almacenamiento. Se alcanzo el limite en el deposito", exception.getMessage());
        }

        @Test
        public void dadoQueSeIntentaAgregarUnGabineteAlStockCuandoLoHagoObtengoUnResultadoPositivo() throws CapacidadSuperadaException {
            Componente pruebaComponente = new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350);

            Boolean almacenamientoAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente);

            assertTrue(almacenamientoAgregado);
        }

        @Test
        public void dadoQueSeIntentaAgregarMasGabinetesDeLosSoportadosPorLaCapacidadActualDeAlmacenamientoSeLanzaUnCapacidadSuperadaException() throws CapacidadSuperadaException {
            Componente pruebaComponente1 = new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350);
            Componente pruebaComponente2 = new Gabinete(Gabinetes.DEEPCOOL_MACUBE_110);
            Componente pruebaComponente3 = new Gabinete(Gabinetes.DEEPCOOL_CH260);
            Componente pruebaComponente4 = new Gabinete(Gabinetes.DEEPCOOL_CH260);

            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente1);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente2);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente3);

            Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente4));
            assertEquals("No se pueden almacenar más gabinetes. Se alcanzo el limite en el deposito", exception.getMessage());
        }
        //---------

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

            assertEquals("No se pueden almacenar más Procesadores. Se alcanzo el limite en el deposito", exception.getMessage());
        }
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

    @Test
    public void dadoQueSeDeseaEliminarUnComponenteDelStockCuandoIngresoUnTipoDeComponenteYUnIdValidoEntoncesObtengoUnResultadoPositivo() throws CapacidadSuperadaException, ComponenteNoEncontradoException {
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen33200g);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen55600g);

        Boolean componenteEliminado = this.tiendaDeComponentes.eliminarComponenteDeStock("Procesador", 1);

        assertTrue(componenteEliminado);
    }

    @Test
    public void  dadoQueSeDeseaEliminarUnComponenteDelStockCuandoIngresoUnTipoDeComponenteYUnIdNoValidoSeLanzaUnaComponenteNoEncontradoException() throws CapacidadSuperadaException {
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen33200g);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen55600g);

        Exception exception = assertThrows(ComponenteNoEncontradoException.class, ()-> this.tiendaDeComponentes.eliminarComponenteDeStock("Procesador", 3));

        assertEquals(exception.getMessage(), "El componente de la cateogria Procesador con el ID: 3 no existe");
    }

    @Test
    public void dadoQueExisteUnaTiendaDeComponentesPuedoCrearUnPaqueteConConComponentes(){
        Set<Componente> componentesAlPaquete = new HashSet<>();

        Boolean paqueteCreado = this.tiendaDeComponentes.crearUnPaquete(LocalDateTime.now(), componentesAlPaquete);

        assertTrue(paqueteCreado);
    }

    @Test
    public void dadoQueSeCreaUnPaqueteConComponentesCuandoObtengoLosPaquetesEstanOrdenadosPorFechaDeCreacion(){
        Set<Componente> componentesAlPaquete = new HashSet<>();
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        componentesAlPaquete.add(new Procesador(Procesadores.CORE_I5_12400));
        componentesAlPaquete.add(new Almacenamiento(Almacenamientos.DISCO_SOLIDO_256G_TEAM));
        LocalDateTime creacionDelPaquete1 = LocalDateTime.of(2025,7,18,18,15,10);
        LocalDateTime creacionDelPaquete2 = LocalDateTime.of(2025,7,18,18,20,10);
        LocalDateTime creacionDelPaquete3 = LocalDateTime.of(2025,7,18,18,22,10);

        this.tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);
        this.tiendaDeComponentes.crearUnPaquete(creacionDelPaquete2, componentesAlPaquete);
        this.tiendaDeComponentes.crearUnPaquete(creacionDelPaquete3, componentesAlPaquete);
        Set<Paquete> paquetesObtenidos = this.tiendaDeComponentes.getPaquetes();

        int contador = 0;
        for (Paquete paquete: paquetesObtenidos) {
            switch (contador) {
                case 0 -> {
                    assertEquals(creacionDelPaquete1, paquete.getCreacionDelPaquete());
                    contador++;
                }
                case 1 -> {
                    assertEquals(creacionDelPaquete2, paquete.getCreacionDelPaquete());
                    contador++;
                }
                case 2 -> assertEquals(creacionDelPaquete3, paquete.getCreacionDelPaquete());
            }
        }
    }

    @Test
    public void dadoQueExistenPaquetesConComponentesAlBuscarloPorSuIdObtengoElPaqueteBuscado() throws PaqueteNoEncontradoException {
        Set<Componente> componentesAlPaquete = new HashSet<>();
        LocalDateTime creacionDelPaquete1 = LocalDateTime.of(2025,7,18,18,15,10);
        LocalDateTime creacionDelPaquete2 = LocalDateTime.of(2025,7,18,18,20,10);
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete2, componentesAlPaquete);

        Paquete paqueteObtenido = tiendaDeComponentes.buscarPaquete(1);

        assertEquals(1, paqueteObtenido.getId());
    }

    @Test
    public void dadoQueExistenPaquetesConComponentesAlBuscarloPorUnIdInexistenteSeLanzaPaqueteNoEncontradoException(){
        Set<Componente> componentesAlPaquete = new HashSet<>();
        LocalDateTime creacionDelPaquete1 = LocalDateTime.of(2025,7,18,18,15,10);
        LocalDateTime creacionDelPaquete2 = LocalDateTime.of(2025,7,18,18,20,10);
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete2, componentesAlPaquete);

        Exception exception = assertThrows(PaqueteNoEncontradoException.class, ()-> this.tiendaDeComponentes.buscarPaquete(2));

        assertEquals(exception.getMessage(), "No se encontró ningún paquete con el Id: 2");
    }

    @Test
    public void dadoQueExistenPaquetesConUnGabineteNebula350UnHDDDSeagate2TBYUnProcesadorCOREI512400ObtengoUnPrecioFinalDe320960() throws PaqueteNoEncontradoException {
        Set<Componente> componentesAlPaquete = new HashSet<>();
        LocalDateTime creacionDelPaquete1 = LocalDateTime.of(2025,7,22,18,15,10);
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        componentesAlPaquete.add(new Almacenamiento(Almacenamientos.DISCO_RIGIDO_2TB_SEAGATE));
        componentesAlPaquete.add(new Procesador(Procesadores.CORE_I5_12400));
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);

        Double precioFinalObtenido = tiendaDeComponentes.buscarPaquete(0).getPrecioFinal();
        Double precioFinalEsperado = 320960d;

        assertEquals(precioFinalEsperado, precioFinalObtenido);
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