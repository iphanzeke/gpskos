/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

import com.ivanbiz.service.MenuAksesConstant;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AksesMatrix implements Serializable {

    private long id;
    private Groups groups;
    private boolean menuChecked;
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean isMenuChecked() {
        return menuChecked;
    }

    public void setMenuChecked(boolean menuChecked) {
        this.menuChecked = menuChecked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
