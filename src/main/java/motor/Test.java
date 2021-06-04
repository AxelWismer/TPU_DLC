package motor;

import java.io.*;
import java.util.Arrays;
import buscador.Buscador;
import buscador.Documentos;
import java.util.List;
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
//    Controlador controlador = new Controlador();
//        System.out.println(Arrays.toString(controlador.getDocumentosEnCarpeta("DocumentosTP1")));

        buscarPalabras();

    }
    private static void buscarPalabras(){
        Buscador b = new  Buscador();
        List list=b.buscar(new String[] {"a","no","oscura"}, 0);
        for(Object o : list){
            Documentos d=(Documentos)o;
            System.out.println(d.documentos);
        }
    }
}
