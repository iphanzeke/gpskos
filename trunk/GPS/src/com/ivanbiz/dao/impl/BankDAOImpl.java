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
            Query query = session.createQuery("select b.bank from DaftarKelas k , Murid b where k.transactionReference = :kelas group by b.bank");
            query.setParameter("kelas", kelas);
            List list = query.list();
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
