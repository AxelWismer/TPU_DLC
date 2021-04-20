package motor;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;

public class Controlador {
    String nombreCarpetaDocumentos = "DocumentosTP1";
    public Hashtable<String, Integer> documentosALeer = new Hashtable<>();

    String[] documentosEnCarpeta;

    Lector lector = new Lector();

    public Vocabulario vocabulario = new Vocabulario();

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

    //Manejo del indice inverso
    public void armarIndiceInverso() {
        //Genera el indice de la forma en que se debera guardar y acceder en la busqueda
        documentosEnCarpeta = getDocumentosEnCarpeta(nombreCarpetaDocumentos);
        for (int i = 0; i < documentosEnCarpeta.length; i++) {
            System.out.println("Documento" + "(" + (i + 1) + "): " + documentosEnCarpeta[i]);
            vocabulario.agregarDocumentoAVocabulario(documentosALeer.get(documentosEnCarpeta[i]),
                    lector.armarVocabulario(nombreCarpetaDocumentos, documentosEnCarpeta[i]));
        }
        vocabulario.guardar();
    }

    //Manejo del indice por documento
    public void armarIndiceDeDocumento(String documento){
        System.out.println(documento);
        Hashtable<String, Integer> vocabularioDocumento =
                lector.armarVocabulario(nombreCarpetaDocumentos, documento);
        guardarIndicePorDocumento(vocabularioDocumento);
    }

    public void armarIndicePorDocumento() {
        //Genera un indice por documento de la forma en que es leido
        documentosEnCarpeta = getDocumentosEnCarpeta(nombreCarpetaDocumentos);
        System.out.println("Generando indice de documentos...");
        for (int i = 0; i < documentosEnCarpeta.length; i++) {
            System.out.print("Documento" + "(" + (i + 1) + "): ");
            armarIndiceDeDocumento(documentosEnCarpeta[i]);
        }
    }

    public void guardarIndicePorDocumento(Hashtable<String, Integer> vocabularioDocumento) {
        //Guarda el indice de cada documento a leer
    }
}
