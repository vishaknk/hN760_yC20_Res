/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Interface.ProductListener;
import UI.OrderPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(8,140,234));
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 5, 5, 5);
        Border compound = new CompoundBorder(null, margin);
        this.setPreferredSize(new Dimension(90, 90));
        this.setBorder(compound);
        //this.setIcon(new ImageIcon("/Users/Visak/Documents/Personal/Freelance/Resturant/src/Images/home.png"));
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(BOTTOM);
        this.setFocusPainted(false);
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
