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
                orderItem.setId(rs.getInt("order_id"));
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
        String sql = "select o.menu_id,o.order_id,o.table_id,o.price as amount,o.quantity, o.tax_price,o.discount, o.total_price, o.status, m.item_name as name, m.price as price from tbl_order o  left join tbl_menu  m on o.menu_id = m.menu_id where o.table_id = '" + id + "' AND o.status ='1'";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setId(rs.getInt("order_id"));
                orderItem.setMenu_id(rs.getInt("menu_id"));
                orderItem.setTable_id(rs.getInt("table_id"));
                orderItem.setName(rs.getString("name"));
                orderItem.setPrice(rs.getString("price"));
                orderItem.setQuantity(rs.getString("quantity"));

                orderList.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
