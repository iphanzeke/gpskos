/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.GroupsDAO;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Groups;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
public class GroupsDAOImpl extends GenericDAOImpl implements GroupsDAO {

    @Override
    public void saveOrUpdate(Groups groups, List<AksesMatrix> listAksesMatrixs) throws Exception {
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            for (AksesMatrix aksesMatrix : listAksesMatrixs) {
                session.saveOrUpdate(aksesMatrix);
            }
            session.saveOrUpdate(groups);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public void delete(Groups groups, List<AksesMatrix> listAksesMatrix) throws Exception {
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            for (AksesMatrix aksesMatrix : listAksesMatrix) {
                session.delete(aksesMatrix);
            }
            session.delete(groups);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
