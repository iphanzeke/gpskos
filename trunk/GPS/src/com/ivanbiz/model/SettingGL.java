package com.ivanbiz.model;

public class SettingGL {

	private long id;
	private String glAccount;
	private String debetOrCredit;
	private String proCode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDebetOrCredit() {
		return debetOrCredit;
	}
	public void setDebetOrCredit(String debetOrCredit) {
		this.debetOrCredit = debetOrCredit;
	}
	

    /**
     * @return the glAccount
     */
    public String getGlAccount() {
        return glAccount;
    }

    /**
     * @param glAccount the glAccount to set
     */
    public void setGlAccount(String glAccount) {
        this.glAccount = glAccount;
    }

    /**
     * @return the proCode
     */
    public String getProCode() {
        return proCode;
    }

    /**
     * @param proCode the proCode to set
     */
    public void setProCode(String proCode) {
        this.proCode = proCode;
    }
}
