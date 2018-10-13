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
import model.FoodCategoryModel;

/**
 *
 * @author Group name
 */
public class FoodCategoryService {

    public int saveOrUpdateFoodType(FoodCategoryModel foodCategoryModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_food_category (food_category_name) "
                    + "values('" + foodCategoryModel.getFood_category_name() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_food_category set food_category_name = '" + foodCategoryModel.getFood_category_name()
                    + "' where food_category_id = '" + foodCategoryModel.getFood_category_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<FoodCategoryModel> getFoodItems() {
        List<FoodCategoryModel> foodItemList = new ArrayList<>();
        String sql = "select food_category_id,food_category_name  from tbl_food_category";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                FoodCategoryModel foodItem = new FoodCategoryModel();
                foodItem.setFood_category_name(rs.getString("food_category_name"));
                foodItem.setFood_category_id(rs.getInt("food_category_id"));

                foodItemList.add(foodItem);
            }
        } catch (Exception e) {
        }
        return foodItemList;
    }
    

    public int deleteFoodItem(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_food_category where food_category_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public FoodCategoryModel getFoodDetailsById(int id) {
        FoodCategoryModel foodItem = new FoodCategoryModel();
        foodItem.setFood_category_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select food_category_id,food_category_name from tbl_food_category where food_category_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                foodItem.setFood_category_id(rs.getInt("food_category_id"));
                foodItem.setFood_category_name(rs.getString("food_category_name"));
            }
        } catch (Exception e) {
        }
        return foodItem;
    }
}
