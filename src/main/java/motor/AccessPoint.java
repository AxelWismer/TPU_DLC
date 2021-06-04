/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import java.sql.ResultSet;

/**
 *
 * @author pigui
 */
public class AccessPoint {
    VocabularioFactory vf;
    public AccessPoint(){
        vf= new VocabularioFactory();
    }
    public Vocabulario crearVocabulario(String palabras[]){
        Vocabulario v= vf.fabricarVocabulario(palabras);
        return v;
    }

}
