/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DBConnection.SQLRun;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.FoodMeatModel;
import model.FoodMeatModel;

/**
 *
 * @author Group name
 */
public class FoodMeatService {

    public int saveOrUpdateFoodMeatType(FoodMeatModel foodMeatModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_meat_type (food_meat_name) "
                    + "values('" + foodMeatModel.getFood_meat_name() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_meat_type set food_meat_name = '" + foodMeatModel.getFood_meat_name()
                    + "' where food_meat_id = '" + foodMeatModel.getFood_meat_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<FoodMeatModel> getFoodItems() {
        List<FoodMeatModel> foodItemList = new ArrayList<>();
        String sql = "select food_meat_id,food_meat_name  from tbl_meat_type";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                FoodMeatModel foodItem = new FoodMeatModel();
                foodItem.setFood_meat_name(rs.getString("food_meat_name"));
                foodItem.setFood_meat_id(rs.getInt("food_meat_id"));

                foodItemList.add(foodItem);
            }
        } catch (Exception e) {
        }
        return foodItemList;
    }
    

    public int deleteFoodItem(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_meat_type where food_meat_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public FoodMeatModel getFoodDetailsById(int id) {
        FoodMeatModel foodItem = new FoodMeatModel();
        foodItem.setFood_meat_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select food_meat_id,food_meat_name from tbl_meat_type where food_meat_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                foodItem.setFood_meat_id(rs.getInt("food_meat_id"));
                foodItem.setFood_meat_name(rs.getString("food_meat_name"));
            }
        } catch (Exception e) {
        }
        return foodItem;
    }
}
