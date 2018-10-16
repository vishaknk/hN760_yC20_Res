/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DBConnection.SQLRun;
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
    

    public int deleteFoodItem(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_food_category where food_category_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public ArrayList<OrderItemModel> getAcitveOrderByTableId(int id) {
        ArrayList<OrderItemModel> orderList = new ArrayList<>();
        String sql = "select m.menu_id,o.table_id,  o.status, m.item_name as name ,o.customer_name,o.order_id as oid, so.order_id as order_id,so.menu_id from tbl_order o \n" +
"left join tbl_order_sub so on o.order_id = so.order_id\n" +
"left join tbl_menu m on m.menu_id = so.menu_id where o.table_id = '" + id + "' AND o.status ='1'";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setOrder_id(rs.getString("order_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setTable_id(rs.getInt("table_id"));
                orderItem.setName(rs.getString("customer_name"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public int saveOrderInMainOrderTable(OrderItemModel orderItemModel, boolean isAdd) { //To change body of generated methods, choose Tools | Templates.
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        String orderId = UUID.randomUUID().toString();
        if (isAdd) {
            sql = "Insert into tbl_order (order_id,customer_name, table_id,no_of_seating ) "
                    + "values('" + orderId +"','"+ orderId+ "', '" + orderItemModel.getTable_id()
                    + "', '" + orderItemModel.getNo_of_seating()+ "')";
            status = sqlObj.sqlUpdate(sql);
            //save order details to suborder table
            if(status == 1){
                String subInsert = "";
                 sql = "Insert into tbl_order_sub (order_id, menu_id,quantity,price) "
                    + "values('" +orderId +"','"+ orderItemModel.getMenu_id()
                         + "', '" + orderItemModel.getQuantity()+ "', '" + orderItemModel.getPrice()+ "')";
            status = sqlObj.sqlUpdate(sql);
                
            }

        } else {
//            sql = "update tbl_food_type set food_type_name = '" + foodTypeModel.getFood_type_name()
//                    + "' where food_type_id = '" + foodTypeModel.getFood_type_id() + "'";

//            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }
}
