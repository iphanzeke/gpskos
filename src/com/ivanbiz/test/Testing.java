package com.ivanbiz.test;

import com.ivanbiz.dao.AksesMatrixDAO;
import com.ivanbiz.dao.BankDAO;
import com.ivanbiz.dao.GroupAccDAO;
import com.ivanbiz.dao.GroupsDAO;
import com.ivanbiz.dao.PenggunaDAO;
import com.ivanbiz.dao.impl.AksesMatrixDAOImpl;
import com.ivanbiz.dao.impl.BankDAOImpl;
import com.ivanbiz.dao.impl.GroupAccDAOImpl;
import com.ivanbiz.dao.impl.GroupsDAOImpl;
import com.ivanbiz.dao.impl.PenggunaDAOImpl;
import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Bank;
import com.ivanbiz.model.GroupAcc;
import com.ivanbiz.model.Groups;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.service.MD5;
import com.ivanbiz.service.MenuAksesConstant;
import com.ivanbiz.ui.LoginDialog;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing {

    GroupsDAO groupsDAO = new GroupsDAOImpl();
    AksesMatrixDAO aksesMatrixDAO = new AksesMatrixDAOImpl();
    PenggunaDAO penggunaDAO = new PenggunaDAOImpl();
    GroupAccDAO groupAccDAO = new GroupAccDAOImpl();
    BankDAO bankDAO = new BankDAOImpl();

    public static void main(String[] args) {
        new Testing().saveData();
    }

    private void deleteData() {
        try {
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
            //delete Group ACC
            GroupAcc groupAcc = new GroupAcc();
            groupAccDAO.delete(groupAcc);
            //delete bank
            Bank bank = new Bank();
            bankDAO.delete(bank);
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
            for (MenuAksesConstant menuAkses : MenuAksesConstant.values()) {
                AksesMatrix aksesMatrix = new AksesMatrix();
                aksesMatrix.setNama(menuAkses.toString());
                aksesMatrix.setGroups(groups);
                aksesMatrixDAO.save(aksesMatrix);
            }
            //save Pengguna
            Pengguna pengguna = new Pengguna();
            MD5 md5 = new MD5("admin");
            pengguna.setKode("001");
            pengguna.setUserName("admin");
            pengguna.setPassword(md5.asHex());
            pengguna.setGroups(groups);
            penggunaDAO.save(pengguna);
            //save Group Acc
            GroupAcc groupAcc = new GroupAcc();
            groupAcc.setNamaGroup("Debitur");
            groupAcc.setDeskripsi("Debitur");
            groupAccDAO.save(groupAcc);
            GroupAcc groupAcc1 = new GroupAcc();
            groupAcc1.setNamaGroup("Kreditur");
            groupAcc1.setDeskripsi("Kreditur");
            groupAccDAO.save(groupAcc1);
            GroupAcc groupAcc2 = new GroupAcc();
            groupAcc2.setNamaGroup("BiayaLain");
            groupAcc2.setDeskripsi("BiayaLain");
            groupAccDAO.save(groupAcc2);
            //save Bank
            Bank bank = new Bank();
            bank.setNama("BCA");
            bank.setDeskripsi("BCA");
            bankDAO.save(bank);
            Bank bank1 = new Bank();
            bank1.setNama("CIMB NIAGA");
            bank1.setDeskripsi("CIMB NIAGA");
            bankDAO.save(bank1);
            Bank bank2 = new Bank();
            bank2.setNama("HSBC");
            bank2.setDeskripsi("HSBC");
            bankDAO.save(bank2);
            Bank bank3 = new Bank();
            bank3.setNama("OCBC NISP");
            bank3.setDeskripsi("OCBC NISP");
            bankDAO.save(bank3);
            Bank bank4 = new Bank();
            bank4.setNama("EKONOMI");
            bank4.setDeskripsi("EKONOMI");
            bankDAO.save(bank4);
        } catch (Exception ex) {
            Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
