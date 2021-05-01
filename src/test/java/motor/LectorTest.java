package motor;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class LectorTest {
    private Lector instance;

    @Before
    public void setUp(){
         System.out.println("* UtilsJUnit4Test: @Before method");
         instance = new Lector();
    }

    @org.junit.Test
    public void TestLectorArmarVocabulario() {
        //Crea una tabla para todos los documentos
        Controlador controlador = new Controlador();
        String[] documentos = controlador.getDocumentosEnCarpeta("DocumentosTP1");
        for (String documento : documentos) {
            instance.armarVocabulario("DocumentosTP1", documento);
        }
        //assertEquals(13473, instance.vocabulario.size());
    }
}
