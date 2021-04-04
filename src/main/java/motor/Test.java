package motor;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
    //Test de un vocabulario
//        Lector vocabulario = new Lector("doc");
//        vocabulario.agregarPalabra("hola");
//        vocabulario.agregarPalabra("chau");
//        vocabulario.agregarPalabra("hola");
//
//        System.out.println(vocabulario.toString());
//
//        vocabulario.armarVocabulario("0ddc809a.txt");
////        vocabulario.armarVocabulario("0ddcl10.txt");
////        vocabulario.armarVocabulario("00ws110.txt");
//        System.out.println(vocabulario.toString());
//        System.out.println("cantidad de palabras: " + vocabulario.vocabulario.size());

    //Controlador
    Controlador controlador = new Controlador();
        System.out.println(Arrays.toString(controlador.getDocumentosEnCarpeta("DocumentosTP1")));

    }
}
