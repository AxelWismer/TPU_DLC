package buscador;

import motor.Controlador;
import motor.Escritor;
import motor.Palabra;
import motor.Vocabulario;

public class Buscador {
    String archivoSerializacion = "DB/vocabulario";
    Escritor escritor = new Escritor();
    Controlador controlador = new Controlador();

    public String[] buscar(String[] palabras, int R) {
        //Recupera de base de dato un objeto vocabulario con las palabras encontradas en la bd
        Vocabulario vocabulario = escritor.leerIndicePorDocumento(palabras, archivoSerializacion);
        //Esta lista se deberia recuperar de la bd
        String[] posteo;

        for (String s : palabras) {
            if (vocabulario.vocabulario.containsKey(s)) {
                //Si existe la palabra la obtiene
                Palabra palabra = vocabulario.vocabulario.get(s);
            }
        }

        return null;

    }
}
