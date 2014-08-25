package com.ivanbiz.test;

import com.ivanbiz.dao.JurnalDAO;
import com.ivanbiz.dao.impl.JurnalDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
                List listJurnal = new ArrayList();
                listJurnal.add("001-02#10000#CC003");
                listJurnal.add("001-01#5000#CC003");
		JurnalDAO jurnalDAO = new JurnalDAOImpl();
		try {
			//System.out.println(jurnalDAO.saveJurnal("001-02", 5000));
			//                 System.out.println(jurnalDAO.saveJurnalMore(listJurnal));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
