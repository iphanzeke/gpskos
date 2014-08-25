/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.GenericDAO;
import com.ivanbiz.service.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author City_Z
 */
public class GenericDAOImpl implements GenericDAO{
     public void delete(Object obj) throws Exception {
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.delete(obj);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Object load(Class clasz, long id) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            return session.get(clasz, id);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void save(Object obj) throws Exception {
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.save(obj);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List getAll(Class claz) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria criteria = session.createCriteria(claz);
             HibernateUtil.commitTransaction();
            return criteria.list();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void update(Object obj) throws Exception {
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.update(obj);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List getDataByLike(Class clasImpl, String variable, Object input) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
             HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clasImpl);
            crit.add(Restrictions.like(variable, "%" + input + "%"));
            List list = crit.list();
            HibernateUtil.commitTransaction();
            return list;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List getDataByEquals(Class clazImpl, String variable, Object input) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            List list = crit.list();
             HibernateUtil.commitTransaction();
            return list;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Object getDataByEqual(Class clazImpl, String variable, Object input) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
             HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));            
            Object obj = crit.uniqueResult();
            HibernateUtil.commitTransaction();
            return obj;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List getData(Class claz, Date start, Date end) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            start.setHours(0);
            start.setMinutes(0);
            start.setSeconds(0);
            end.setHours(0);
            end.setMinutes(0);
            end.setSeconds(0);
            Criteria crit = session.createCriteria(claz).add(Restrictions.ge("createDate", start)).add(Restrictions.le("createDate", end));
            List list = crit.list();
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
