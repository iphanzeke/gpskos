package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.SettingGL;
import com.ivanbiz.service.HibernateUtil;
import org.hibernate.Session;

public class GLAccountDAOImpl extends GenericDAOImpl implements GLAccountDAO {

    @Override
    public String saveGLKrediturWithSetting(GLAccount glAccount) throws Exception {
        String status = "";
        try{
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.save(glAccount);
            SettingGL settingGL = new SettingGL();
            settingGL.setGlAccount(glAccount.getNoGL());
            settingGL.setProCode("XXX"+glAccount.getKode());
            settingGL.setDebetOrCredit("C");
            session.save(settingGL);
            SettingGL settingGL1 = new SettingGL();
            settingGL1.setProCode(settingGL.getProCode());
            settingGL1.setGlAccount("XXX");
            settingGL1.setDebetOrCredit("D");
            session.save(settingGL1);
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception e){
            HibernateUtil.rollbackTransaction();
            throw e;
        }finally{
            HibernateUtil.closeSession();
        }
        return status;
    }

    @Override
    public String saveGLBiayaLainWithSetting(GLAccount glAccount) throws Exception {
        String status = "";
        try{
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            session.save(glAccount);
            SettingGL settingGL = new SettingGL();
            settingGL.setGlAccount("XXX");
            settingGL.setProCode(glAccount.getKode()+"XXX");
            settingGL.setDebetOrCredit("C");
            session.save(settingGL);
            SettingGL settingGL1 = new SettingGL();
            settingGL1.setProCode(settingGL.getProCode());
            settingGL1.setGlAccount(glAccount.getNoGL());
            settingGL1.setDebetOrCredit("D");
            session.save(settingGL1);
            HibernateUtil.commitTransaction();
            status = "sukses";
        }catch(Exception e){
            HibernateUtil.rollbackTransaction();
            throw e;
        }finally{
            HibernateUtil.closeSession();
        }
        return status;
    }

}
