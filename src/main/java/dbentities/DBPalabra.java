/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author pigui
 */
public class DBPalabra {
    BDHelper help;
    public DBPalabra(){
        help= new BDHelper();
    }
    public void addPalabra(Palabra p)throws SQLException{
        String cmd="INSERT INTO termino (nombre,MaxTF,iddoc,cantDoc,idword) values('"+p.getNombre()+"',0,0,0,"+p.getId()+")";
        help.modificarRegistro(cmd);
    }
    public String addPalabraBatch(Palabra p,int iddoc){
        return "INSERT INTO termino (nombre,MaxTF,iddoc,cantDoc,idword) values('"+p.getNombre()+"',"+p.getMaxtf()+","+iddoc+",0,"+p.getId()+")";
    }
    public void addDoc(Palabra p)throws SQLException{
        String cmd="UPDATE termino SET cantDoc=cantDoc+1 WHERE idword="+p.getId();
        help.modificarRegistro(cmd);
    }
    public void modificarMaxTf(Palabra p,int tf,int iddoc)throws SQLException{
        String cmd= "UPDATE termino SET MaxTF="+tf+",iddoc="+iddoc+" WHERE idword="+p.getId();
        help.modificarRegistro(cmd);
    }
    public String cmdmodificarMaxTf(Palabra p,int tf,int iddoc){
        return "UPDATE termino SET MaxTF="+tf+",iddoc="+iddoc+" WHERE idword="+p.getId();
    }
    public String addDocBatch(Palabra p){
        return "UPDATE termino SET cantDoc=cantDoc+1 WHERE idword="+p.getId();
    }
    public void eliminarPalabra(Palabra p)throws SQLException{
        String cmd="DELETE FROM termino WHERE idword="+p.getId();
        help.modificarRegistro(cmd);
    }
    public void eliminarPalabra(Integer i)throws SQLException{
        String cmd="DELETE FROM termino WHERE idTermino="+i;
        help.modificarRegistro(cmd);
    }
    public String cmdeliminarPalabra(Integer i){
        return "DELETE FROM termino WHERE idTermino="+i;
    }
    public int lastIdAlter(){
        return help.leerLastIdAlter();
    }
    public LinkedList<Integer> leerIdTermino()throws SQLException{
        String cmd ="select idTermino from termino";
        LinkedList<Integer> list = new LinkedList<>();
        ResultSet rs = help.leerDatos(cmd);
        
        while(rs.next()){
            Integer n=rs.getInt("idTermino");
            list.addLast(n);
            
        }
        help.cerrarConexion(rs);
        return list;
        
    }
    public int leerLastId(){
        int id=-1;
        
        try{
            ResultSet rs = help.leerLastId("idTermino","termino");
            id=matId(rs);
            help.cerrarConexion(rs);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return id;
    }
    public int leerUltimoIdInsertado(){
        return help.leerUltimoIdTabla("termino","idword");
    }
    private int matId(ResultSet rs) throws SQLException{
        int id=-1;
 //       System.out.println(rs.getAsciiStream(1));
        while(rs.next()){
            id=rs.getInt("id");       
        }
        return id;
    }
    
}