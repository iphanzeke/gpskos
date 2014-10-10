/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.CashBalance;
import java.util.List;

/**
 *
 * @author City_Z
 */
public interface CashBalanceDAO extends GenericDAO{
    public List getBalanceOrderDate(long idGL)throws Exception;
    public CashBalance getBalanceByOrderDate(long idGL)throws Exception;
}
