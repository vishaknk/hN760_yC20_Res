package Interface;

import model.ItemModel;
import model.OrderItemModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Visak
 */
public interface CategoryListener {
    
    public static final int CATEGORY = 1;
    public static final int PRODUCT = 2;
    
    public void clickedCategory(int index, ItemModel model);
    public void clickedProducts(int index, OrderItemModel model);
}
