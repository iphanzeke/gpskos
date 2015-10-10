/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.RekonBankDAO;
import com.ivanbiz.model.RekonBank;
import com.ivanbiz.service.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public class RekonBankDAOImpl extends GenericDAOImpl implements RekonBankDAO{

    @Override
    public String saveRekonByList(List list) throws Exception {
        String status = "";
        try{
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            for(int x=0;x<list.size();x++){
                RekonBank rekonBank = (RekonBank)list.get(x);
                session.save(rekonBank);
            }
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception e){
            status = "gagal";
            HibernateUtil.rollbackTransaction();
            throw e;
        }finally{
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public List getByDate(String startDate, String endDate, String kreditur) throws Exception {
        List list = new ArrayList();
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("from com.ivanbiz.model.RekonBank j where j.startDate >= '" + startDate + "' and j.endDate <= '"+endDate+"' and j.kreditur ='" + kreditur + "' ");
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
