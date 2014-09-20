package com.ivanbiz.dao;

import com.ivanbiz.model.GLAccount;

public interface GLAccountDAO extends GenericDAO {
    public String saveGLKrediturWithSetting(GLAccount glAccount)throws Exception;
    public String saveGLBiayaLainWithSetting(GLAccount glAccount)throws Exception;
}
