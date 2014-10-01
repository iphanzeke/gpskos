/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Bank;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Murid;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface DaftarKelasDAO extends GenericDAO {

    public String saveWithMurid(DaftarKelas daftarKelas, Murid murid) throws Exception;

    public String saveWithUpdateMurid(DaftarKelas daftarKelas, Murid murid) throws Exception;

    public List<DaftarKelas> getDataByEqualsMore(Kelas kelas, Bank bank) throws Exception;
}
