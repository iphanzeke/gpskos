/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.model.Bank;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public class BankDAOImpl extends GenericDAOImpl implements BankDAO {

    @Override
    public List<Bank> getDataBankByKelas(String kelas) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
//            Query qInvoiceBank = session.createQuery("select i.bank from Invoice i where i.kelas.transactionReference = :kelas group by i.bank");
//            qInvoiceBank.setParameter("kelas", kelas);
//            List<Bank> listBank = qInvoiceBank.list();
            Query queryDaftarKelasBank = session.createQuery("select dk.murid.bank from DaftarKelas dk where dk.kelas.transactionReference = :kelas group by dk.murid.bank");
            queryDaftarKelasBank.setParameter("kelas", kelas);
            List<Bank> listBankDaftarKelas = queryDaftarKelasBank.list();
//            List<Bank> list = new ArrayList<Bank>();
//            for (Bank bank : listBankDaftarKelas) {
//                if (!listBank.contains(bank)) {
//                    list.add(bank);
//                }
//            }
//            HibernateUtil.commitTransaction();
//            return list;
            return listBankDaftarKelas;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
//        } finally {
//            HibernateUtil.closeSession();
        }
    }
}
