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
import model.ShopDetailsModel;

/**
 *
 * @author Group name
 */
public class ShopdetailsService {

    public int saveOrUpdatehopdetails(ShopDetailsModel shopDetails, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_shop (shop_name, phone_no, email_address, address,place) "
                    + "values('" + shopDetails.getShop_name() + "','" + shopDetails.getPhone_no() + "','" + shopDetails.getEmail_address() + "','"
                    + shopDetails.getAddress() + "','" + shopDetails.getPlace() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_shop set "
                    + "shop_name = '" + shopDetails.getShop_name() + "', "
                    + "phone_no = '" + shopDetails.getPhone_no() + "', "
                    + "email_address = '" + shopDetails.getEmail_address() + "', "
                    + "address = '" + shopDetails.getAddress() + "', "
                    + "place = '" + shopDetails.getPlace()
                    + "' where shop_id = '" + shopDetails.getShop_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<ShopDetailsModel> getAllShops() {
        List<ShopDetailsModel> shopList = new ArrayList<>();
        String sql = "select shop_id,shop_name, phone_no, email_address, address,place  from tbl_shop";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                ShopDetailsModel shop = new ShopDetailsModel();
                shop.setShop_name(rs.getString("shop_name"));
                shop.setShop_id(rs.getInt("shop_id"));
                shop.setPhone_no(rs.getString("phone_no"));
                shop.setPlace(rs.getString("place"));
                shop.setAddress(rs.getString("address"));
                shop.setEmail_address(rs.getString("email_address"));
                shopList.add(shop);
            }
        } catch (Exception e) {
        }
        return shopList;
    }

    public int deleteFoodItem(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_shop where shop_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public ShopDetailsModel getshopDetailsById(int id) {
        ShopDetailsModel shop = new ShopDetailsModel();
        shop.setShop_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select shop_id,shop_name,phone_no, email_address, address,place from tbl_shop where shop_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                shop.setShop_id(rs.getInt("shop_id"));
                shop.setShop_name(rs.getString("shop_name"));
                shop.setEmail_address(rs.getString("email_address"));
                shop.setPhone_no(rs.getString("phone_no"));
                shop.setAddress(rs.getString("address"));
                shop.setPlace(rs.getString("place"));
            }
        } catch (Exception e) {
        }
        return shop;
    }
}
