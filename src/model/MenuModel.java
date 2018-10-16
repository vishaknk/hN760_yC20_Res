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
public class MenuModel {
    private int menu_id, food_category_id, food_type_id, food_meat_id, food_veg_id, food_time_id, status,discount, discount_type, price;
    private String item_name,tax_head_id, image_path;

    public String getImagePath() {
        return image_path;
    }

    public void setImagePath(String imagePath) {
        this.image_path = imagePath;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(int food_category_id) {
        this.food_category_id = food_category_id;
    }

    public int getFood_type_id() {
        return food_type_id;
    }

    public void setFood_type_id(int food_type_id) {
        this.food_type_id = food_type_id;
    }

    public int getFood_meat_id() {
        return food_meat_id;
    }

    public void setFood_meat_id(int food_meat_id) {
        this.food_meat_id = food_meat_id;
    }

    public int getFood_veg_id() {
        return food_veg_id;
    }

    public void setFood_veg_id(int food_veg_id) {
        this.food_veg_id = food_veg_id;
    }

    public int getFood_time_id() {
        return food_time_id;
    }

    public void setFood_time_id(int food_time_id) {
        this.food_time_id = food_time_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(int discount_type) {
        this.discount_type = discount_type;
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

    public String getTax_head_id() {
        return tax_head_id;
    }

    public void setTax_head_id(String tax_head_id) {
        this.tax_head_id = tax_head_id;
    }


}
