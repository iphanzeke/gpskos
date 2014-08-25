package com.ivanbiz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ivanbiz.dao.SettingGLDAO;

public class SettingGLDAOImpl extends GenericDAOImpl implements SettingGLDAO{

	@Override
	public List getListByNoGL(String proCode,Session session) throws Exception {
		List list = new ArrayList();		
		Query query = session.createQuery("from com.ivanbiz.model.SettingGL s where s.proCode.noProCode='"+proCode+"'");
		list = query.list();
		return list;
	}

	
}
