package com.ivanbiz.test;

import com.ivanbiz.dao.AksesMatrixDAO;
import com.ivanbiz.dao.GroupsDAO;
import com.ivanbiz.dao.PenggunaDAO;
import com.ivanbiz.dao.impl.AksesMatrixDAOImpl;
import com.ivanbiz.dao.impl.GroupsDAOImpl;
import com.ivanbiz.dao.impl.PenggunaDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Groups;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.ui.LoginDialog;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing {

    GroupsDAO groupsDAO;
    AksesMatrixDAO aksesMatrixDAO;
    PenggunaDAO penggunaDAO;

    public static void main(String[] args) {
//                List listJurnal = new ArrayList();
//                listJurnal.add("001-02#10000#CC003");
//                listJurnal.add("001-01#5000#CC003");
//		JurnalDAO jurnalDAO = new JurnalDAOImpl();
//		try {
//			//System.out.println(jurnalDAO.saveJurnal("001-02", 5000));
//			//                 System.out.println(jurnalDAO.saveJurnalMore(listJurnal));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        new Testing().saveData();
//        new Testing().deleteData();
    }

    private void deleteData() {
        try {
            groupsDAO = new GroupsDAOImpl();
            aksesMatrixDAO = new AksesMatrixDAOImpl();
            penggunaDAO = new PenggunaDAOImpl();
            //delete Pengguna
            Pengguna pengguna = (Pengguna) penggunaDAO.getDataByEqual(Pengguna.class, "userName", "admin");
            penggunaDAO.delete(pengguna);
            //delete Akses Matrix
            List<AksesMatrix> listAksesMatrix = aksesMatrixDAO.getDataByEquals(AksesMatrix.class, "groups.id", pengguna.getGroups().getId());
            for (AksesMatrix aksesMatrix : listAksesMatrix) {
                aksesMatrixDAO.delete(aksesMatrix);
            }
            //delete Groups
            Groups groups = pengguna.getGroups();
            groupsDAO.delete(groups);
        } catch (Exception ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveData() {
        try {
            //save Group
            groupsDAO = new GroupsDAOImpl();
            Groups groups = new Groups();
            groups.setId(Long.parseLong("1"));
            groups.setNama("Admin");
            groupsDAO.save(groups);
            //save Akses Matrix
            aksesMatrixDAO = new AksesMatrixDAOImpl();
            for (MenuAksesConstant menuAkses : MenuAksesConstant.values()) {
                AksesMatrix aksesMatrix = new AksesMatrix();
                aksesMatrix.setNama(menuAkses.toString());
                aksesMatrix.setGroups(groups);
                aksesMatrixDAO.save(aksesMatrix);
            }
            //save Pengguna
            penggunaDAO = new PenggunaDAOImpl();
            Pengguna pengguna = new Pengguna();
            pengguna.setUserName("admin");
            pengguna.setPassword("admin");
            pengguna.setGroups(groups);
            penggunaDAO.save(pengguna);
        } catch (Exception ex) {
            Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
