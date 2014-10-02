/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.service.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public class InvoiceDAOImpl extends GenericDAOImpl implements InvoiceDAO {

    @Override
    public String sendInvoiceWithJurnal(Invoice invoice, String proCode, String glCredit) throws Exception {
        String sukses = "";
        if (invoice.getStatus().equals("1")) {
            sukses = "Sudah Dalam Proses";
            return sukses;
        }
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            invoice.setStatus("1");
            session.save(invoice);
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal("005" + proCode, invoice.getJumlahTagihan(), invoice.getNII(), "", glCredit, session);
            HibernateUtil.commitTransaction();
            sukses = "sukses";
        } catch (Exception e) {
            sukses = "error";
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return sukses;
    }

    @Override
    public String sendInvoice(Invoice invoice, String proCode, String glCredit) throws Exception {
        String sukses = "";
        if (invoice.getStatus().equals("1")) {
            sukses = "Sudah Dalam Proses";
            return sukses;
        }
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            invoice.setStatus("1");
            session.update(invoice);
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal("005" + proCode, invoice.getJumlahTagihan(), invoice.getNII(), "", glCredit, session);
            HibernateUtil.commitTransaction();
            sukses = "sukses";
        } catch (Exception e) {
            sukses = "error";
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return sukses;
    }

    @Override
    public List<Invoice> getDataByEquals(String status) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query queryInvoice = session.createQuery("select i from Invoice i where i.status = :status or i.status = 2");
            queryInvoice.setParameter("status", status);
            Query queryPembayaran = session.createQuery("select p.invoice from Pembayaran p where p.status = :status or p.status = 0");
            queryPembayaran.setParameter("status", status);
            List<Invoice> listInvoice = queryInvoice.list();
            List<Invoice> listPembayaran = queryPembayaran.list();
            List<Invoice> list = new ArrayList<Invoice>();
            for (Invoice invoice : listInvoice) {
                if (!listPembayaran.contains(invoice)) {
                    list.add(invoice);
                }
            }
            HibernateUtil.commitTransaction();
            return list;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

}
