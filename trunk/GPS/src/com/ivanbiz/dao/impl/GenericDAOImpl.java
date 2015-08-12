/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.GenericDAO;
import com.ivanbiz.service.HibernateUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author City_Z
 */
public class GenericDAOImpl implements GenericDAO {

    @Override
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

    @Override
    public Object load(Class clasz, long id) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSession();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return session.get(clasz, id);
    }

    @Override
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

    @Override
    public void saveOrUpdate(Object obj) throws Exception {
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.saveOrUpdate(obj);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public List getAll(Class claz) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria criteria = session.createCriteria(claz);
            list = criteria.list();
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

    @Override
    public List getDataByLike(Class clasImpl, String variable, Object input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clasImpl);
            crit.add(Restrictions.like(variable, "%" + input + "%"));
            list = crit.list();
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
    public List getDataByEquals(Class clazImpl, String variable, Object input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            list = crit.list();
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
    public Object getDataByEqual(Class clazImpl, String variable, Object input) throws Exception {
        Object obj = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            obj = crit.uniqueResult();
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return obj;
    }

    @Override
    public List getData(Class claz, Date start, Date end) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            start.setHours(0);
            start.setMinutes(0);
            start.setSeconds(0);
            end.setHours(0);
            end.setMinutes(0);
            end.setSeconds(0);
            Criteria crit = session.createCriteria(claz).add(Restrictions.ge("dateReference", start)).add(Restrictions.le("dateReference", end));
            list = crit.list();
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
    public List getDataByEqualsMore(Class clazImpl, Map map) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                crit.add(Restrictions.eq(mapEntry.getKey().toString(), mapEntry.getValue().toString()));
            }
            // crit.add(Restrictions.eq(variable, input));
            list = crit.list();
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
    public Object getDataByEqualMore(Class clazImpl, Map map) throws Exception {
        Object obj = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                crit.add(Restrictions.eq(mapEntry.getKey().toString(), mapEntry.getValue().toString()));
            }
            obj = crit.uniqueResult();
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return obj;
    }

    @Override
    public String validateField(Class clazImpl, String variable, Object input) throws Exception {
        String status = "Data sudah ada";
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            Object obj = crit.uniqueResult();
            if (obj == null) {
                status = "";
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

    @Override
    public String validateFieldSession(Class clazImpl, String variable, Object input, Session session) throws Exception {
        String status = "Data sudah ada";
        try {

            HibernateUtil.beginTransaction();
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            Object obj = crit.uniqueResult();
            if (obj == null) {
                status = "";
            }

        } catch (Exception e) {
            throw e;
        }
        return status;
    }

    @Override
    public List getDataByDateAndVar(Class claz, Date start, Date end, String variable, Object input) throws Exception {
        List list = null;
        try {
            Session session = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();
            start.setHours(0);
            start.setMinutes(0);
            start.setSeconds(0);
            end.setHours(0);
            end.setMinutes(0);
            end.setSeconds(0);
            Criteria crit = session.createCriteria(claz).add(Restrictions.ge("dateReference", start)).add(Restrictions.le("dateReference", end)).add(Restrictions.eq(variable, input));
            list = crit.list();
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
    public List getDataByEquals(Class clazImpl, String variable, Object input, Session session) throws Exception {
        List list = null;
        try {
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            list = crit.list();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public Object getDataByEqual(Class clazImpl, String variable, Object input, Session session) throws Exception {
        Object obj = null;
        try {
            Criteria crit = session.createCriteria(clazImpl);
            crit.add(Restrictions.eq(variable, input));
            obj = crit.uniqueResult();

        } catch (Exception e) {

            throw e;
        }
        return obj;
    }
}
