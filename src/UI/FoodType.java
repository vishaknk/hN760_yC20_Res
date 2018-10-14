/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.FoodTypeService;
import Utility.ButtonColumn;
import Utility.Utility;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.FoodTypeModel;

/**
 *
 * @author priyesh
 */
public class FoodType extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public FoodType() {
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
        getFoodItems();
    }

    public void getFoodItems() {
        FoodTypeService foodItemService = new FoodTypeService();
        List<FoodTypeModel> foodItemList = foodItemService.getFoodItems();
        if (foodItemList.size() <= 0) {
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
        String data[][] = new String[foodItemList.size()][4];
        for (int i = 0; i < foodItemList.size(); i++) {
            data[i][0] = new Integer(foodItemList.get(i).getFood_type_id()).toString();
            data[i][1] = foodItemList.get(i).getFood_type_name();
            data[i][2] = "Update";
            data[i][3] = "Delete";
        }
        String columnNames[] = new String[]{"food_type_id", "food_type_name", "action", "action2"};
        DefaultTableModel tbl = new DefaultTableModel(data, columnNames);
        foodTypeTable.setModel(tbl);

        Action update = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String idValString = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int idVal = Integer.parseInt(idValString);
                editField(idVal);
            }

            private void editField(int idVal) {
                foodId = idVal;
                FoodTypeModel foodModel = new FoodTypeModel();
                foodModel.setFood_type_id(idVal);
                FoodTypeService foodItemService = new FoodTypeService();
                foodModel = foodItemService.getFoodDetailsById(idVal);
                foodTypeValue.setText(foodModel.getFood_type_name());
                addFood.setText("Update Food Item");
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String id = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int foodId = Integer.parseInt(id);
                FoodTypeModel foodTypeModel = new FoodTypeModel();
                foodTypeModel.setFood_type_id(foodId);

                int dialogResult = JOptionPane.showConfirmDialog(null, "Confirm delete ?", "Warning", JOptionPane.YES_NO_OPTION);
                int status = 0;
                if (dialogResult == JOptionPane.YES_OPTION) {
                    status = foodItemService.deleteFoodItem(foodTypeModel.getFood_type_id());
                }

                if (status == 1) {
                    getFoodItems();
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
                FoodTypeModel foodTypeModel = new FoodTypeModel();
                foodTypeModel.setFood_type_id(idVal);
                foodTypeModel = foodItemService.getFoodDetailsById(foodTypeModel.getFood_type_id());

//                Utility.visiblePanel.setVisible(false);
//                Utility.ticketForm = new TicketForm();
//                Utility.ticketForm.fillInCustomerDetails(customer);
//                 Utility.visiblePanel=Utility.ticketForm;
//                Utility.visiblePanel.setVisible(true);
//                Utility.skelitionForm.add(Utility.visiblePanel);
            }
        };

        ButtonColumn buttonColumnEdit = new ButtonColumn(foodTypeTable, update, 2);
        buttonColumnEdit.setMnemonic(KeyEvent.VK_D);
        ButtonColumn buttonColumnDelete = new ButtonColumn(foodTypeTable, delete, 3);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addFood = new javax.swing.JButton();
        foodTypeValue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodTypeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Food Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel2.setText("Food Type Name");

        addFood.setBackground(new java.awt.Color(0, 153, 255));
        addFood.setForeground(new java.awt.Color(255, 255, 255));
        addFood.setText("Add food type");
        addFood.setName("LoginBtn"); // NOI18N
        addFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFoodActionPerformed(evt);
            }
        });

        foodTypeValue.setToolTipText("Food Type Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1072, Short.MAX_VALUE)
                        .addComponent(addFood, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(foodTypeValue))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foodTypeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addFood, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        foodTypeValue.getAccessibleContext().setAccessibleName("Food Type Name");

        foodTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sl. No.", "Food Type", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(foodTypeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFoodActionPerformed
        // TODO add your handling code here:
        // validation for empty
        if (foodTypeValue.getText().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter some food type.", "ERROR", 0);
            return;
        }
        FoodTypeModel foodType = new FoodTypeModel();
        foodType.setFood_type_name(foodTypeValue.getText().toString());

        FoodTypeService foodTypeService = new FoodTypeService();
        int response;
        if (addFood.getText().contains("Update")) {
            foodType.setFood_type_id(foodId);
            response = foodTypeService.saveOrUpdateFoodType(foodType, false);
        } else {
            response = foodTypeService.saveOrUpdateFoodType(foodType, true);
        }
        clearAll();
        if (response == 1) {
            getFoodItems();
            JOptionPane.showMessageDialog(null, "Food Type " + foodType.getFood_type_name() + " has been updated successfully", "Success", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid", "ERROR", 0);

        }

    }//GEN-LAST:event_addFoodActionPerformed

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
            java.util.logging.Logger.getLogger(FoodType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodType().setVisible(true);
            }
        });
    }

    public void clearAll() {
        foodTypeValue.setText("");
    }

    int foodId;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFood;
    private javax.swing.JTable foodTypeTable;
    private javax.swing.JTextField foodTypeValue;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
