package com.ivanbiz.dao;

import java.util.List;

import org.hibernate.Session;

public interface SettingGLDAO extends GenericDAO{
     public List getListByNoGL(String proCode,Session session)throws Exception;
}
