/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.test;

import com.ivanbiz.model.RekonBank;
import com.ivanbiz.service.ReadExcell;
import java.util.Date;
import java.util.List;

/**
 *
 * @author City_Z
 */
public class Test {
    public static void main(String args[]){
        ReadExcell re = new ReadExcell();
        List list = re.readExcell("C:/1.xls", new Date(), new Date(), "001");
       System.out.println(list);
        for(int x=0;x<list.size();x++){
            RekonBank rb = (RekonBank)list.get(x);
            System.out.println(rb.getData());
        }
      //  System.out.println(list.toString());
    }
}
