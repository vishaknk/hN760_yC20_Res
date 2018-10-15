/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author Visak
 */
public class Dashboard extends javax.swing.JFrame {
    
    private JPanel visiblePanel;

    /**
     * Creates new form OrderDetails
     */
    public Dashboard() {
        initComponents();
        //Adding initial screen
        OrderPanel orderPanel = new OrderPanel();
        setMainLayout(orderPanel, p_main);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_top_header = new javax.swing.JPanel();
        l_name = new javax.swing.JLabel();
        p_menu = new javax.swing.JPanel();
        lb_dashboard = new javax.swing.JLabel();
        lb_menu = new javax.swing.JLabel();
        lb_order = new javax.swing.JLabel();
        lb_table = new javax.swing.JLabel();
        lb_staff = new javax.swing.JLabel();
        lb_kitchen = new javax.swing.JLabel();
        lb_payroll = new javax.swing.JLabel();
        lb_reports = new javax.swing.JLabel();
        lb_settings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        p_main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 550));

        p_top_header.setBackground(new java.awt.Color(8, 140, 234));

        l_name.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        l_name.setForeground(new java.awt.Color(255, 255, 255));
        l_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l_name.setText("Easy Resturant");
        l_name.setPreferredSize(new java.awt.Dimension(220, 25));
        p_top_header.add(l_name);

        p_menu.setBackground(new java.awt.Color(8, 140, 234));

        lb_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        lb_dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        lb_dashboard.setText("Dashboard");
        lb_dashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_dashboard.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_dashboard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_dashboardMouseClicked(evt);
            }
        });
        p_menu.add(lb_dashboard);

        lb_menu.setForeground(new java.awt.Color(255, 255, 255));
        lb_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu.png"))); // NOI18N
        lb_menu.setText("Menu");
        lb_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_menu.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_menu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_menuMouseClicked(evt);
            }
        });
        p_menu.add(lb_menu);

        lb_order.setForeground(new java.awt.Color(255, 255, 255));
        lb_order.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/order.png"))); // NOI18N
        lb_order.setText("Order");
        lb_order.setToolTipText("");
        lb_order.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_order.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_order.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_orderMouseClicked(evt);
            }
        });
        p_menu.add(lb_order);

        lb_table.setForeground(new java.awt.Color(255, 255, 255));
        lb_table.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_table.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/table.png"))); // NOI18N
        lb_table.setText("Table");
        lb_table.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_table.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_table.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_tableMouseClicked(evt);
            }
        });
        p_menu.add(lb_table);

        lb_staff.setForeground(new java.awt.Color(255, 255, 255));
        lb_staff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_staff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/staff.png"))); // NOI18N
        lb_staff.setText("Staff");
        lb_staff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_staff.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_staff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_staffMouseClicked(evt);
            }
        });
        p_menu.add(lb_staff);

        lb_kitchen.setForeground(new java.awt.Color(255, 255, 255));
        lb_kitchen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_kitchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kitchen.png"))); // NOI18N
        lb_kitchen.setText("Kitchen");
        lb_kitchen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_kitchen.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_kitchen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_kitchen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_kitchenMouseClicked(evt);
            }
        });
        p_menu.add(lb_kitchen);

        lb_payroll.setForeground(new java.awt.Color(255, 255, 255));
        lb_payroll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_payroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/payroll.png"))); // NOI18N
        lb_payroll.setText("Payroll");
        lb_payroll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_payroll.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_payroll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_payroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_payrollMouseClicked(evt);
            }
        });
        p_menu.add(lb_payroll);

        lb_reports.setForeground(new java.awt.Color(255, 255, 255));
        lb_reports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/report.png"))); // NOI18N
        lb_reports.setText("Reports");
        lb_reports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_reports.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_reports.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_reportsMouseClicked(evt);
            }
        });
        p_menu.add(lb_reports);

        lb_settings.setForeground(new java.awt.Color(255, 255, 255));
        lb_settings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        lb_settings.setText("Settings");
        lb_settings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_settings.setPreferredSize(new java.awt.Dimension(80, 80));
        lb_settings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lb_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_settingsMouseClicked(evt);
            }
        });
        p_menu.add(lb_settings);

        p_top_header.add(p_menu);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Profile");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 16));
        p_top_header.add(jLabel1);

        p_main.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_top_header, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p_top_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_dashboardMouseClicked

    private void lb_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_menuMouseClicked
        // TODO add your handling code here:
        new FoodType().setVisible(true);
    }//GEN-LAST:event_lb_menuMouseClicked

    private void lb_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_orderMouseClicked
        // TODO add your handling code here:
        if(visiblePanel != null)
            removeMainLayout(visiblePanel, p_main);
        OrderPanel orderPanel = new OrderPanel();
        visiblePanel = orderPanel;
        setMainLayout(orderPanel, p_main);
    }//GEN-LAST:event_lb_orderMouseClicked

    private void lb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_tableMouseClicked
        // TODO add your handling code here:
        if(visiblePanel != null)
            removeMainLayout(visiblePanel, p_main);
        
        TablePanel panel = new TablePanel();
        visiblePanel = panel;
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_lb_tableMouseClicked

    private void lb_staffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_staffMouseClicked
        // TODO add your handling code here:
        new StaffDetails().setVisible(true);
    }//GEN-LAST:event_lb_staffMouseClicked

    private void lb_kitchenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_kitchenMouseClicked
        // TODO add your handling code here:
        if(visiblePanel != null)
            removeMainLayout(visiblePanel, p_main);
        
        FoodMeatType panel = new FoodMeatType();
        visiblePanel = panel;
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_lb_kitchenMouseClicked

    private void lb_payrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_payrollMouseClicked
        // TODO add your handling code here:
        if(visiblePanel != null)
            removeMainLayout(visiblePanel, p_main);
        
        FoodCategory panel = new FoodCategory();
        visiblePanel = panel;
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_lb_payrollMouseClicked

    private void lb_reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_reportsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_reportsMouseClicked

    private void lb_settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_settingsMouseClicked
        // TODO add your handling code here:
        if(visiblePanel != null)
            removeMainLayout(visiblePanel, p_main);
        
        ShopeDetails panel = new ShopeDetails();
        visiblePanel = panel;
        setMainLayout(panel,p_main);
    }//GEN-LAST:event_lb_settingsMouseClicked

    private void setMainLayout(JPanel toAddPanel, JPanel mainPanel) {
        toAddPanel.setVisible(true);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(toAddPanel);
        mainPanel.validate();
    }
    
    private void removeMainLayout(JPanel toAddPanel, JPanel mainPanel) {
        mainPanel.removeAll();
        mainPanel.validate();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel lb_dashboard;
    private javax.swing.JLabel lb_kitchen;
    private javax.swing.JLabel lb_menu;
    private javax.swing.JLabel lb_order;
    private javax.swing.JLabel lb_payroll;
    private javax.swing.JLabel lb_reports;
    private javax.swing.JLabel lb_settings;
    private javax.swing.JLabel lb_staff;
    private javax.swing.JLabel lb_table;
    private javax.swing.JPanel p_main;
    private javax.swing.JPanel p_menu;
    private javax.swing.JPanel p_top_header;
    // End of variables declaration//GEN-END:variables
}
