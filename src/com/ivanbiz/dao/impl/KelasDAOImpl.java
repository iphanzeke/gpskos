/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.KelasDAO;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.Kelas;
import com.ivanbiz.service.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class KelasDAOImpl extends GenericDAOImpl implements KelasDAO {

    @Override
    public String getLastNoTransaksi() throws Exception {
        Kelas kelas = null;
        String noTransaksi = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from com.ivanbiz.model.Kelas k order by k.id desc");
            query.setFirstResult(0);
            query.setMaxResults(1);
            kelas = (Kelas) query.uniqueResult();
            if (kelas != null) {
                noTransaksi = kelas.getTransactionReference();
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }

        return noTransaksi;
    }

    @Override
    public String getDataPeserta(Kelas kelas, Bank bank) throws Exception {
        try {
            String peserta = "";
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query query = session.createQuery("select count (*) from DaftarKelas dk, Murid m where dk.murid.id = m.id and dk.kelas.transactionReference =:kelas and m.bank.nama = :bank ");
            query.setParameter("kelas", kelas.getTransactionReference());
            query.setParameter("bank", bank.getNama());
            peserta = query.uniqueResult().toString();
            HibernateUtil.commitTransaction();
            return peserta;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
