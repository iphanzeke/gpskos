/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Bank;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Pengajar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface KelasDAO extends GenericDAO {

    public String getLastNoTransaksi() throws Exception;

    public String getDataPeserta(Kelas kelas, Bank bank) throws Exception;

    public List getData(Date start, Date end) throws Exception;

    public List getData(Pengajar pengajar, Date dari, Date sampai) throws Exception;
}
