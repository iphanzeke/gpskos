/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import java.util.List;

/**
 *
 * @author City_Z
 */
public interface CashBalanceDAO extends GenericDAO{
    public List getBalanceOrderDate(long idGL)throws Exception;
}
