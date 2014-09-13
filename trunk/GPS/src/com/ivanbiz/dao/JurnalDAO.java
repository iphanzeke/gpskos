package com.ivanbiz.dao;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;

public interface JurnalDAO extends GenericDAO {

	public String saveJurnal(String proCode,BigDecimal amount,String transRef,String glDebit,String glKredit,Session session)throws Exception;
	//public String reversalJurnal(String accRef)throws Exception;
       // public String saveJurnalMore(List listItem,String glDebit,String glKredit,Session session)throws Exception;
        public String saveJurnalWithVA(String proCode,BigDecimal amount,String transRef,String virtualAccount,String glDebit,String glKredit,Session session)throws Exception;
       // public String saveJurnalMoreWithVA(List listItem,String glDebit,String glKredit,Session session)throws Exception;
}
