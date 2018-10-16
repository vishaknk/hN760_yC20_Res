/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DBConnection.SQLRun;
import Utility.ProductButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.ItemModel;
import model.OrderItemModel;
import Interface.CategoryListener;
import Interface.ProductListener;
import Services.FoodCategoryService;
import Services.FoodMeatService;
import Services.FoodTypeService;
import Services.TableService;
import java.sql.ResultSet;
import java.util.List;
import model.FoodCategoryModel;
import model.FoodMeatModel;
import model.FoodTimingModel;
import model.FoodTypeModel;
import model.FoodVegType;
import model.TableModel;

/**
 *
 * @author Visak
 */
public class CategoryItem extends javax.swing.JFrame {

    private ArrayList<ItemModel> foodCategoryType;
    private CategoryListener listener;

    public CategoryItem() {
        initComponents();
    }

    /**
     * Creates new form CategoryItem
     */
    public CategoryItem(int id) {
        initComponents();
        //Model class to store the item data
        foodCategoryType = new ArrayList<>();
        setCategoryItems(id);
    }

    public void setCategoryItems(int id) {
        foodCategoryType.clear();
        switch (id) {
            case 3:
                FoodCategoryService categoryService = new FoodCategoryService();
                List<FoodCategoryModel> categoryModels = new ArrayList<>();
                categoryModels = categoryService.getFoodItems();
                //Adding category items
                for (int index = 0; index < categoryModels.size(); index++) {
                    ItemModel model = new ItemModel();
                    model.setSelected(categoryModels.get(index).getFood_category_id());
                    model.setImage("");
                    model.setName(categoryModels.get(index).getFood_category_name());
                    foodCategoryType.add(model);
                }
                break;
            case 2:
                 FoodTypeService typeService = new FoodTypeService();
                List<FoodTypeModel> foodTypeModels = new ArrayList<>();
                foodTypeModels = typeService.getFoodItems();
                //Adding category items
                for (int index = 0; index < foodTypeModels.size(); index++) {
                    ItemModel model = new ItemModel();
                    model.setSelected(foodTypeModels.get(index).getFood_type_id());
                    model.setImage("");
                    model.setName(foodTypeModels.get(index).getFood_type_name());
                    foodCategoryType.add(model);
                }
                break;
            case 4:
                FoodMeatService meatService = new FoodMeatService();
                List<FoodMeatModel> foodMeatModels = new ArrayList<>();
                foodMeatModels = meatService.getFoodItems();
                //Adding category items
                for (int index = 0; index < foodMeatModels.size(); index++) {
                    ItemModel model = new ItemModel();
                    model.setSelected(foodMeatModels.get(index).getFood_meat_id());
                    model.setImage("");
                    model.setName(foodMeatModels.get(index).getFood_meat_name());
                    foodCategoryType.add(model);
                }
                break;
            case 0:
              
                ItemModel model = new ItemModel();
                    model.setSelected(1);
                    model.setImage("");
                    model.setName("Vegeterian");
                    foodCategoryType.add(model);
                    model = new ItemModel();
                    model.setSelected(2);
                    model.setImage("");
                    model.setName("Non-Vegeterian");
                    foodCategoryType.add(model);
                break;
            case 1:
                 ItemModel models = new ItemModel();
                  models.setSelected(1);
                    models.setImage("");
                    models.setName("All Time");
                    foodCategoryType.add(models);
                    models = new ItemModel();
                  models.setSelected(2);
                    models.setImage("");
                    models.setName("Breakfast");
                    foodCategoryType.add(models);
                    models = new ItemModel();
                  models.setSelected(3);
                    models.setImage("");
                    models.setName("Lunch");
                    foodCategoryType.add(models);
                    models = new ItemModel();
                  models.setSelected(4);
                    models.setImage("");
                    models.setName("Dinner");
                    foodCategoryType.add(models);
                
                break;

            //add table list
            case 5:
                TableService tableService = new TableService();
                List<TableModel> tableList = new ArrayList<>();
                tableList = tableService.getAllActiveTables();
                for (int index = 0; index < tableList.size(); index++) {
                    ItemModel item = new ItemModel();
                    item.setSelected(tableList.get(index).getTable_id());
                    item.setImage("");
                    item.setName(tableList.get(index).getTable_name());
                    foodCategoryType.add(item);
                }
                break;
        }

        JPanel contentOrderItem = new JPanel();
        contentOrderItem.setLayout(new GridLayout(0, 4));
        ProductButton buttonOrderItem[] = new ProductButton[100];

        for (int index = 0; index < foodCategoryType.size(); index++) {
            buttonOrderItem[index] = new ProductButton(foodCategoryType.get(index), id, CategoryListener.CATEGORY);
            buttonOrderItem[index].addProductListener(new CategoryListener() {
                @Override
                public void clickedCategory(int index, ItemModel model) {
                    listener.clickedCategory(index, model);
                    hide();
                }

                @Override
                public void clickedProducts(int index, OrderItemModel model) {
                }
            });
            contentOrderItem.add(buttonOrderItem[index]);
        }
        sp_category_item.getViewport().setView(contentOrderItem);
    }

    public void setListener(CategoryListener listener) {
        this.listener = listener;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_category_item = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        sp_category_item.setBorder(null);
        sp_category_item.setPreferredSize(new java.awt.Dimension(500, 400));
        sp_category_item.setSize(new java.awt.Dimension(500, 400));
        getContentPane().add(sp_category_item);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CategoryItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane sp_category_item;
    // End of variables declaration//GEN-END:variables
}
