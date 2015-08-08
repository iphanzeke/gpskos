/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import com.ivanbiz.model.AksesMatrix;
import com.ivanbiz.model.Pengguna;
import com.ivanbiz.model.Perusahaan;
import java.util.List;

/**
 *
 * @author Shbt Peterpan
 */
public class GlobalSession {

    private static Perusahaan perusahaan;
    private static List<AksesMatrix> listAksesMatrix;
    private static Pengguna pengguna;
    private static List<Pengguna> listGroups;

    public static List<Pengguna> getListGroups() {
        return listGroups;
    }

    public static void setListGroups(List<Pengguna> listGroups) {
        GlobalSession.listGroups = listGroups;
    }

    public static Pengguna getPengguna() {
        return pengguna;
    }

    public static void setPengguna(Pengguna pengguna) {
        GlobalSession.pengguna = pengguna;
    }

    public static List<AksesMatrix> getListAksesMatrix() {
        return listAksesMatrix;
    }

    public static void setListAksesMatrix(List<AksesMatrix> listAksesMatrix) {
        GlobalSession.listAksesMatrix = listAksesMatrix;
    }

    public static Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public static void setPerusahaan(Perusahaan perusahaan) {
        GlobalSession.perusahaan = perusahaan;
    }
}
