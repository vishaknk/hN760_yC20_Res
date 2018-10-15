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
import model.FoodMeatModel;
import model.FoodTimingModel;
import model.FoodTypeModel;
import model.FoodVegType;
import model.MenuListModel;
import model.MenuModel;

/**
 *
 * @author Group name
 */
public class MenuService {

    public int saveOrUpdateMenu(MenuModel menuModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_menu (item_name, food_type_id, food_veg_id, food_time_id,food_meat_id,food_category_id,price) "
                    + "values('"
                    + menuModel.getItem_name()
                    + "','" + menuModel.getFood_type_id()
                    + "','" + menuModel.getFood_veg_id()
                    + "','" + menuModel.getFood_time_id()
                    + "','" + menuModel.getFood_meat_id()
                    + "','" + menuModel.getFood_category_id()
                    + "','"
                    + menuModel.getPrice() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_menu set "
                    + "item_name = '" + menuModel.getItem_name() + "', "
                    + "food_type_id = '" + menuModel.getFood_type_id() + "', "
                    + "food_veg_id = '" + menuModel.getFood_veg_id() + "', "
                    + "food_time_id = '" + menuModel.getFood_time_id() + "', "
                    + "food_meat_id = '" + menuModel.getFood_meat_id() + "', "
                    + "food_category_id = '" + menuModel.getFood_category_id() + "', "
                    + "price = '" + menuModel.getPrice()
                    + "' where menu_id = '" + menuModel.getMenu_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<MenuListModel> getAllMenuItems() {
        List<MenuListModel> menuList = new ArrayList<>();
        String sql = "select menu.item_name,menu.menu_id,menu.food_type_id, menu.food_category_id,menu.food_veg_id,menu.food_meat_id, menu.food_time_id, menu.status, menu.price, menu.food_veg_id, menu.food_time_id, tbl_food_category.food_category_name as food_category\n"
                + ", tbl_food_type.food_type_name as food_type\n"
                + ", tbl_meat_type.food_meat_name as food_meat from tbl_menu menu \n"
                + " left join tbl_food_category on menu.food_category_id = tbl_food_category.food_category_id\n"
                + "  left join tbl_food_type on menu.food_type_id = tbl_food_type.food_type_id\n"
                + "   left join tbl_meat_type on menu.food_meat_id = tbl_meat_type.food_meat_id;";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                MenuListModel menu = new MenuListModel();
                menu.setItem_name(rs.getString("item_name"));
                menu.setMenu_id(rs.getInt("menu_id"));
                menu.setTypeModel(new FoodTypeModel(rs.getInt("food_type_id"),rs.getString("food_type")));
                if(rs.getInt("food_veg_id") == 1){
                    menu.setFoodVegType(new FoodVegType(1,"Vegetarian"));
                }else{
                    menu.setFoodVegType(new FoodVegType(2,"Non-Vegetarian"));
                }
                menu.setCategoryModel(new FoodCategoryModel(rs.getInt("food_category_id"),rs.getString("food_category")));
                 menu.setFoodMeatModel(new FoodMeatModel(rs.getInt("food_meat_id"),rs.getString("food_meat")));
                if(rs.getInt("food_time_id") == 1){
                    menu.setTimeModel(new FoodTimingModel(1,"All Time"));
                }else if(rs.getInt("food_time_id") == 2){
                    menu.setTimeModel(new FoodTimingModel(2,"Breakfast"));
                }else if(rs.getInt("food_time_id") == 3){
                    menu.setTimeModel(new FoodTimingModel(3,"Lunch"));
                }else if(rs.getInt("food_time_id") == 4){
                    menu.setTimeModel(new FoodTimingModel(4,"Dinner"));
                }else{
                    menu.setTimeModel(new FoodTimingModel(1,"All Time"));
                }
                menu.setStatus(rs.getInt("status"));
                menu.setPrice(rs.getInt("price"));
                menuList.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    public int deleteMenuItem(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_menu where menu_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public MenuModel getMenuModelById(int id) {
        MenuModel menu = new MenuModel();
        menu.setMenu_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select menu_id,item_name,food_type_id, food_veg_id, food_type_id"
                + ",food_category_id,food_meat_id,food_time_id,status,price from tbl_menu where menu_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                menu.setItem_name(rs.getString("item_name"));
                menu.setMenu_id(rs.getInt("menu_id"));
                menu.setFood_type_id(rs.getInt("food_type_id"));
                menu.setFood_veg_id(rs.getInt("food_veg_id"));
                menu.setFood_category_id(rs.getInt("food_category_id"));
                menu.setFood_meat_id(rs.getInt("food_meat_id"));
                menu.setFood_time_id(rs.getInt("food_time_id"));
                menu.setStatus(rs.getInt("status"));
                menu.setPrice(rs.getInt("price"));
            }
        } catch (Exception e) {
        }
        return menu;
    }
}
