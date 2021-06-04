package dbentities;

import java.util.Objects;

public class Palabra{
    int id;
    String  nombre;
    int maxtf;
    int iddoc;
    int cantdoc;
    public Palabra(){
        
    }

    @Override
    public String toString() {
        return "Palabra{" + "id=" + id + ", nombre=" + nombre + ", maxtf=" + maxtf + ", iddoc=" + iddoc + ", cantdoc=" + cantdoc + '}';
    }
    public Palabra(String nombre){
        this.nombre=nombre;
        cantdoc=0;
        maxtf=0;
    }
    public Palabra(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        cantdoc=0;
        maxtf=0;
    }
    public Palabra(int id,String nombre,int maxTf){
        this.id=id;
        this.nombre=nombre;
        this.maxtf=maxTf;
    }
    public Palabra(int id, String nombre, int maxtf, int iddoc, int cantdoc) {
        this.id = id;
        this.nombre = nombre;
        this.maxtf = maxtf;
        this.iddoc = iddoc;
        this.cantdoc = cantdoc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaxtf(int maxtf) {
        this.maxtf = maxtf;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public void setCantdoc(int cantdoc) {
        this.cantdoc = cantdoc;
    }
    public void sumDoc(){
        cantdoc++;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxtf() {
        return maxtf;
    }

    public int getIddoc() {
        return iddoc;
    }

    public int getCantdoc() {
        return cantdoc;
    }
    public void sumMaxTf(){
        maxtf++;
    }
    public void sumMaxTf(int tf){
        maxtf+=tf;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palabra other = (Palabra) obj;
        //return this.id==other.id;
        //return Objects.equals(this.id, other.id);
        return this.nombre.compareTo(other.nombre)==0;
    }
    
   
    private int hashi(){
        int ans=51;
        for(int i=0;i<this.nombre.length()-1;i++){
            ans=51*ans+this.nombre.charAt(i);
        }
        return ans;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + hashi();
        return hash;
    }
    

    
}