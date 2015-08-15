/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.RekonBankDAO;
import com.ivanbiz.model.RekonBank;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
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
    
}
