/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Groups;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface GroupsDAO extends GenericDAO {

    public void delete(Groups groups, List<AksesMatrix> listAksesMatrix) throws Exception;

    public void saveOrUpdate(Groups groups, List<AksesMatrix> listAksesMatrixView) throws Exception;
}
