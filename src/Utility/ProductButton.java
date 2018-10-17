/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import model.ItemModel;
import model.OrderItemModel;
import Interface.CategoryListener;
import Interface.CustomerListner;

/**
 *
 * @author Visak
 */
public class ProductButton extends JButton implements ActionListener{

    private CategoryListener productListener;
    private CustomerListner customerListner;
    private ItemModel itemModel;
    private OrderItemModel orderItemModel;
    private int index, type = 0;
    
    public ProductButton() {
    }
    
    public ProductButton(ItemModel model, int index, int type) {
        this.index = index;
        this.itemModel = model;
        this.type = type;
        setDesign();
    }
    
    public ProductButton(OrderItemModel model, int index) {
        this.orderItemModel = model;
        this.index = index;
        setDesign();
    }
    
    public ProductButton(OrderItemModel model, int index, int type) {
        this.orderItemModel = model;
        this.index = index;
        this.type = type;
        setDesign();
    }
    
    
    public ProductButton(Icon icon, String text){
        this.setText(text);
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/home.png")));
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }
    
    public void setDesign() {
        if(type == CategoryListener.CATEGORY) {
            this.setText(itemModel.getName());
            ImageIcon img = new ImageIcon(itemModel.getImage());
            Image image = img.getImage();
            Image newimg = image.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
   
            this.setIcon(new ImageIcon(newimg));
        }else if(type == CustomerListner.CUSTOMER){ 
            this.setText(orderItemModel.getCustomer_name());
            ImageIcon img = new ImageIcon(orderItemModel.getImage());
            Image image = img.getImage();
            Image newimg = image.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
        }else {
            this.setText(orderItemModel.getName());
            ImageIcon img = new ImageIcon(orderItemModel.getImage());
            Image image = img.getImage();
            Image newimg = image.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
   
            this.setIcon(new ImageIcon(newimg));
        }
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(8,140,234));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 5, 5, 5);
        Border compound = new CompoundBorder(null, margin);
        this.setPreferredSize(new Dimension(90, 90));
        this.setBorder(compound);
        //this.setIcon(resizeIcon(new ImageIcon(model.getImage() + "/Users/Visak/Downloads/PM9A5899.JPG"), this.getWidth() - this.getInsets().left, this.getHeight() - this.getInsets().left));
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(BOTTOM);
        this.setFocusPainted(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(type == CategoryListener.CATEGORY) {
            System.out.println("ProductButton: " + e.getActionCommand());
            productListener.clickedCategory(index, itemModel);
        }else if(type == CustomerListner.CUSTOMER){
            customerListner.onClick(orderItemModel);
        } else {
            System.out.println("ProductButton: " + e.getActionCommand());
            productListener.clickedProducts(index, orderItemModel);
        }
    }

    public void addProductListener(CategoryListener listener) {
        this.productListener = listener;
    }
    
    public void addCustomerListner(CustomerListner listener) {
        this.customerListner = listener;
    }
    
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
  
}
