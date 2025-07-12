package tienda.dominio;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    public void agregarUnComponenteAlStock(){
        Componente pruebaComponente = new Componente();

        Boolean componenteAgregado = this.tiendaDeComponentes.agregarUnComponenteAlStock(pruebaComponente);

        assertTrue(componenteAgregado);
    }

}
