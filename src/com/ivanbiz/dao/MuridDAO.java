/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Murid;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface MuridDAO extends GenericDAO {

    public List getAll(Murid murid) throws Exception;

    public List getDataByLikeBank(String input) throws Exception;
}
