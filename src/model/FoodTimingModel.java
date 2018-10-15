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
public class FoodTimingModel {
    private int id;
    private String name;

    public FoodTimingModel() {
    }

    public FoodTimingModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getFood_type_id() {
        return id;
    }

    public void setFood_type_id(int id) {
        this.id = id;
    }

    public String getFood_type_name() {
        return name;
    }

    public void setFood_type_name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
   
}
