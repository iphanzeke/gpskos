/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

import java.util.Date;

/**
 *
 * @author City_Z
 */
public class RekonBank {
    
    private long id;
    private String data;
    private Date startDate;
    private Date endDate;
    private String kreditur;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the kreditur
     */
    public String getKreditur() {
        return kreditur;
    }

    /**
     * @param kreditur the kreditur to set
     */
    public void setKreditur(String kreditur) {
        this.kreditur = kreditur;
    }
    
    
}
