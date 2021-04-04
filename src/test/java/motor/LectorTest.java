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
    public void TestLector() {
        instance.agregarPalabra("palabra1");
        instance.agregarPalabra("palabra2");
        instance.agregarPalabra("palabra1");

        assertEquals(2, instance.vocabulario.size());
        assertEquals(Integer.valueOf(2), instance.vocabulario.get("palabra1"));
        assertEquals(Integer.valueOf(1), instance.vocabulario.get("palabra2"));
    }

    @org.junit.Test
    public void TestLectorArmarVocabulario() {
        //Crea una tabla para todos los documentos
        Controlador controlador = new Controlador();
        String[] documentos = controlador.getDocumentosEnCarpeta("DocumentosTP1");
        ArrayList<Hashtable<String, Integer>> vocabulario = new ArrayList<>();
        for (String documento : documentos) {
            vocabulario.add(instance.armarVocabulario(documento));
        }
        assertEquals(593, vocabulario.size());
        //assertEquals(13473, instance.vocabulario.size());
    }

}
