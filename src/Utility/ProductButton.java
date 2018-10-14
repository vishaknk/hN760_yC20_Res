/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Interface.ProductListener;
import UI.OrderPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Visak
 */
public class ProductButton extends JButton implements ActionListener{

    private ProductListener productListener;
    private int index;
    
    public ProductButton() {
    }

    public ProductButton(Icon icon) {
        super(icon);
    }

    public ProductButton(String text, int idex) {
        super(text);
        this.index = idex;
        this.setIcon(new ImageIcon("/Users/Visak/Documents/Personal/Freelance/Resturant/src/Images/home.png"));
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(BOTTOM);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.addActionListener(this);
    }
    
    public ProductButton(Icon icon, String text){
        this.setText(text);
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/home.png")));
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        productListener.clickedProducts(index);
        System.out.println(e.getActionCommand());
    }

    public void addProductListener(ProductListener listener) {
        this.productListener = listener;
    }
  
}
