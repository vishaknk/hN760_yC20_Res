/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.StaffDetailsService;
import Utility.ButtonColumn;
import Utility.Utility;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.StaffDetailsModel;

/**
 *
 * @author priyesh
 */
public class StaffPanel extends javax.swing.JPanel {

    /**
     * Creates new form StaffPanel
     */
    public StaffPanel() {
        initComponents();
        getAllStaffs();
    }
    
    public void getAllStaffs() {
        StaffDetailsService staffDetailsService = new StaffDetailsService();
        List<StaffDetailsModel> staffList = staffDetailsService.getStaffs();
        
        String data[][] = new String[staffList.size()][8];
        for (int i = 0; i < staffList.size(); i++) {
            data[i][0] = new Integer(i + 1).toString();
            data[i][1] = staffList.get(i).getName();
            data[i][2] = staffList.get(i).getMobile();
            data[i][3] = staffList.get(i).getEmail();
            data[i][4] = staffList.get(i).getPassword();
            data[i][5] = staffList.get(i).getStatus() == 1 ? "Active" : "Inactive";
            data[i][6] = "Update";
            data[i][7] = "Delete";
        }
        String columnNames[] = new String[]{"Sl.No.", "Name", "Mobile", "Email", "Password", "Status", "", ""};
        DefaultTableModel tbl = new DefaultTableModel(data, columnNames);
        staffTable.setModel(tbl);

        Action update = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String idValString = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int idVal = Integer.parseInt(idValString);
                editField(staffList.get(idVal - 1));
            }

            private void editField(StaffDetailsModel staffModel) {
                staffId = staffModel.getUser_id();
                StaffDetailsService staffDetailsService = new StaffDetailsService();
                staff_name.setText(staffModel.getName());
                staff_mobile.setText(staffModel.getMobile());
                staff_email.setText(staffModel.getEmail());
                staff_password.setText(staffModel.getPassword());
                addstaff.setText("Update Staff Details");
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String id = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int userID = staffList.get(Integer.parseInt(id) - 1).getUser_id();

                int dialogResult = JOptionPane.showConfirmDialog(null, "Confirm Deactivation ?", "Warning", JOptionPane.YES_NO_OPTION);
                int status = 0;
                if (dialogResult == JOptionPane.YES_OPTION) {
                    status = staffDetailsService.deleteStaff(userID);
                }

                if (status == 1) {
                    getAllStaffs();
                }

            }
        };

        Action updatecustomer = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String idValString = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int idVal = Integer.parseInt(idValString);
                StaffDetailsModel foodTypeModel = new StaffDetailsModel();
                foodTypeModel.setUser_id(idVal);
                foodTypeModel = staffDetailsService.getFoodDetailsById(foodTypeModel.getUser_id());

//                Utility.visiblePanel.setVisible(false);
//                Utility.ticketForm = new TicketForm();
//                Utility.ticketForm.fillInCustomerDetails(customer);
//                 Utility.visiblePanel=Utility.ticketForm;
//                Utility.visiblePanel.setVisible(true);
//                Utility.skelitionForm.add(Utility.visiblePanel);
            }
        };

        ButtonColumn buttonColumnEdit = new ButtonColumn(staffTable, update, 6);
        buttonColumnEdit.setMnemonic(KeyEvent.VK_D);
        ButtonColumn buttonColumnDelete = new ButtonColumn(staffTable, delete, 7);
        buttonColumnDelete.setMnemonic(KeyEvent.VK_D);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        createStaffTitle = new javax.swing.JPanel();
        name_label = new javax.swing.JLabel();
        addstaff = new javax.swing.JButton();
        staff_name = new javax.swing.JTextField();
        email_label = new javax.swing.JLabel();
        staff_email = new javax.swing.JTextField();
        staff_password = new javax.swing.JTextField();
        password_label = new javax.swing.JLabel();
        mobile_label = new javax.swing.JLabel();
        staff_mobile = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sl. No.", "Name", "Mobile", "Email", "Password", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(staffTable);

        createStaffTitle.setBackground(new java.awt.Color(255, 255, 255));
        createStaffTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Food Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N

        name_label.setText("Staff Name*");

        addstaff.setBackground(new java.awt.Color(0, 153, 255));
        addstaff.setForeground(new java.awt.Color(255, 255, 255));
        addstaff.setText("Add Staff");
        addstaff.setName("LoginBtn"); // NOI18N
        addstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addstaffActionPerformed(evt);
            }
        });

        staff_name.setToolTipText("Food Type Name");

        email_label.setText("Staff Email*");

        staff_email.setToolTipText("Food Type Name");

        staff_password.setToolTipText("Food Type Name");

        password_label.setText("Staff Password*");

        mobile_label.setText("Staff Mobile*");

        staff_mobile.setToolTipText("Food Type Name");

        javax.swing.GroupLayout createStaffTitleLayout = new javax.swing.GroupLayout(createStaffTitle);
        createStaffTitle.setLayout(createStaffTitleLayout);
        createStaffTitleLayout.setHorizontalGroup(
            createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createStaffTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staff_email, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staff_password, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile_label, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createStaffTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        createStaffTitleLayout.setVerticalGroup(
            createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createStaffTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createStaffTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_email, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staff_password, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jTextField1.setBackground(new java.awt.Color(0, 153, 255));
        jTextField1.setText("Table List");
        jTextField1.setCaretColor(new java.awt.Color(0, 153, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createStaffTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(createStaffTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addstaffActionPerformed
        
       // TODO add your handling code here:
        // validation for empty
        if (Utility.isNullOrEmpty(staff_name.getText().toString().trim().toString())) {
            JOptionPane.showMessageDialog(null, "Name Cannot be Empty.", "ERROR", 0);
            return;
        }

        if (Utility.isNullOrEmpty(staff_mobile.getText().toString().trim().toString())) {
            JOptionPane.showMessageDialog(null, "Mobile Cannot be Empty.", "ERROR", 0);
            return;
        }

        if (Utility.isNullOrEmpty(staff_email.getText().toString().trim().toString())) {
            JOptionPane.showMessageDialog(null, "Email Cannot be Empty.", "ERROR", 0);
            return;
        }

        if (Utility.isNullOrEmpty(staff_password.getText().toString().trim().toString())) {
            JOptionPane.showMessageDialog(null, "Password Cannot be Empty.", "ERROR", 0);
            return;
        }
        if (!Utility.validatePhone(staff_mobile.getText().toString().trim().toString())) {
            JOptionPane.showMessageDialog(null, "Please enter valid phone number", "ERROR", 0);
            return;
        }

        if (!Utility.validateEmailAddress(staff_email.getText().toString().trim().toString())) {
            JOptionPane.showMessageDialog(null, "Please enter valid Email.", "ERROR", 0);
            return;
        }
        StaffDetailsModel staff = new StaffDetailsModel();
        staff.setName(staff_name.getText().toString());
        staff.setMobile(staff_mobile.getText().toString());
        staff.setEmail(staff_email.getText().toString());
        staff.setPassword(staff_password.getText().toString());

        StaffDetailsService foodTypeService = new StaffDetailsService();
        int response;
        if (addstaff.getText().contains("Update")) {
            staff.setUser_id(staffId);
            response = foodTypeService.saveOrUpdateStaffDetails(staff, false);
        } else {
            response = foodTypeService.saveOrUpdateStaffDetails(staff, true);
        }
        clearAll();
        if (response == 1) {
            getAllStaffs();
            JOptionPane.showMessageDialog(null, "Staff " + staff.getName() + " has been updated successfully", "Success", 1);

        } else {
            JOptionPane.showMessageDialog(null, "Invalid", "ERROR", 0);

        }

    }//GEN-LAST:event_addstaffActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

     private void clearAll() {
        staff_email.setText("");
        staff_mobile.setText("");
        staff_name.setText("");
        staff_password.setText("");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int staffId;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addstaff;
    private javax.swing.JPanel createStaffTitle;
    private javax.swing.JLabel email_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mobile_label;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel password_label;
    private javax.swing.JTable staffTable;
    private javax.swing.JTextField staff_email;
    private javax.swing.JTextField staff_mobile;
    private javax.swing.JTextField staff_name;
    private javax.swing.JTextField staff_password;
    // End of variables declaration//GEN-END:variables
}
