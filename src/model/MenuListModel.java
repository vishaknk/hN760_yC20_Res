/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Group name
 */
public class MenuListModel {
    private int menu_id, status, price;
    private String item_name;

    public FoodCategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(FoodCategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public FoodMeatModel getFoodMeatModel() {
        return foodMeatModel;
    }

    public void setFoodMeatModel(FoodMeatModel foodMeatModel) {
        this.foodMeatModel = foodMeatModel;
    }

    public FoodTypeModel getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(FoodTypeModel typeModel) {
        this.typeModel = typeModel;
    }

    public FoodVegType getFoodVegType() {
        return foodVegType;
    }

    public void setFoodVegType(FoodVegType foodVegType) {
        this.foodVegType = foodVegType;
    }
    private FoodTimingModel timeModel;
    private FoodCategoryModel categoryModel;
    private FoodMeatModel foodMeatModel;
    private FoodTypeModel typeModel;
    private FoodVegType foodVegType;

    public FoodTimingModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(FoodTimingModel timeModel) {
        this.timeModel = timeModel;
    }



    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

}
