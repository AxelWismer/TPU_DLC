package motor;

import java.util.ArrayList;
import java.util.Hashtable;

public class Palabra {
    //Cantidad de documentos en los que se encuentra la palabra
    public int nr = 0;
    //Cantidad de apariciones maximas
    public int maxTf = 0;

    //Documentos que utilizan esa palabra ordenados de mayor a menor por su tf
    public Hashtable<Integer, ArrayList<Integer>> posteo = new Hashtable<>();

    public void agregarDocumento(Integer documento, int tf) {
        //Seteo de las variables de la palabra
        nr += 1;
        if (tf > maxTf) maxTf = tf;
        //Se ordenan los documentos segun su tf
        //Si el valor de tf existe
        if (posteo.containsKey(tf)) {
            //Agregar el documento solicitado al array
            posteo.get(tf).add(documento);
        }
        else {
            //Crear un nuevo array con el documento solicitado
            ArrayList<Integer> documentos = new ArrayList<>();
            documentos.add(documento);
            posteo.put(tf, documentos);
        }
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "nr=" + nr +
                ", maxTf=" + maxTf +
                ", posteo=" + posteo +
                '}';
    }
}
