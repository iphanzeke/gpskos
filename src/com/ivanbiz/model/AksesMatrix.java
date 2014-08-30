/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.model;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class AksesMatrix implements Serializable {

    private long id;
    private MenuAkses menuAkses;
    private Groups groups;
    private boolean menuChecked;

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

    public MenuAkses getMenuAkses() {
        return menuAkses;
    }

    public void setMenuAkses(MenuAkses menuAkses) {
        this.menuAkses = menuAkses;
    }
}
