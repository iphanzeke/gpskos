/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.DaftarKelasDAO;
import com.ivanbiz.model.DaftarKelas;
import com.ivanbiz.model.Murid;
import com.ivanbiz.service.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ivan
 */
public class DaftarKelasDAOImpl extends GenericDAOImpl implements DaftarKelasDAO{

    @Override
    public String saveWithMurid(DaftarKelas daftarKelas, Murid murid) throws Exception {
        String status = "";
        HibernateUtil.beginTransaction();       
        try{
            Session session = HibernateUtil.getSession();
            session.save(daftarKelas);
            session.save(murid);
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception ex){
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;            
        }finally{
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public String saveWithUpdateMurid(DaftarKelas daftarKelas, Murid murid) throws Exception {
       String status = "";
        HibernateUtil.beginTransaction();       
        try{
            Session session = HibernateUtil.getSession();
            session.save(daftarKelas);
            session.update(murid);
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception ex){
            status = "error";
            HibernateUtil.rollbackTransaction();
            throw ex;            
        }finally{
            HibernateUtil.closeSession();
        }
        return status;
    }
    
}
