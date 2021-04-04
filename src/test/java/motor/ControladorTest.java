package motor;

import org.junit.Before;
import static org.junit.Assert.*;

public class ControladorTest {
    private Controlador instance;

    @Before
    public void setUp() {
        System.out.println("* UtilsJUnit4Test: @Before method");
        instance = new Controlador();
    }

    @org.junit.Test
    public void TestGetDocumentosEnCarpeta() {
        String[] documentos = instance.getDocumentosEnCarpeta("DocumentosTP1");
        assertEquals(593, documentos.length);
        assertEquals(593, instance.documentosALeer.size());
        //Evalua que el primer elemento de los documentos exista en los documentos a leer con el id 0
        assertEquals(Integer.valueOf(0), instance.documentosALeer.get(documentos[0]));
        assertEquals(Integer.valueOf(20), instance.documentosALeer.get(documentos[20]));

        //System.out.println(Arrays.toString(documentos));
    }

    @org.junit.Test
    public void TestArmarIndiceInverso() {
        instance.armarIndiceInverso();
        System.out.println("Finalizado");
        assert instance.vocabulario.size() > 3000;
    }

    @org.junit.Test
    public void TestArmarIndicePorDocumento() {
        instance.armarIndicePorDocumento();
        System.out.println("Finalizado");
    }

}
