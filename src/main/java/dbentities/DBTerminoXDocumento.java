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
public class DBTerminoXDocumento {
    BDHelper help;
    public DBTerminoXDocumento(){
        help= new BDHelper();
    }
    public void addTermXDoc(Documento d,Palabra p, int tf)throws SQLException{
        String cmd="INSERT INTO terminoxdocumento (idT,idD,tf) values("+p.getId()+","+d.getId()+","+tf+")";
        help.modificarRegistro(cmd);      
    }
    public String addTermXDocBatch(Documento d,Palabra p,int tf){
        return "INSERT INTO terminoxdocumento (idT,idD,tf) values("+p.getId()+","+d.getId()+","+tf+")";
    }
    public void addTermXDoc(Documento d,Palabra p)throws SQLException{
        String cmd="INSERT INTO terminoxdocumento (idT,idD,tf) values("+p.getId()+","+d.getId()+",0)";
        help.modificarRegistro(cmd);
    }
    public void addFrec(Documento d,Palabra p)throws SQLException{
        String cmd="UPDATE terminoxdocumento SET tf=tf+1 WHERE idT="+p.getId()+" and idD="+d.getId();
        help.modificarRegistro(cmd);
    }
    public void eliminarTxD(Documento d,Palabra p)throws SQLException{
        String cmd="DELETE FROM terminoxdocumento WHERE idT="+p.getId()+" and idD="+d.getId();
        help.modificarRegistro(cmd);       
    }
    public void eliminarTxD(Integer i)throws SQLException{
        String cmd="DELETE FROM terminoxdocumento WHERE idtxd="+i;
        help.modificarRegistro(cmd);       
    }
    public String cmdeliminarTxD(Integer i){
        return "DELETE FROM terminoxdocumento WHERE idtxd="+i;
    }
    
    public LinkedList<Integer> leerIdTerminoXDocumento()throws SQLException{
        String cmd ="select idtxd from terminoxdocumento";
        LinkedList<Integer> list = new LinkedList<>();
        ResultSet rs = help.leerDatos(cmd);
        
        while(rs.next()){
            Integer n=rs.getInt("idtxd");
            list.addLast(n);
            
        }
        help.cerrarConexion(rs);
        return list;
        
    }
    
}
