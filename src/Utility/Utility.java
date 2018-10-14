/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static String getMacAddress() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network;
            network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
        } catch (SocketException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
