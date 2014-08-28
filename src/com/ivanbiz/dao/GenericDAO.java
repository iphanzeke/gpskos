/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import java.util.Date;
import java.util.List;

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
}
