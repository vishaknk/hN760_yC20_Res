/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.FoodMeatService;
import Utility.ButtonColumn;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.FoodMeatModel;
import model.FoodMeatModel;

/**
 *
 * @author priyesh
 */
public class FoodMeatType extends javax.swing.JPanel {

    /**
     * Creates new form FoodCategory
     */
    public FoodMeatType() {
        initComponents();
        getFoodItems();
    }

    public void getFoodItems() {
        FoodMeatService foodMeatService = new FoodMeatService();
        List<FoodMeatModel> foodItemList = foodMeatService.getFoodItems();

        String data[][] = new String[foodItemList.size()][4];
        for (int i = 0; i < foodItemList.size(); i++) {
            data[i][0] = new Integer(i + 1).toString();
            data[i][1] = foodItemList.get(i).getFood_meat_name();
            data[i][2] = "Update";
            data[i][3] = "Delete";
        }
        String columnNames[] = new String[]{"Sl.No.", "Food Meat Type", "", ""};
        DefaultTableModel tbl = new DefaultTableModel(data, columnNames);
        foodCategoryTable.setModel(tbl);

        Action update = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String idValString = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int idVal = Integer.parseInt(idValString);
                editField(foodItemList.get(idVal - 1).getFood_meat_id());
            }

            private void editField(int idVal) {
                foodCategoryId = idVal;
                FoodMeatModel foodModel = new FoodMeatModel();
                foodModel.setFood_meat_id(idVal);
                FoodMeatService foodMeatService = new FoodMeatService();
                foodModel = foodMeatService.getFoodDetailsById(idVal);
                foodCategoryName.setText(foodModel.getFood_meat_name());
                addFood.setText("Update");
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String id = (String) ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int foodId = foodItemList.get(Integer.parseInt(id) - 1).getFood_meat_id();
                FoodMeatModel foodTypeModel = new FoodMeatModel();
                foodTypeModel.setFood_meat_id(foodId);

                int dialogResult = JOptionPane.showConfirmDialog(null, "Confirm delete ?", "Warning", JOptionPane.YES_NO_OPTION);
                int status = 0;
                if (dialogResult == JOptionPane.YES_OPTION) {
                    status = foodMeatService.deleteFoodItem(foodId);
                }

                if (status == 1) {
                     clearAll();
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
                int idVal = Integer.parseInt(idValString) + 1;
                FoodMeatModel foodTypeModel = new FoodMeatModel();
                foodTypeModel.setFood_meat_id(idVal);
                foodTypeModel = foodMeatService.getFoodDetailsById(foodTypeModel.getFood_meat_id());

//                Utility.visiblePanel.setVisible(false);
//                Utility.ticketForm = new TicketForm();
//                Utility.ticketForm.fillInCustomerDetails(customer);
//                 Utility.visiblePanel=Utility.ticketForm;
//                Utility.visiblePanel.setVisible(true);
//                Utility.skelitionForm.add(Utility.visiblePanel);
            }
        };

        ButtonColumn buttonColumnEdit = new ButtonColumn(foodCategoryTable, update, 2);
        buttonColumnEdit.setMnemonic(KeyEvent.VK_D);
        ButtonColumn buttonColumnDelete = new ButtonColumn(foodCategoryTable, delete, 3);
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
        foodCategoryName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodCategoryTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Meat Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel2.setText("Food Meat Name");

        addFood.setBackground(new java.awt.Color(0, 153, 255));
        addFood.setForeground(new java.awt.Color(255, 255, 255));
        addFood.setText("Add food category");
        addFood.setName("LoginBtn"); // NOI18N
        addFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFoodActionPerformed(evt);
            }
        });

        foodCategoryName.setToolTipText("Food Meat Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 995, Short.MAX_VALUE))
                    .addComponent(foodCategoryName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addFood, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foodCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFood, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        foodCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sl. No.", "Food Category", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(foodCategoryTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFoodActionPerformed
        // TODO add your handling code here:
        // validation for empty
        if (foodCategoryName.getText().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter some food category.", "ERROR", 0);
            return;
        }
        FoodMeatModel foodCategory = new FoodMeatModel();
        foodCategory.setFood_meat_name(foodCategoryName.getText().toString());

        FoodMeatService foodMeatService = new FoodMeatService();
        int response;
        if (addFood.getText().contains("Update")) {
            foodCategory.setFood_meat_id(foodCategoryId);
            response = foodMeatService.saveOrUpdateFoodMeatType(foodCategory, false);
        } else {
            response = foodMeatService.saveOrUpdateFoodMeatType(foodCategory, true);
        }
        clearAll();
        if (response == 1) {
            getFoodItems();
            JOptionPane.showMessageDialog(null, "Food Type " + foodCategory.getFood_meat_name() + " has been updated successfully", "Success", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid", "ERROR", 0);

        }

    }//GEN-LAST:event_addFoodActionPerformed

    private int foodCategoryId;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFood;
    private javax.swing.JTextField foodCategoryName;
    private javax.swing.JTable foodCategoryTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
public void clearAll() {
        foodCategoryName.setText("");
        addFood.setText("Create");
    }
}
