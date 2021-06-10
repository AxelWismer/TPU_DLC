/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbentities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pigui
 */
@Entity
public class terminoxdocumento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int idtxd;
    int idT;
    int idD;
    int tf;

    public terminoxdocumento() {
    }

    public terminoxdocumento(int idtxd, int idT, int idD, int tf) {
        this.idtxd = idtxd;
        this.idT = idT;
        this.idD = idD;
        this.tf = tf;
    }

    public terminoxdocumento(int idT, int idD, int tf) {
        this.idT = idT;
        this.idD = idD;
        this.tf = tf;
    }

    public int getIdtxd() {
        return idtxd;
    }

    public int getIdT() {
        return idT;
    }

    public int getIdD() {
        return idD;
    }

    public int getTf() {
        return tf;
    }

    public void setIdtxd(int idtxd) {
        this.idtxd = idtxd;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }
    
    
    
}
