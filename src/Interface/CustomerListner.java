/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import model.OrderItemModel;

/**
 *
 * @author Visak
 */

public interface CustomerListner {
     public static final int CUSTOMER = 3333;
    public void onClick(OrderItemModel orderItem);
}
