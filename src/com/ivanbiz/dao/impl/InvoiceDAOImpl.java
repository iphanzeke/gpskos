/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.InvoiceDAO;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.model.Invoice;
import com.ivanbiz.service.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public class InvoiceDAOImpl extends GenericDAOImpl implements InvoiceDAO{

    @Override
    public String sendInvoiceWithJurnal(Invoice invoice,String proCode,String glCredit) throws Exception {
        String sukses = "";
        if(invoice.getStatus().equals("1")){
            sukses="Sudah Dalam Proses";
            return sukses;
        }
        try{
            HibernateUtil.beginTransaction();
            Session session  = HibernateUtil.getSession();
            invoice.setStatus("1");
            session.save(invoice);
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal("005"+proCode, invoice.getJumlahTagihan(), invoice.getNII(), "", glCredit, session);
            HibernateUtil.commitTransaction();
            sukses = "sukses";
        }catch(Exception e){
                sukses = "error";
            HibernateUtil.rollbackTransaction();
            throw e;
        }finally{
            HibernateUtil.closeSession();
        }
        return sukses;
    }

    @Override
    public String sendInvoice(Invoice invoice, String proCode, String glCredit) throws Exception {
        String sukses = "";
         if(invoice.getStatus().equals("1")){
            sukses="Sudah Dalam Proses";
            return sukses;
        }
        try{
            HibernateUtil.beginTransaction();
            Session session  = HibernateUtil.getSession();   
            invoice.setStatus("1");
            session.update(invoice);
            JurnalDAO jurnalDAO = new JurnalDAOImpl();
            jurnalDAO.saveJurnal("005"+proCode, invoice.getJumlahTagihan(), invoice.getNII(), "", glCredit, session);
            HibernateUtil.commitTransaction();
            sukses = "sukses";
        }catch(Exception e){
                sukses = "error";
            HibernateUtil.rollbackTransaction();
            throw e;
        }finally{
            HibernateUtil.closeSession();
        }
        return sukses;
    }
    
}
