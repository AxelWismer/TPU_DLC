package motor;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class PalabraTest {
    private Palabra instance;

    @Before
    public void setUp(){
        System.out.println("* UtilsJUnit4Test: @Before method");
        instance = new Palabra();
    }

    @org.junit.Test
    public void TestPalabra() {
        instance.agregarDocumento(1, 1);
        instance.agregarDocumento(2, 1);
        instance.agregarDocumento(3, 2);

        ArrayList<Integer> posteo = new ArrayList<>();
        posteo.add(1);
        posteo.add(2);

        assertArrayEquals(posteo.toArray(), instance.posteo.get(1).toArray());
        posteo = new ArrayList<>();
        posteo.add(3);

        assertArrayEquals(posteo.toArray(), instance.posteo.get(2).toArray());
        assertEquals(3, instance.nr);
        assertEquals(2, instance.maxTf);

        System.out.println(instance.toString());

    }
}
