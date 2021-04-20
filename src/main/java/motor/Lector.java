package motor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Lector {
    //Guarda todas las palabras que se encuentran en un documento
    //    public Hashtable<String, Palabra> vocabulario = new Hashtable<String, Palabra>();
    protected Hashtable<String, Integer> vocabulario = new Hashtable<>();

    public void agregarPalabra(String palabra){
        // Si el vocabulario ya contiene la palabra aumentar el tf en 1
        if (vocabulario.containsKey(palabra)){
            vocabulario.put(palabra, vocabulario.get(palabra) + 1);
        }
        else{
            // Sino crear la entrada con tf 1
            vocabulario.put(palabra, 1);
        }
    }

    public Hashtable<String,Integer> armarVocabulario(String carpeta, String documento){
        //Abrir el documento seleccionado
        Scanner scanner;
        try {
            scanner = new Scanner(new File(carpeta +  "/" + documento), "Cp1252");
        }
        catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            return null;
        }
        //Iterar el archivo obteniendo palabras
        String palabra;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int inicio = -1;

            for (int i = 0; i < line.length(); i++) {
                //Revisa que no se este analizando una palabra y que el caracter por el que se pasa sea una letra
                if (inicio == -1 && Character.isLetter(line.charAt(i))) {
                    inicio = i;
                }
                else {
                    //Si ya se encuentra iterando una palbra
                    if (inicio != -1 && !Character.isLetter(line.charAt(i)) && line.charAt(i) != '\'' ){
                        palabra = line.substring(inicio, i);
                        //System.out.println(palabra);
                        agregarPalabra(palabra.toLowerCase());
                        inicio = -1;
                    }
                }
            }
            if (inicio != -1) {
                palabra = line.substring(inicio);
                agregarPalabra(palabra.toLowerCase());
            }
        }
        return vocabulario;
    }
}
