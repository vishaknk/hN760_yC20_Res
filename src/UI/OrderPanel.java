/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Utility.OrderItem;
import Utility.ProductButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import model.ItemModel;
import model.OrderItemModel;
import Interface.CategoryListener;
import Services.MenuService;
import Services.OrderService;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

/**
 *
 * @author Visak
 */
public class OrderPanel extends javax.swing.JPanel {

    private ArrayList<ItemModel> foodCategoryType;
    private ArrayList<ItemModel> foodCategoryList;
    //Product list contains the price, quantity and procduct name
    private ArrayList<OrderItemModel> foodProductList;
    private ArrayList<OrderItemModel> foodOrderedList;
    private CategoryItem categoryItem;

    /**
     * Creates new form OrderPanel
     */
    public OrderPanel() {
        initComponents();
        //Model class to store the item data
        foodCategoryType = new ArrayList<>();
        foodCategoryList = new ArrayList<>();
        foodProductList = new ArrayList<>();
        foodOrderedList = new ArrayList<>();
        foodCategoryType.add(new ItemModel(0,"Veg Type"));
        foodCategoryType.add(new ItemModel(1,"Timing"));
        foodCategoryType.add(new ItemModel(2,"Type"));
        foodCategoryType.add(new ItemModel(3,"Category"));
        foodCategoryType.add(new ItemModel(4,"Meat"));

        setCategoryList();
        setProductList();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        sp_detail_list = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        sp_category = new javax.swing.JScrollPane();
        sp_product_list = new javax.swing.JScrollPane();

        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 0));
        jPanel4.setLayout(new java.awt.BorderLayout());

        sp_detail_list.setBackground(new java.awt.Color(255, 0, 255));
        sp_detail_list.setBorder(null);
        sp_detail_list.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel4.add(sp_detail_list, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 0));

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 100));

        jButton1.setText("Tables");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        sp_category.setBackground(new java.awt.Color(255, 102, 102));
        sp_category.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        sp_product_list.setBackground(new java.awt.Color(0, 255, 51));
        sp_product_list.setBorder(null);
        sp_product_list.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp_product_list.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_product_list)
            .addComponent(sp_category, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp_category, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp_product_list, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        categoryItem = new CategoryItem(5);
        if (categoryItem != null) {
            categoryItem.setVisible(true);
        }

        categoryItem.setListener(new CategoryListener() {
            @Override
            public void clickedCategory(int index, ItemModel model) {
                getAllProductsForTable(model.getId());
               

            }

            @Override
            public void clickedProducts(int index, OrderItemModel model) {

            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane sp_category;
    private javax.swing.JScrollPane sp_detail_list;
    private javax.swing.JScrollPane sp_product_list;
    // End of variables declaration//GEN-END:variables

    private void setCategoryList() {
        JPanel content = new JPanel();
        content.setBackground(Color.WHITE);

        ProductButton buttonData[] = new ProductButton[foodCategoryType.size()];

        for (int index = 0; index < foodCategoryType.size(); index++) {
            buttonData[index] = new ProductButton(foodCategoryType.get(index), index, CategoryListener.CATEGORY);
            buttonData[index].addProductListener(new CategoryListener() {
                @Override
                public void clickedCategory(int index, ItemModel model) {
                    System.out.println("OrderPanel: " + index);
                    if (categoryItem != null) {
                        categoryItem.setVisible(false);
                    }
                    categoryItem = new CategoryItem(index);
                    if (categoryItem != null) {
                        categoryItem.setVisible(true);
                    }

                    categoryItem.setListener(new CategoryListener() {
                        @Override
                        public void clickedCategory(int index, ItemModel model) {
                            System.err.println("OrderPanel: " + model.getName());
                            foodCategoryType.get(index).setImage(model.getImage());
                            foodCategoryType.get(index).setName(model.getName());
                            //Setting the category with selected value
                            setCategoryList();
                            //Get all the product from database using the foodCategoryType
                            getAllProducts(index,model.getId());
                        }

                        @Override
                        public void clickedProducts(int index, OrderItemModel model) {

                        }
                    });
                }

                @Override
                public void clickedProducts(int index, OrderItemModel model) {
                }
            });

            content.add(buttonData[index]);
        }
        sp_category.getViewport().setView(content);
    }

    private void setProductList() {
        JPanel contentOrderItem = new JPanel();
        GridLayout gridLayout = new GridLayout(0, 4);
        contentOrderItem.setLayout(new FlowLayout());
        ProductButton buttonOrderItem[] = new ProductButton[foodProductList.size()];

        for (int index = 0; index < foodProductList.size(); index++) {
            buttonOrderItem[index] = new ProductButton(foodProductList.get(index), 0);
            buttonOrderItem[index].addProductListener(new CategoryListener() {
                @Override
                public void clickedCategory(int index, ItemModel model) {

                }

                @Override
                public void clickedProducts(int index, OrderItemModel model) {
                    System.err.println("OrderPanel FoodProduct:" + model.getName());
                    foodOrderedList.add(model);
                    setOrderList();
                }
            });
            contentOrderItem.add(buttonOrderItem[index]);
        }
        sp_product_list.getViewport().setView(contentOrderItem);
    }

    private void setOrderList() {
        JPanel contentOrder = new JPanel();
        contentOrder.setLayout(new BoxLayout(contentOrder, BoxLayout.Y_AXIS));
        OrderItem orderData[] = new OrderItem[foodOrderedList.size()];
        for (int index = 0; index < foodOrderedList.size(); index++) {
            orderData[index] = new OrderItem(foodOrderedList.get(index));
            contentOrder.add(orderData[index]);
        }
        sp_detail_list.getViewport().setView(contentOrder);
    }

    private void getAllProducts(int index, int id) {
        foodProductList.clear();
        MenuService menuService = new MenuService();
        switch(index){
            case 0 :
                foodCategoryList = menuService.getMenuModelByVegType(id);
                break;
                case 1 :
                
                foodCategoryList = menuService.getMenuModelByTiming(id);
                break;
                case 2 :
               
                foodCategoryList = menuService.getMenuModelByType(id);
                break;
                case 3 :
                
                foodCategoryList = menuService.getMenuModelByCategory(id);
                break;
                
                case 4 :
                
                foodCategoryList = menuService.getMenuModelByMeat(id);
                break;
                
        }
        for (int i = 0; i < foodCategoryList.size(); i++) {
                OrderItemModel model = new OrderItemModel();
                model.setId(foodCategoryList.get(i).getId());
                model.setImage(foodCategoryList.get(i).getImage());
                model.setName(foodCategoryList.get(i).getName());
                foodProductList.add(model);
            }
        setProductList();
    }

    private void getAllProductsForTable(int tableID) {
        foodOrderedList.clear();
        OrderService orderService = new OrderService();
        foodOrderedList = orderService.getAcitveOrderByTableId(tableID);
        setOrderList();

    }

}
