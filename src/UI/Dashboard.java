/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.LoginServices;
import Utility.Utility;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author priyesh
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Dashboard() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (this.getWidth() / 2),
                middle.y - (this.getHeight() / 2));
        setLocation(newLocation);
        setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        //this.setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        /*this.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                validate();
            }
        });*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orders = new javax.swing.JButton();
        table = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        kitchen = new javax.swing.JButton();
        staff = new javax.swing.JButton();
        payroll = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        p_main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        orders.setBackground(new java.awt.Color(0, 153, 255));
        orders.setForeground(new java.awt.Color(255, 255, 255));
        orders.setText("Order");
        orders.setName("LoginBtn"); // NOI18N
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(0, 153, 255));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setText("Table");
        table.setName("LoginBtn"); // NOI18N
        table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableActionPerformed(evt);
            }
        });

        menu.setBackground(new java.awt.Color(0, 153, 255));
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("Menu");
        menu.setName("LoginBtn"); // NOI18N
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        kitchen.setBackground(new java.awt.Color(0, 153, 255));
        kitchen.setForeground(new java.awt.Color(255, 255, 255));
        kitchen.setText("Kitchen");
        kitchen.setName("LoginBtn"); // NOI18N
        kitchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitchenActionPerformed(evt);
            }
        });

        staff.setBackground(new java.awt.Color(0, 153, 255));
        staff.setForeground(new java.awt.Color(255, 255, 255));
        staff.setText("Staff");
        staff.setName("LoginBtn"); // NOI18N
        staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffActionPerformed(evt);
            }
        });

        payroll.setBackground(new java.awt.Color(0, 153, 255));
        payroll.setForeground(new java.awt.Color(255, 255, 255));
        payroll.setText("Payroll");
        payroll.setName("LoginBtn"); // NOI18N
        payroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollActionPerformed(evt);
            }
        });

        settings.setBackground(new java.awt.Color(0, 153, 255));
        settings.setForeground(new java.awt.Color(255, 255, 255));
        settings.setText("Settings");
        settings.setName("LoginBtn"); // NOI18N
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        p_main.setBackground(new java.awt.Color(238, 38, 238));

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kitchen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payroll, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
            .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kitchen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payroll, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        // TODO add your handling code here:
       
        new FoodType().setVisible(true);
       
    }//GEN-LAST:event_ordersActionPerformed

    private void tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableActionPerformed
        // TODO add your handling code here:
        TablePanel panel = new TablePanel();
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_tableActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // TODO add your handling code here:
        MenuPanel panel = new MenuPanel();
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_menuActionPerformed

    private void kitchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitchenActionPerformed
        // TODO add your handling code here:
        FoodMeatType panel = new FoodMeatType();
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_kitchenActionPerformed

    private void staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffActionPerformed
        // TODO add your handling code here:
         new StaffDetails().setVisible(true);
    }//GEN-LAST:event_staffActionPerformed

    private void payrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollActionPerformed
        // TODO add your handling code here:
        FoodCategory panel = new FoodCategory();
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_payrollActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:
        ShopeDetails panel = new ShopeDetails();
        setMainLayout(panel,p_main);
        
    }//GEN-LAST:event_settingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    
    private void setMainLayout(JPanel classObject, JPanel panel) {
        classObject.setVisible(true);
        panel.setLayout(new BorderLayout());
        panel.add(classObject);
        panel.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton kitchen;
    private javax.swing.JButton menu;
    private javax.swing.JButton orders;
    private javax.swing.JPanel p_main;
    private javax.swing.JButton payroll;
    private javax.swing.JButton settings;
    private javax.swing.JButton staff;
    private javax.swing.JButton table;
    // End of variables declaration//GEN-END:variables
}
