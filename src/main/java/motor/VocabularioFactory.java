/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

/**
 *
 * @author pigui
 */
public class VocabularioFactory {
    PalabraFactory pf;
    public VocabularioFactory(){
        pf= new PalabraFactory();
    }
    public Vocabulario fabricarVocabulario(String words[],int limit){
        Vocabulario v= new Vocabulario();
        if(words.length==0){return v;}
        int len=words.length;
        for(int i=0;i<len;i++){
            Palabra p=pf.fabricarPalabra(words[i],limit);
            v.vocabulario.put(words[i],p);
        }
        return v;
    }
    public Vocabulario fabricarVocabulario(String words[]){
        Vocabulario v= new Vocabulario();
        if(words.length==0){return v;}
        int len=words.length;
        for(int i=0;i<len;i++){
            Palabra p=pf.fabricarPalabra(words[i]);
            v.vocabulario.put(words[i],p);
        }
        return v;
    }
}
