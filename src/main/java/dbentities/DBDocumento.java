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
public class DBDocumento {
    BDHelper help;
    public DBDocumento(){
        help = new BDHelper();
    }
    public void addDoc(Documento d)throws SQLException{
        String cmd="INSERT INTO documento (nombre,words,iddoc) values('"+d.getNombre()+"',"+d.getWords()+","+d.getId()+")";
        help.modificarRegistro(cmd);
    }
    public String addDocBatch(Documento d){
        return "INSERT INTO documento (nombre,words,iddoc) values('"+d.getNombre()+"',"+d.getWords()+","+d.getId()+")";
    }
    public void addWord(Documento d)throws SQLException{
        String cmd="UPDATE documento SET words=words+1 WHERE iddoc="+d.getId();
        help.modificarRegistro(cmd);
    }
    public void deleteDoc(Documento d)throws SQLException{
        String cmd="DELETE FROM documento WHERE iddoc="+d.getId();
        help.modificarRegistro(cmd);
    }
    public void deleteDoc(Integer i)throws SQLException{
        String cmd="DELETE FROM documento WHERE id="+i;
        help.modificarRegistro(cmd);
    }
    public String cmddeleteDoc(Integer i){
        return "DELETE FROM documento WHERE id="+i;
    } 
    public LinkedList<Integer> leerIdDocumento()throws SQLException{
        String cmd ="select id from documento";
        LinkedList<Integer> list = new LinkedList<>();
        ResultSet rs = help.leerDatos(cmd);
        
        while(rs.next()){
            Integer n=rs.getInt("id");
            list.addLast(n);
            
        }
        help.cerrarConexion(rs);
        return list;
        
    }
    public int leerUltimoIdInsertado(){
        return help.leerUltimoIdTabla("documento", "iddoc");
    }
    public int lastId(){
       int id=-1;
        
        try{
            ResultSet rs = help.leerLastId("id","documento");
            id=matId(rs);
            help.cerrarConexion(rs);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return id;
    }
    public int lastIdAlter(){
        return help.leerLastIdAlter();
    }
    private int matId(ResultSet rs) throws SQLException{
        int id=-1;
        while(rs.next()){
            id=rs.getInt("id");       
        }
        return id;
    }
}
