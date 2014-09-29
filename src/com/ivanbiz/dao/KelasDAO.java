/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Bank;
import com.ivanbiz.model.Kelas;

/**
 *
 * @author ivan
 */
public interface KelasDAO extends GenericDAO {

    public String getLastNoTransaksi() throws Exception;

    public String getDataPeserta(Kelas kelas, Bank bank) throws Exception;
}
