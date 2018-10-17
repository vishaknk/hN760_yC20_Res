/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DBConnection.SQLRun;
import Utility.Utility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.FoodCategoryModel;
import model.OrderItemModel;

/**
 *
 * @author Group name
 */
public class OrderService {

    public int saveOrUpdateFoodType(FoodCategoryModel foodCategoryModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_order (food_category_name) "
                    + "values('" + foodCategoryModel.getFood_category_name() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_food_category set food_category_name = '" + foodCategoryModel.getFood_category_name()
                    + "' where food_category_id = '" + foodCategoryModel.getFood_category_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<OrderItemModel> getActiveOrders() {
        List<OrderItemModel> orderList = new ArrayList<>();
        String sql = "select order_id,menu_id, table_id from tbl_order where status = 1";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setOrder_id(rs.getString("order_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setTable_id(rs.getInt("table_id"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
        }
        return orderList;
    }
    
    public List<OrderItemModel> getKitchenData() {
        List<OrderItemModel> orderList = new ArrayList<>();
        String sql = "select o.order_sub_id, o.order_id, o.menu_id, m.item_name, o.quantity from tbl_order_sub o left join tbl_menu m on o.menu_id = m.menu_id where o.status = 1";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setOrder_id(rs.getString("order_id"));
                orderItem.setId(rs.getInt("order_sub_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setName(rs.getString("item_name"));
                orderItem.setQuantity(rs.getString("quantity"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public int deleteOrder(String id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_order_sub where order_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public int printBill(String id) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "update tbl_order_sub set status = '2' where order_id = '" + id + "'";

        status = sqlObj.sqlUpdate(sql);
        sql = "update tbl_order set status = '2' where order_id = '" + id + "'";
        status = sqlObj.sqlUpdate(sql);
        return sqlObj.sqlUpdate(sql);
    }
    
     public int prepared(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "update tbl_order_sub set status = '4' where order_sub_id = '" + id + "'";
       
        return sqlObj.sqlUpdate(sql);
    }

    public ArrayList<OrderItemModel> getAcitveOrderByTableId(int id) {
        ArrayList<OrderItemModel> orderList = new ArrayList<>();
        String sql = "select m.menu_id,o.table_id,  o.status, m.item_name as name, m.image_path as image ,o.customer_name,o.order_id as oid, so.order_id as order_id,so.menu_id from tbl_order o \n"
                + "left join tbl_order_sub so on o.order_id = so.order_id\n"
                + "left join tbl_menu m on m.menu_id = so.menu_id where o.table_id = '" + id + "' AND o.status ='1'";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setOrder_id(rs.getString("oid"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setTable_id(rs.getInt("table_id"));
                orderItem.setName(rs.getString("customer_name"));
                orderItem.setImage(rs.getString("image"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public ArrayList<OrderItemModel> getAcitveCustomerByTableId(int id) {
        ArrayList<OrderItemModel> orderList = new ArrayList<>();
        String sql = "select distinct o.table_id,  o.status,o.customer_name, o.order_id as oid, so.order_id as order_id from tbl_order o left join tbl_order_sub so on o.order_id = so.order_id "
                + " where o.table_id = '" + id + "' AND o.status ='1'";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setOrder_id(rs.getString("oid"));
                orderItem.setTable_id(rs.getInt("table_id"));
                orderItem.setName(rs.getString("customer_name"));
                orderItem.setCustomer_name(rs.getString("customer_name"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public int saveOrderInMainOrderTable(ArrayList<OrderItemModel> foodOrderedList, int tableId, int noSeats) { //To change body of generated methods, choose Tools | Templates.
        int finalStatus = 0;
        String orderId = UUID.randomUUID().toString();
        for (int i = 0; i < foodOrderedList.size(); i++) {
            foodOrderedList.get(i).setTable_id(tableId);
            foodOrderedList.get(i).setNo_of_seating(noSeats);
            foodOrderedList.get(i).setCustomer_name("cust" + i);
            OrderItemModel orderItemModel = foodOrderedList.get(i);

            int status = 0;
            SQLRun sqlObj = new SQLRun();
            String sql = "";
            
            int total = 0, quantity = 0, price = 0;
            try {
                total = 0;
                if (orderItemModel.getPrice() == null) {
                    price = 0;
                } else {
                    price = Integer.parseInt(orderItemModel.getPrice());
                }
                if (orderItemModel.getQuantity() == null) {
                    quantity = 0;
                } else {
                    quantity = Integer.parseInt(orderItemModel.getQuantity());
                }
                total = price * quantity;
            } catch (Exception e) {
                total = 0;
                e.printStackTrace();
            }
            if (i == 0) {
                    sql = "Insert into tbl_order (order_id,customer_name, table_id,no_of_seating, staff_id ) "
                            + "values('" + orderId + "','" + orderItemModel.getCustomer_name() + "', '" + orderItemModel.getTable_id()
                            + "', '" + Utility.USER_ID
                            + "', '" + orderItemModel.getNo_of_seating() + "')";
                    status = sqlObj.sqlUpdate(sql);
                }
                //save order details to suborder table
                    sql = "Insert into tbl_order_sub (order_id, menu_id,quantity,price, total_price) "
                            + "values('" + orderId + "','" + orderItemModel.getMenu_id()
                            + "', '" + orderItemModel.getQuantity() + "', '" + orderItemModel.getPrice()
                            + "', '" + total + "')";
                    finalStatus = sqlObj.sqlUpdate(sql);
        }

        return finalStatus;
    }
    public int updateOrderInMainOrderTable(ArrayList<OrderItemModel> foodOrderedList, int tableId, int noSeats, String orderID) { 
         int finalStatus = 0;
        for (int i = 0; i < foodOrderedList.size(); i++) {
            foodOrderedList.get(i).setTable_id(tableId);
            foodOrderedList.get(i).setNo_of_seating(noSeats);
            foodOrderedList.get(i).setCustomer_name("cust" + i);
            foodOrderedList.get(i).setOrder_id(orderID);
            OrderItemModel orderItemModel = foodOrderedList.get(i);

            
            SQLRun sqlObj = new SQLRun();
            String sql = "";
          
            int total = 0, quantity = 0, price = 0;
            try {
                total = 0;
                if (orderItemModel.getPrice() == null) {
                    price = 0;
                } else {
                    price = Integer.parseInt(orderItemModel.getPrice());
                }
                if (orderItemModel.getQuantity() == null) {
                    quantity = 0;
                } else {
                    quantity = Integer.parseInt(orderItemModel.getQuantity());
                }
                total = price * quantity;
            } catch (Exception e) {
                total = 0;
                e.printStackTrace();
            }
             sql = "Insert into tbl_order_sub (order_id, menu_id,quantity,price,total_price) "
                        + "values('" + orderItemModel.getOrder_id() + "','" + orderItemModel.getMenu_id()
                        + "', '" + orderItemModel.getQuantity() + "', '" + orderItemModel.getPrice()
                        + "', '" + total + "')";

                finalStatus = sqlObj.sqlUpdate(sql);
        }
        return finalStatus;
        
    }

    public ArrayList<OrderItemModel> getAcitveOrderByOrderId(String orderId, int TableID) {
        ArrayList<OrderItemModel> orderList = new ArrayList<>();
        String sql = "select m.menu_id,o.table_id, m.item_name as name,m.image_path as image ,so.quantity,so.price,o.customer_name,o.order_id as oid,"
                + " so.order_id as order_id, so.menu_id from tbl_order o left join tbl_order_sub so "
                + "on o.order_id = so.order_id left join tbl_menu m on m.menu_id = so.menu_id "
                + "where o.table_id = '" + TableID + "' AND so.order_id ='" + orderId + "'";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setOrder_id(rs.getString("order_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setTable_id(rs.getInt("table_id"));
                orderItem.setName(rs.getString("name"));
                orderItem.setImage(rs.getString("image"));
                orderItem.setQuantity(rs.getString("quantity"));
                orderItem.setPrice(rs.getString("price"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
