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

    @Override
    public String updateByKelulusan(List listDaftarKelas) throws Exception {
        String status = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            for (int x = 0; x < listDaftarKelas.size(); x++) {
                DaftarKelas daftarKelas = (DaftarKelas) listDaftarKelas.get(x);
                System.out.println("===" + daftarKelas.isChoose());
                if (!daftarKelas.isChoose()) {
                    daftarKelas.setStatus("0");
                    session.update(daftarKelas);
                } else {
                    daftarKelas.setStatus("1");
                    session.update(daftarKelas);
                }
            }
            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            status = "error";
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public String updateByKehadiran(List<DaftarKelas> listDaftarKelas) throws Exception {
        String status = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            for (DaftarKelas listDaftarKela : listDaftarKelas) {
                DaftarKelas daftarKelas = (DaftarKelas) listDaftarKela;
                if (!daftarKelas.isChoose()) {
                    daftarKelas.setKehadiran("0");
                    session.update(daftarKelas);
                } else {
                    daftarKelas.setKehadiran("1");
                    session.update(daftarKelas);
                }
            }
            HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            status = "error";
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public List<DaftarKelas> getDataByEqualsOrderByBankAndNama(String transactionReference) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query query = session.createQuery("from DaftarKelas dk where dk.kelas.transactionReference = :transactionReference order by dk.murid.bank.nama asc, dk.murid.nama asc");
            query.setParameter("transactionReference", transactionReference);
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
