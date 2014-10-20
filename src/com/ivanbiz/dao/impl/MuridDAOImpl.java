/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.MuridDAO;
import com.ivanbiz.model.Murid;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class MuridDAOImpl extends GenericDAOImpl implements MuridDAO {

    @Override
    public List getAll(Murid murid) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query query = session.createQuery("from Murid m order by m.bank.nama asc,m.nama");
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
    public List getDataByLikeBank(String input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Query query = session.createQuery("from Murid m where m.bank.nama like :input");
            query.setParameter("input", "%" + input + "%");
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
}
