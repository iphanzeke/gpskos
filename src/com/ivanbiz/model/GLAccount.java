/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

/**
 *
 * @author City_Z
 */
public class GLAccount {
    private long id;
    private String noGL;
    private String nameGL;
    private String groupACC;
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
     * @return the noGL
     */
    public String getNoGL() {
        return noGL;
    }

    /**
     * @param noGL the noGL to set
     */
    public void setNoGL(String noGL) {
        this.noGL = noGL;
    }

    /**
     * @return the nameGL
     */
    public String getNameGL() {
        return nameGL;
    }

    /**
     * @param nameGL the nameGL to set
     */
    public void setNameGL(String nameGL) {
        this.nameGL = nameGL;
    }

    /**
     * @return the groupACC
     */
    public String getGroupACC() {
        return groupACC;
    }

    /**
     * @param groupACC the groupACC to set
     */
    public void setGroupACC(String groupACC) {
        this.groupACC = groupACC;
    }
    
}
