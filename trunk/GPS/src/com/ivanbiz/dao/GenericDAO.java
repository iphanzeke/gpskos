/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author City_Z
 */
public interface GenericDAO {
    public void delete(Object obj) throws Exception;

    public void update(Object obj) throws Exception;

    public Object load(Class clasz, long id) throws Exception;

    public void save(Object obj) throws Exception;

    public void saveOrUpdate(Object obj) throws Exception;

    public List getAll(Class claz) throws Exception;

    public List getDataByLike(Class clazImpl, String variable, Object input) throws Exception;

    public List getDataByEquals(Class clazImpl, String variable, Object input) throws Exception;

    public Object getDataByEqual(Class clazImpl, String variable, Object input) throws Exception;

    public List getData(Class claz,Date start,Date end) throws Exception;
    
    public List getDataByEqualsMore(Class clazImpl,Map map)throws Exception;
    
    public Object getDataByEqualMore(Class clazImpl,Map map)throws Exception;
    
    public String validateField(Class clazImpl,String variable,Object input)throws Exception;
    
    public String validateFieldSession(Class clazImpl,String variable,Object input,Session session)throws Exception;
    
    public List getDataByDateAndVar(Class claz,Date start,Date end,String variable,Object input)throws Exception;
}
