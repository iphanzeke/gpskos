/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Pengguna;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface PenggunaDAO extends GenericDAO {

    public List getDataByLike(Class claz, String variable, Object input, String variable2, Object input2) throws Exception;

    public Pengguna login(String penggunaName, String password) throws Exception;

    public String getLastKode() throws Exception;
}
