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
public class FoodCategoryModel {

    public FoodCategoryModel() {
    }

    public FoodCategoryModel(int food_category_id, String food_category_name) {
        this.food_category_id = food_category_id;
        this.food_category_name = food_category_name;
    }
    private int food_category_id;

    public int getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(int food_category_id) {
        this.food_category_id = food_category_id;
    }

    public String getFood_category_name() {
        return food_category_name;
    }

    public void setFood_category_name(String food_category_name) {
        this.food_category_name = food_category_name;
    }
    private String food_category_name;

   public String toString()
    {
        return this.food_category_name;
    }
}
