/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ivanbiz.model;

/**
 *
 * @author ivan
 */
public class DaftarKelas {
    private long id;
    private Kelas kelas;
    private Murid murid;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the kelas
     */
    public Kelas getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the murid
     */
    public Murid getMurid() {
        return murid;
    }

    /**
     * @param murid the murid to set
     */
    public void setMurid(Murid murid) {
        this.murid = murid;
    }
    
    
    
}
