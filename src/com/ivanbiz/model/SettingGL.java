package com.ivanbiz.model;

public class SettingGL {

	private long id;
	private GLAccount glAccount;
	private String debetOrCredit;
	private ProCode proCode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public GLAccount getGlAccount() {
		return glAccount;
	}
	public void setGlAccount(GLAccount glAccount) {
		this.glAccount = glAccount;
	}
	public String getDebetOrCredit() {
		return debetOrCredit;
	}
	public void setDebetOrCredit(String debetOrCredit) {
		this.debetOrCredit = debetOrCredit;
	}
	public ProCode getProCode() {
		return proCode;
	}
	public void setProCode(ProCode proCode) {
		this.proCode = proCode;
	}
}
