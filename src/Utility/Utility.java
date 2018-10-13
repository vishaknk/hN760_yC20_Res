/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author priyesh
 */
public class Utility {

    public static String ROLE = "Admin";
    public static String NAME = "";
    public static int ID = 1;
    public static int user_id;
    public static SimpleDateFormat mysql = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat mysqldatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

     public static boolean validatePhone(String phone) {
        String regexMobile = "^[0-9]*$";
        if (!phone.matches(regexMobile)) {
            return false;
        }

        return true;
    }

     public static boolean isNullOrEmpty(String item) {
       
        if (item == null || item.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean validateEmailAddress(String email) {
        Pattern emailNamePtrn = Pattern.compile(
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mtch = emailNamePtrn.matcher(email);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

}
