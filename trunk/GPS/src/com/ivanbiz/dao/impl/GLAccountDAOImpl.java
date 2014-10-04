package com.ivanbiz.dao.impl;

import com.ivanbiz.dao.GLAccountDAO;
import com.ivanbiz.model.GLAccount;
import com.ivanbiz.model.SettingGL;
import com.ivanbiz.service.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class GLAccountDAOImpl extends GenericDAOImpl implements GLAccountDAO {

    @Override
    public String saveGLKrediturWithSetting(GLAccount glAccount) throws Exception {
        String status = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            String noGL = validateFieldSession(GLAccount.class, "noGL", glAccount.getNoGL(), session);
            String kode = validateFieldSession(GLAccount.class, "kode", glAccount.getKode(), session);
            if (!noGL.isEmpty() || !kode.isEmpty()) {
                status = "Data Already";
            } else {
                session.save(glAccount);
                SettingGL settingGL = new SettingGL();
                settingGL.setGlAccount(glAccount.getNoGL());
                settingGL.setProCode("XXX" + glAccount.getKode());
                settingGL.setDebetOrCredit("C");
                session.save(settingGL);
                SettingGL settingGL1 = new SettingGL();
                settingGL1.setProCode(settingGL.getProCode());
                settingGL1.setGlAccount("XXX");
                settingGL1.setDebetOrCredit("D");
                session.save(settingGL1);
                status = "sukses";
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
    public String saveGLBiayaLainWithSetting(GLAccount glAccount) throws Exception {
        String status = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            String[] split = glAccount.getNoGL().split("#");

            String noGL = validateFieldSession(GLAccount.class, "noGL", split[1].toString(), session);
//            String kode = validateFieldSession(GLAccount.class, "kode", glAccount.getKode(), session);
            if (!noGL.isEmpty()) {
                status = "Data Already";
            } else {
                glAccount.setNoGL(split[1]);
                session.save(glAccount);
                GLAccount glAcc = (GLAccount) session.createQuery("from com.ivanbiz.model.GLAccount g where g.noGL ='" + split[0].toString() + "'").uniqueResult();
                String proCode = glAcc.getKode() + "XXX";
                List listCheckGL = session.createQuery("from com.ivanbiz.model.SettingGL s where s.proCode = '" + proCode + "'").list();
                if (listCheckGL.size() <= 0) {
                    SettingGL settingGL = new SettingGL();
                    settingGL.setGlAccount("XXX");
                    settingGL.setProCode(glAcc.getKode() + "XXX");
                    settingGL.setDebetOrCredit("C");
                    session.save(settingGL);
                    SettingGL settingGL1 = new SettingGL();
                    settingGL1.setProCode(settingGL.getProCode());
                    settingGL1.setGlAccount(split[0].toString());
                    settingGL1.setDebetOrCredit("D");
                    session.save(settingGL1);

                }
                status = "sukses";

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
    public String getLastNoTransaksi() throws Exception {
        GLAccount gLAccount = null;
        String noTransaksi = "";
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = (Query) session.createQuery("from GLAccount gl where gl.kode !='XXX' and kode <'890' order by gl.id desc");
            query.setFirstResult(0);
            query.setMaxResults(1);
            gLAccount = (GLAccount) query.uniqueResult();
            if (gLAccount != null) {
                noTransaksi = gLAccount.getKode();
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }

        return noTransaksi;
    }
}
