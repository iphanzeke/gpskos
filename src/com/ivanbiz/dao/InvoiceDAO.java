/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.dao;

import com.ivanbiz.model.Invoice;
import java.util.List;

/**
 *
 * @author City_Z
 */
public interface InvoiceDAO extends GenericDAO {

    public String sendInvoiceWithJurnal(Invoice invoice, String proCode, String glCredit) throws Exception;

    public String sendInvoice(Invoice invoice, String proCode, String glCredit) throws Exception;

    public List<Invoice> getDataByEquals(String string) throws Exception;
}
