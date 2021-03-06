package com.ivanbiz.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.SettingGLDAO;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.model.SettingGL;
import com.ivanbiz.service.HibernateUtil;
import org.hibernate.Query;

public class JurnalDAOImpl extends GenericDAOImpl implements JurnalDAO {

    @Override
    public String saveJurnal(String proCode, double amount, String transRef, String glDebit, String glKredit, Session session) throws Exception {
        // HibernateUtil.beginTransaction();
        String status = "";
        try {
            //   session = HibernateUtil.getSession();

            SettingGLDAO settingGL = new SettingGLDAOImpl();
            List listGL = settingGL.getListByNoGL(proCode, session);
            if (listGL.size() <= 0) {
                status = "PRO_Code tidak ditemukan";
                return status;
            }
            String ref = proCode + "-" + System.currentTimeMillis();
            for (int x = 0; x < listGL.size(); x++) {
                SettingGL settingGl = (SettingGL) listGL.get(x);
                Jurnal jurnal = new Jurnal();
                jurnal.setAccountingReference(ref);
                jurnal.setDateReference(new Date());
                jurnal.setCurrency("IDR");
                jurnal.setStatus("2000");
                jurnal.setTransactionReference(transRef);
                jurnal.setGLAccount(settingGl.getGlAccount());
                if (settingGl.getDebetOrCredit().equals("C")) {
                    if (settingGl.getGlAccount().equals("XXX")) {
                        jurnal.setGLAccount(glKredit);
                    }
                    jurnal.setCredit(amount);
                } else {
                    if (settingGl.getGlAccount().equals("XXX")) {
                        jurnal.setGLAccount(glDebit);
                    }
                    jurnal.setDebit(amount);
                }
                session.save(jurnal);

            }


            //   HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception e) {
            status = "gagal";
            //   HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            // HibernateUtil.closeSession();
        }
        return status;
    }
    /*
    @Override
    public String reversalJurnal(String accRef) throws Exception {
    throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String saveJurnalMore(List listItem,String glDebit,String glKredit, Session session) throws Exception {
    //HibernateUtil.beginTransaction();
    String status = "";
    try {
    // Session session = HibernateUtil.getSession();
    SettingGLDAO settingGL = new SettingGLDAOImpl();
    long refTime = System.currentTimeMillis();
    for (int y = 0; y < listItem.size(); y++) {
    String[] splitVal = listItem.get(y).toString().split("#");
    String proCode = splitVal[0];
    double amount = Double.parseDouble(splitVal[1]);
    String transRef = splitVal[2];
    List listGL = settingGL.getListByNoGL(proCode, session);
    String ref = proCode + "-" + refTime;
    for (int x = 0; x < listGL.size(); x++) {
    SettingGL settingGl = (SettingGL) listGL.get(x);
    Jurnal jurnal = new Jurnal();
    jurnal.setAccountingReference(ref);
    jurnal.setDateReference(new Date());
    jurnal.setCurrency("IDR");
    jurnal.setStatus("2000");
    jurnal.setTransactionReference(transRef);
    jurnal.setGLAccount(settingGl.getGlAccount());
    if (settingGl.getDebetOrCredit().equals("C")) {
    if(settingGl.getGlAccount().equals("XXX")){
    jurnal.setGLAccount(glKredit);
    }
    jurnal.setCredit(amount);
    } else {
    if(settingGl.getGlAccount().equals("XXX")){
    jurnal.setGLAccount(glDebit);
    }
    jurnal.setDebit(amount);
    }
    session.save(jurnal);
    }
    }
    // HibernateUtil.commitTransaction();
    status = "sukses";
    } catch (Exception e) {
    status = "gagal";
    //HibernateUtil.rollbackTransaction();
    throw e;
    } finally {
    // HibernateUtil.closeSession();
    }
    return status;
    
    }
     */

    @Override
    public String saveJurnalWithVA(String proCode, double amount, String transRef, String virtualAccount, String glDebit, String glKredit, Session session) throws Exception {
        String status = "";
        try {
            //   Session session = HibernateUtil.getSession();
            SettingGLDAO settingGL = new SettingGLDAOImpl();
            List listGL = settingGL.getListByNoGL(proCode, session);
            String ref = proCode + "-" + System.currentTimeMillis();
            for (int x = 0; x < listGL.size(); x++) {
                SettingGL settingGl = (SettingGL) listGL.get(x);
                Jurnal jurnal = new Jurnal();
                jurnal.setAccountingReference(ref);
                jurnal.setDateReference(new Date());
                jurnal.setCurrency("IDR");
                jurnal.setStatus("2000");
                jurnal.setTransactionReference(transRef);
                jurnal.setGLAccount(settingGl.getGlAccount() + "-" + virtualAccount);
                if (settingGl.getDebetOrCredit().equals("C")) {
                    if (settingGl.getGlAccount().equals("XXX")) {
                        jurnal.setGLAccount(glKredit);
                    }
                    jurnal.setCredit(amount);
                } else {
                    if (settingGl.getGlAccount().equals("XXX")) {
                        jurnal.setGLAccount(glDebit);
                    }
                    jurnal.setDebit(amount);
                }
                session.save(jurnal);

            }
            //  HibernateUtil.commitTransaction();
            status = "sukses";
        } catch (Exception e) {
            status = "gagal";
            // HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            // HibernateUtil.closeSession();
        }
        return status;
    }
    /*
    @Override
    public String saveJurnalMoreWithVA(List listItem,String glDebit,String glKredit, Session session) throws Exception {
    String status = "";
    try {
    // Session session = HibernateUtil.getSession();
    SettingGLDAO settingGL = new SettingGLDAOImpl();
    long refTime = System.currentTimeMillis();
    for (int y = 0; y < listItem.size(); y++) {
    String[] splitVal = listItem.get(y).toString().split("#");
    String proCode = splitVal[0];
    double amount = Double.parseDouble(splitVal[1]);
    String transRef = splitVal[2];
    String virtualAccount = splitVal[3];
    List listGL = settingGL.getListByNoGL(proCode, session);
    String ref = proCode + "-" + refTime;
    for (int x = 0; x < listGL.size(); x++) {
    SettingGL settingGl = (SettingGL) listGL.get(x);
    Jurnal jurnal = new Jurnal();
    jurnal.setAccountingReference(ref);
    jurnal.setDateReference(new Date());
    jurnal.setCurrency("IDR");
    jurnal.setStatus("2000");
    jurnal.setTransactionReference(transRef);
    jurnal.setGLAccount(settingGl.getGlAccount() + "-" + virtualAccount);
    if (settingGl.getDebetOrCredit().equals("C")) {
    if(settingGl.getGlAccount().equals("XXX")){
    jurnal.setGLAccount(glKredit);
    }
    jurnal.setCredit(amount);
    } else {
    if(settingGl.getGlAccount().equals("XXX")){
    jurnal.setGLAccount(glDebit);
    }
    jurnal.setDebit(amount);
    }
    session.save(jurnal);
    }
    }
    // HibernateUtil.commitTransaction();
    status = "sukses";
    } catch (Exception e) {
    status = "gagal";
    //HibernateUtil.rollbackTransaction();
    throw e;
    } finally {
    // HibernateUtil.closeSession();
    }
    return status;
    }
     */

    @Override
    public double getSumDebetGLAccount(String startDate,String endDate, String glAccount) throws Exception {
        double hasil = 0;
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("select SUM(j.debit) from com.ivanbiz.model.Jurnal j where j.dateReference >= '" + startDate + "' and j.dateReference <= '"+endDate+"' and j.GLAccount ='" + glAccount + "' ");
            if (query != null) {
                hasil = (Double) query.uniqueResult();
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
//            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return hasil;
    }
    
    @Override
    public double getSumCreditGLAccount(String startDate,String endDate, String glAccount) throws Exception {
        double hasil = 0;
        try {
            HibernateUtil.beginTransaction();
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("select SUM(j.credit) from com.ivanbiz.model.Jurnal j where j.dateReference >= '" + startDate + "' and j.dateReference <= '"+endDate+"' and j.GLAccount ='" + glAccount + "' ");
            if (query != null) {
                hasil = (Double) query.uniqueResult();
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
//            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        } finally {
            HibernateUtil.closeSession();
        }
        return hasil;
    }
}
