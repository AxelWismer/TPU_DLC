package motor;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;

public class Controlador {
    String nombreCarpetaDocumentos = "DocumentosTP1";
    public Hashtable<String, Integer> documentosALeer = new Hashtable<>();

    String[] documentosEnCarpeta;

    Lector lector = new Lector();

    public Hashtable<String, Palabra> vocabulario = new Hashtable<>();

    public void iniciar() {
        //Inicia el controlador obteniendo todas sus variables
        //Variables necesarias:
        //  Listado de documentos en bd (ya leidos)
        //  Listado de documentos en la carpeta de documentos OK
        //  Listado de documentos para leer (para iterar)
        //  Listado de documentos para eliminar (para iterar)
        //  Listado de palabras en bd con si id
        //  Listado de palabras leídas generando su id para no consultar la bd

    }

    public String[] getDocumentosEnCarpeta(String nombreCarpeta) {
        File carpeta = new File(nombreCarpeta);
        String[] documentos = carpeta.list();
        if (documentos != null) {
            for (int i = 0; i < documentos.length; i++) {
                documentosALeer.put(documentos[i], i);
            }
        }
        return documentos;
    }

    public void agregarDocumentoAVocabulario(Integer documento, Hashtable<String, Integer> vocabularioDocumento) {
        Iterator<String> iterator = vocabularioDocumento.keySet().iterator();
        String NombrePalabra;
        while (iterator.hasNext()) {
            NombrePalabra = iterator.next();
            //Si el vocabulario contiene la palabra a agregar
            if (vocabulario.containsKey(NombrePalabra)) {
                //Agregar la palabra buscando su tf en vocabularioDocumento
                vocabulario.get(NombrePalabra).agregarDocumento(documento, vocabularioDocumento.get(NombrePalabra));
            }
            else {
                //Crea una nueva palabra, agrega el documento y la agrega al vocabulario
                Palabra palabra = new Palabra();
                palabra.agregarDocumento(documento, vocabularioDocumento.get(NombrePalabra));
                vocabulario.put(NombrePalabra, palabra);
            }
        }
    }

    public void armarIndiceInverso() {
        documentosEnCarpeta = getDocumentosEnCarpeta(nombreCarpetaDocumentos);
        for (int i = 0; i < documentosEnCarpeta.length; i++) {
            System.out.println("Documento" + "(" + (i + 1) + "): " + documentosEnCarpeta[i]);
            agregarDocumentoAVocabulario(documentosALeer.get(documentosEnCarpeta[i]), lector.armarVocabulario(documentosEnCarpeta[i]));
        }
        guardarIndiceInverso(vocabulario);
    }

    public void guardarIndiceInverso(Hashtable<String, Palabra> vocabulario) {
        //Guardar el indice inverso ya generado
    }

    public void armarIndicePorDocumento() {
        documentosEnCarpeta = getDocumentosEnCarpeta(nombreCarpetaDocumentos);
        Hashtable<String, Integer> vocabularioDocumento;
        for (int i = 0; i < documentosEnCarpeta.length; i++) {
            System.out.println("Documento" + "(" + (i + 1) + "): " + documentosEnCarpeta[i]);
            vocabularioDocumento = lector.armarVocabulario(documentosEnCarpeta[i]);
            guardarIndicePorDocumento(vocabularioDocumento);
        }
    }

    public void guardarIndicePorDocumento(Hashtable<String, Integer> vocabularioDocumento) {
        //Guarda el indice de cada documento a leer
    }
}
