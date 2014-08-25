package com.ivanbiz.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.SettingGLDAO;
import com.ivanbiz.model.Jurnal;
import com.ivanbiz.model.SettingGL;
import com.ivanbiz.service.HibernateUtil;

public class JurnalDAOImpl extends GenericDAOImpl implements JurnalDAO {

    @Override
    public String saveJurnal(String proCode, double amount,String transRef,Session session) throws Exception {
       // HibernateUtil.beginTransaction();
        String status = "";
        try {
         //   Session session = HibernateUtil.getSession();
            SettingGLDAO settingGL = new SettingGLDAOImpl();
            List listGL = settingGL.getListByNoGL(proCode, session);
            String ref = proCode +"-"+ System.currentTimeMillis();
            for (int x = 0; x < listGL.size(); x++) {
                SettingGL settingGl = (SettingGL) listGL.get(x);
                Jurnal jurnal = new Jurnal();
                jurnal.setAccountingReference(ref);
                jurnal.setDateReference(new Date());
                jurnal.setCurrency("IDR");
                jurnal.setStatus("2000");
                jurnal.setTransactionReference(transRef);
                jurnal.setGLAccount(settingGl.getGlAccount().getNoGL());
                if (settingGl.getDebetOrCredit().equals("C")) {
                    jurnal.setCredit(amount);
                } else {
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

    @Override
    public String reversalJurnal(String accRef) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String saveJurnalMore(List listItem,Session session) throws Exception {
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
                String ref = proCode +"-"+ refTime;
                for (int x = 0; x < listGL.size(); x++) {
                    SettingGL settingGl = (SettingGL) listGL.get(x);
                    Jurnal jurnal = new Jurnal();
                    jurnal.setAccountingReference(ref);
                    jurnal.setDateReference(new Date());
                    jurnal.setCurrency("IDR");
                    jurnal.setStatus("2000");
                    jurnal.setTransactionReference(transRef);
                    jurnal.setGLAccount(settingGl.getGlAccount().getNoGL());
                    if (settingGl.getDebetOrCredit().equals("C")) {
                        jurnal.setCredit(amount);
                    } else {
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
}
