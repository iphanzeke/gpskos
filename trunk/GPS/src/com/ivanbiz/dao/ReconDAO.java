/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import java.util.Map;

/**
 *
 * @author City_Z
 */
public interface ReconDAO extends GenericDAO{
    public Map getDataByKelas(long idKelas)throws Exception;
}