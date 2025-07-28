package tienda.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tienda.dominio.componentes.*;
import tienda.dominio.enums.*;
import tienda.dominio.paquetes.Paquete;
import tienda.exceptions.*;
import tienda.servicio.TiendaDeComponentes;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaDeComponentesTest {

    private TiendaDeComponentes tiendaDeComponentes;
    private Componente ryzen33200g;
    private Componente ryzen55600g;
    private Componente nebula350;
    private Componente coreI512400;
    private Componente ssd256;
    private Componente hdd2;


    @BeforeEach
    public void init(){
        this.tiendaDeComponentes = new TiendaDeComponentes();
        this.ryzen33200g = new Procesador(Procesadores.RYZEN_3_3200G);
        this.ryzen55600g = new Procesador(Procesadores.RYZEN_5_5600G);
        this.coreI512400 = new Procesador(Procesadores.CORE_I5_12400);
        this.nebula350 = new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350);
        this.ssd256 = new Almacenamiento(Almacenamientos.DISCO_SOLIDO_256G_TEAM);
        this.hdd2 = new Almacenamiento(Almacenamientos.DISCO_RIGIDO_2TB_SEAGATE);
        Almacenamiento.resetearContador();
        Gabinete.resetearContador();
        MemoriaRam.resetearContador();
        Procesador.resetearContador();
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
            Componente pruebaComponenteMotherboard = new Motherboard(Motherboards.ASROCK_A520_AM4);

            assertNotNull(pruebaComponenteMotherboard);
        }

        @Test
        public void queSePuedaCrearUnaPlacaDeVideo(){
            Componente pruebaComponentePlacaDeVideo = new PlacaDeVideo();

            assertNotNull(pruebaComponentePlacaDeVideo);
        }

        @Test
        public void queSePuedaCrearUnaMemoriaRam(){
            Componente pruebaComponentePlacaDeVideo = new MemoriaRam(MemoriasRam.GSKILL_8GB_3200MHZ);

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
        private Componente ssd256;
        private Componente team32GB;

        @BeforeEach
        public void init(){
            this.tiendaDeComponentes = new TiendaDeComponentes();
            this.ssd256 = new Almacenamiento(Almacenamientos.DISCO_SOLIDO_256G_TEAM);
            this.team32GB = new MemoriaRam(MemoriasRam.TEAM_32GB_26666MHZ);
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

            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente1);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente2);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente3);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente4);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente5);

            Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ssd256));

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

        @Test
        public void dadoQueSeIntentaAgregarUnaMemoriaRamAlStockCuandoLoHagoObtengoUnResultadoPositivo() throws CapacidadSuperadaException {

            Boolean memoriaRamAgregada = this.tiendaDeComponentes.agregarUnComponenteAlStock(this.team32GB);

            assertTrue(memoriaRamAgregada);
        }

        @Test
        public void dadoQueSeIntentaAgregarMasMemoriasRamDeLasSoportadasPorLaCapacidadActualDeAlmacenamientoSeLanzaUnCapacidadSuperadaException() throws CapacidadSuperadaException {
            this.tiendaDeComponentes.agregarUnComponenteAlStock(this.team32GB);
            this.tiendaDeComponentes.agregarUnComponenteAlStock(new MemoriaRam(MemoriasRam.TEAM_32GB_26666MHZ));
            this.tiendaDeComponentes.agregarUnComponenteAlStock(new MemoriaRam(MemoriasRam.ADATA_24GB_9200MHZ));
            this.tiendaDeComponentes.agregarUnComponenteAlStock(new MemoriaRam(MemoriasRam.ADATA_24GB_9200MHZ));

            Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(new MemoriaRam(MemoriasRam.ADATA_24GB_9200MHZ)));

            assertEquals(exception.getMessage(), "No se pueden almacenar más memorias ram. Se alcanzo el limite en el deposito");
        }

        @Test
        public void dadoQueSeIntentaAgregarUnaMotherBoardAlStockCuandoLoHagoObtengoUnResultadoPositivo() throws CapacidadSuperadaException {
            Boolean componenteAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(new Motherboard(Motherboards.ASROCK_A520_AM4));

            assertTrue(componenteAgregado);
        }

        @Test
        public void dadoQueSeIntentaAgregarMasMotherboardsDeLasSoportadasPorLaCapacidadActualDeAlmacenamientoSeLanzaUnCapacidadSuperadaException() throws CapacidadSuperadaException {
            this.tiendaDeComponentes.agregarUnComponenteAlStock(new Motherboard(Motherboards.ASROCK_A520_AM4));
            this.tiendaDeComponentes.agregarUnComponenteAlStock(new Motherboard(Motherboards.ASUS_B760M_RAPTOR_LAKE));
            this.tiendaDeComponentes.agregarUnComponenteAlStock(new Motherboard(Motherboards.ASUS_X870E_AM5));

            Exception exception = assertThrows(CapacidadSuperadaException.class, ()-> this.tiendaDeComponentes.agregarUnComponenteAlStock(new Motherboard(Motherboards.ASROCK_A520_AM4)));

            assertEquals(exception.getMessage(), "No se pueden almacenar más motherboards. Se alcanzo el limite en el deposito");
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

            assertEquals("No se pueden almacenar más Procesadores. Se alcanzo el limite en el deposito", exception.getMessage());
        }
    }

    @Test
    public void dadoQueSeBuscanTodosLosComponentesDeUnaCategoriaCuandoHagoLaBusquedaObtengoUnaListaDeTodosLosComponentesDeEsaCategoria() throws CapacidadSuperadaException {
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen33200g);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen55600g);

        Set<Componente> listaDeProcesadores = this.tiendaDeComponentes.buscarComponentesPorCategoria("Procesador");
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
        componentesAlPaquete.add(this.nebula350);
        componentesAlPaquete.add(this.coreI512400);
        componentesAlPaquete.add(this.ssd256);
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
        componentesAlPaquete.add(this.nebula350);
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
        componentesAlPaquete.add(this.nebula350);
        componentesAlPaquete.add(new Gabinete(Gabinetes.CHECKPOINT_NEBULA_350));
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete2, componentesAlPaquete);

        Exception exception = assertThrows(PaqueteNoEncontradoException.class, ()-> this.tiendaDeComponentes.buscarPaquete(2));

        assertEquals(exception.getMessage(), "No se encontró ningún paquete con el Id: 2");
    }

    @Test
    public void dadoQueExisteUnComponenteCuandoLeModificoElPrecioPorUnoValidoEntoncesElPrecioSeModifica() throws PrecioInvalidoException {
        tiendaDeComponentes.modificarPrecio(this.ssd256, 30000d);

        Double precioAnterior = 25000d;
        Double precioActual = 30000d;

        assertNotEquals(precioAnterior, this.ssd256.getPrecio());
        assertEquals(precioActual, this.ssd256.getPrecio());
    }

    @Test
    public void dadoQueExisteUnComponenteCuandoLeModificoElPrecioPorUnoNoValidoEntoncesSeLanzaPrecioInvalidoException(){
        Exception exception = assertThrows(PrecioInvalidoException.class, ()-> tiendaDeComponentes.modificarPrecio(this.ssd256, 0d));

        assertEquals(exception.getMessage(), "El monto ingresado: 0.0 es invalido. El monto debe ser mayor a 0");
    }

    @Test
    public void dadoQueExisteUnComponenteCuandoLeAplicoUnDescuentoValidoEntoncesElPrecioSeModifica() throws DescuentoInvalidoException {
        tiendaDeComponentes.aplicarDescuento(this.ryzen33200g, "50");

        Double precioAnterior = 85300d;
        Double precioActual = 42650d;

        assertNotEquals(precioAnterior, this.ryzen33200g.getPrecio());
        assertEquals(precioActual, this.ryzen33200g.getPrecio());
    }

    @Test
    public void dadoQueExisteUnComponenteCuandoIntentoAplicarUnDescuentoInvalidoSeLanzaDescuentoInvalidoException(){
        Exception exception = assertThrows(DescuentoInvalidoException.class, ()-> tiendaDeComponentes.aplicarDescuento(this.ryzen33200g, "-34"));

        assertEquals(exception.getMessage(), "El descuento de: -34% no es valido");
    }

    @Test
    public void dadoQueExisteUnPaqueteConComponentesCuandoObtengoLaListaDeComponentesDelPaqueteLosObtengoOrdenadosPorPrecioDescendentementeYPorIdSiEmpatan() throws PaqueteNoEncontradoException {
        Set<Componente> componentesAlPaquete = new HashSet<>();
        LocalDateTime creacionDelPaquete1 = LocalDateTime.of(2025,7,22,18,15,10);
        componentesAlPaquete.add(this.nebula350);
        componentesAlPaquete.add(this.hdd2);
        componentesAlPaquete.add(new Almacenamiento(Almacenamientos.DISCO_RIGIDO_2TB_SEAGATE));
        componentesAlPaquete.add(this.coreI512400);
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);

        Set<Componente> componentesDelPaquete = tiendaDeComponentes.buscarPaquete(0).getComponentes();
        Double precioEsperado1 = 200960d;
        Double precioEsperado2 = 83000d;
        Double precioEsperado3 = 83000d;
        Double precioEsperado4 = 37000d;

        int contador = 0;
        for (Componente componente: componentesDelPaquete) {
            switch (contador){
               case 0 -> {
                   assertEquals(precioEsperado1, componente.getPrecio());
                   contador++;
               }
               case 1 -> {
                   assertEquals(precioEsperado2, componente.getPrecio());
                   assertEquals(0,componente.getId());
                   contador++;
               }
               case 2 -> {
                   assertEquals(precioEsperado3, componente.getPrecio());
                   assertEquals(1,componente.getId());
                   contador++;
               }
               case 3 -> assertEquals(precioEsperado4, componente.getPrecio());
            }
        }
    }

    @Test
    public void dadoQueExistenPaquetesConUnGabineteNebula350UnHDDDSeagate2TBYUnProcesadorCOREI512400ObtengoUnPrecioFinalDe320960() throws PaqueteNoEncontradoException {
        Set<Componente> componentesAlPaquete = new HashSet<>();
        LocalDateTime creacionDelPaquete1 = LocalDateTime.of(2025,7,22,18,15,10);
        componentesAlPaquete.add(this.nebula350);
        componentesAlPaquete.add(this.hdd2);
        componentesAlPaquete.add(this.coreI512400);
        tiendaDeComponentes.crearUnPaquete(creacionDelPaquete1, componentesAlPaquete);

        Double precioFinalObtenido = tiendaDeComponentes.buscarPaquete(0).getPrecioFinal();
        Double precioFinalEsperado = 320960d;

        assertEquals(precioFinalEsperado, precioFinalObtenido);
    }

    @Test
    public void dadoQueExistenComponentesEnElStockCuandoBuscoComponentesEnUnRangoDePreciosObtengoUnaListaDeComponentesDentroDeEseRangoDePrecios() throws CapacidadSuperadaException {
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen55600g);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.ryzen33200g);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.nebula350);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(this.hdd2);
        this.tiendaDeComponentes.agregarUnComponenteAlStock(new Gabinete(Gabinetes.DEEPCOOL_CH260));

        Set<Componente> listaDeComponentes = this.tiendaDeComponentes.buscarComponentesPorRangoDePrecio(70000d, 130000d);

        int contador = 0;
        for (Componente componente: listaDeComponentes) {
            switch (contador){
                case 0 -> {
                    assertEquals(83000d, componente.getPrecio());
                    contador++;
                }
                case 1 -> {
                    assertEquals(85300d, componente.getPrecio());
                    contador++;
                }
                case 2 -> assertEquals(92000d, componente.getPrecio());
            }
        }
    }

}

/*

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