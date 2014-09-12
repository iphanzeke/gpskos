/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import com.ivanbiz.model.Perusahaan;

/**
 *
 * @author Shbt Peterpan
 */
public class GlobalSession {

    private Perusahaan perusahaan;

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(Perusahaan perusahaan) {
        this.perusahaan = perusahaan;
    }
}
