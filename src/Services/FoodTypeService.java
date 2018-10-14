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
import model.FoodTypeModel;

/**
 *
 * @author Group name
 */
public class FoodTypeService {

    public int saveOrUpdateFoodType(FoodTypeModel foodTypeModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_food_type (food_type_name) "
                    + "values('" + foodTypeModel.getFood_type_name() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_food_type set food_type_name = '" + foodTypeModel.getFood_type_name()
                    + "' where food_type_id = '" + foodTypeModel.getFood_type_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<FoodTypeModel> getFoodItems() {
        List<FoodTypeModel> foodItemList = new ArrayList<>();
        String sql = "select food_type_id,food_type_name  from tbl_food_type";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                FoodTypeModel foodItem = new FoodTypeModel();
                foodItem.setFood_type_name(rs.getString("food_type_name"));
                foodItem.setFood_type_id(rs.getInt("food_type_id"));

                foodItemList.add(foodItem);
            }
        } catch (Exception e) {
        }
        return foodItemList;
    }
    

    public int deleteFoodItem(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_food_type where food_type_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public FoodTypeModel getFoodDetailsById(int id) {
        FoodTypeModel foodItem = new FoodTypeModel();
        foodItem.setFood_type_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select food_type_id,food_type_name from tbl_food_type where food_type_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                foodItem.setFood_type_id(rs.getInt("food_type_id"));
                foodItem.setFood_type_name(rs.getString("food_type_name"));
            }
        } catch (Exception e) {
        }
        return foodItem;
    }
}
