package buscador;

import motor.Controlador;
import motor.Escritor;
import motor.Vocabulario;
import org.junit.Before;
import static org.junit.Assert.*;


public class BuscadorTest {
    private Buscador instance;

    @Before
    public void setUp() {
        System.out.println("* UtilsJUnit4Test: @Before method");
        instance = new Buscador();
    }

    @org.junit.Test
    public void InitialTest(){
        String archivoSerializacion = "DB/vocabulario";
        Escritor escritor = new Escritor();
        Vocabulario vocabulario = escritor.leerIndicePorDocumento(null, archivoSerializacion);
        System.out.println(vocabulario.vocabulario.size());
        assertTrue(vocabulario.vocabulario.size() > 10000);
    }

    @org.junit.Test
    public void buscarTest(){
        instance.buscar(new String[]{"a", "the", "at", "adseawd"}, 3);
        instance.buscar(new String[]{"a", "the", "at", "adseawd"}, 5);
        instance.buscar(new String[]{"a", "the", "at", "adseawd"}, 7);
        //Valor de R mayor al de la lista
        instance.buscar(new String[]{"a", "the", "at", "adseawd"}, 300);
    }
}
