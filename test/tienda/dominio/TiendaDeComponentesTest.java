package tienda.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TiendaDeComponentesTest {
    @Test
    public void queExistaUnaTiendaDeComponentes(){
        TiendaDeComponentes tiendaDeComponentes = new TiendaDeComponentes();
        assertNotNull(tiendaDeComponentes);
    }

}
