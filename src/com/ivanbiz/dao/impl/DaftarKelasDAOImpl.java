/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.DaftarKelasDAO;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.model.Murid;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class DaftarKelasDAOImpl extends GenericDAOImpl implements DaftarKelasDAO {

    @Override
    public String saveWithMurid(DaftarKelas daftarKelas, Murid murid) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();
        try {
            Session session = HibernateUtil.getSession();
            session.save(daftarKelas);
            session.save(murid);
            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception ex) {
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public String saveWithUpdateMurid(DaftarKelas daftarKelas, Murid murid) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();
        try {
            Session session = HibernateUtil.getSession();
            session.save(daftarKelas);
            session.update(murid);
            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception ex) {
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public List<DaftarKelas> getDataByEqualsMore(Kelas kelas, Bank bank) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query query = session.createQuery("from DaftarKelas dk where dk.kelas.transactionReference = :kelas and dk.murid.bank.nama = :bank");
            query.setParameter("kelas", kelas.getTransactionReference());
            query.setParameter("bank", bank.getNama());
            HibernateUtil.commitTransaction();
            return query.list();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
