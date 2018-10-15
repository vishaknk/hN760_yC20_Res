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
public class FoodMeatModel {
    private int food_meat_id;
    private String food_meat_name;

    public int getFood_meat_id() {
        return food_meat_id;
    }

    public void setFood_meat_id(int food_meat_id) {
        this.food_meat_id = food_meat_id;
    }

    public String getFood_meat_name() {
        return food_meat_name;
    }

    public void setFood_meat_name(String food_meat_name) {
        this.food_meat_name = food_meat_name;
    }

    public FoodMeatModel() {
    }

    public FoodMeatModel(int food_meat_id, String food_meat_name) {
        this.food_meat_id = food_meat_id;
        this.food_meat_name = food_meat_name;
    }
     public String toString()
    {
        return this.food_meat_name;
    }
}
