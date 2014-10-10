/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.CashBalanceDAO;
import com.ivanbiz.model.CashBalance;
import com.ivanbiz.service.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public class CashBalanceDAOImpl extends GenericDAOImpl implements CashBalanceDAO {

    @Override
    public List getBalanceOrderDate(long idGL) throws Exception {
        List list = new ArrayList();
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from com.ivanbiz.model.CashBalance c where c.glAccount.id='" + idGL + "' order by dateBalance desc");
            list = query.list();
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return list;
    }

    @Override
    public CashBalance getBalanceByOrderDate(long idGL) throws Exception {
        CashBalance cashBalance = new CashBalance();
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from com.ivanbiz.model.CashBalance c where c.glAccount.id='" + idGL + "' order by dateBalance desc");
            query.setMaxResults(1);
            cashBalance = (CashBalance) query.uniqueResult();
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return cashBalance;
    }

    @Override
    public boolean validateSameDate(long idGL,Date date) throws Exception {
         CashBalance cashBalance = new CashBalance();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
         boolean status = false;
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from com.ivanbiz.model.CashBalance c where c.glAccount.id='" + idGL + "'order by dateBalance desc");
            query.setMaxResults(1);
            cashBalance = (CashBalance) query.uniqueResult();
            if(sdf.format(cashBalance.getDateBalance()).equals(sdf.format(date))){
                status = true;
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
      
        return status;
    }
}
