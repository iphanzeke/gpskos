/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.ReconDAO;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.model.Pembayaran;
import com.ivanbiz.service.HibernateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public class ReconDAOImpl extends GenericDAOImpl implements ReconDAO {

    @Override
    public Map getDataByKelas(long idKelas) throws Exception {
        Map map = new HashMap();
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            List listDaftarKelas = getDataByEquals(DaftarKelas.class, "kelas.id", idKelas);
            List listInvoice = getDataByEquals(Invoice.class, "kelas.id", idKelas);
            List listPembayaran = new ArrayList();
            List listJurnal = new ArrayList();
            for (int x = 0; x < listInvoice.size(); x++) {
                Invoice inv = (Invoice) listInvoice.get(x);
                if ((Pembayaran) getDataByEqual(Pembayaran.class, "transactionReference", inv.getNII()) != null) {
                    listPembayaran.add((Pembayaran) getDataByEqual(Pembayaran.class, "transactionReference", inv.getNII()));
                }
                List listDetailJurnal = getDataByEquals(Jurnal.class, "transactionReference", inv.getNII());
                for (int y = 0; y < listDetailJurnal.size(); y++) {
                    Jurnal jurnal = (Jurnal) listDetailJurnal.get(y);
                    listJurnal.add(jurnal);
                }
            }
            map.put("listDaftarKelas", listDaftarKelas);
            map.put("listInvoice", listInvoice);
            map.put("listPembayaran", listPembayaran);
            map.put("listJurnal", listJurnal);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return map;
    }

    @Override
    public List getDataByDateAndGLAccount(String dateAwal, String dateAkhir, String glAccount) throws Exception {
        List listData = new ArrayList();
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            listData = session.createQuery("from com.ivanbiz.model.Jurnal j where j.dateReference >='" + dateAwal + "'"
                    + " and j.dateReference <= '" + dateAkhir + "' and j.GLAccount = '" + glAccount + "'").list();
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return listData;
    }
}
