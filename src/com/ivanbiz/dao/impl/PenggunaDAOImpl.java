/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.PenggunaDAO;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class PenggunaDAOImpl extends GenericDAOImpl implements PenggunaDAO {

    @Override
    public Pengguna login(String penggunaName, String password) throws Exception {
        Pengguna pengguna = null;
        try {
            Session session = HibernateUtil.getSession();
            Criteria crit = session.createCriteria(Pengguna.class);
            crit.add(Restrictions.eq("userName", penggunaName));
            pengguna = (Pengguna) crit.uniqueResult();
            if (!pengguna.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "password salah");
                System.exit(0);
            }

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
        return pengguna;
    }

    @Override
    public List getDataByLike(Class claz, String variable, Object input, String variable2, Object input2) throws Exception {
        try {
            Session session = HibernateUtil.getSession();
            Criteria crit = session.createCriteria(claz).add(Restrictions.like(variable, "%" + input + "%")).add(Restrictions.eq(variable2, input2));
            List list = crit.list();
            return list;
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
