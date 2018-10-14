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
import model.StaffDetailsModel;

/**
 *
 * @author Group name
 */
public class StaffDetailsService {

    public int saveOrUpdateStaffDetails(StaffDetailsModel staffDetailsModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            staffDetailsModel.setStatus(1);
            staffDetailsModel.setRole("S");
            sql = "Insert into tbl_register (name, mobile, email, password, role, status,dt) values('"
                    + staffDetailsModel.getName() + "', '"
                    + staffDetailsModel.getMobile() + "', '"
                    + staffDetailsModel.getEmail() + "','"
                    + staffDetailsModel.getPassword() + "', '"
                     + staffDetailsModel.getRole()+ "', '"
                    + staffDetailsModel.getStatus()  + "','2018-07-23 03:08:08"
                    + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_register set "
                    + "name = '" + staffDetailsModel.getName() + "', "
                    + "mobile = '" + staffDetailsModel.getMobile() + "', "
                    + "email = '" + staffDetailsModel.getEmail() + "', "
                    + "password = '" + staffDetailsModel.getPassword() + "', "
                    + "status = '" + staffDetailsModel.getStatus() + "', "
                    + "role = '" + staffDetailsModel.getRole()
                    + "' where user_id = '" + staffDetailsModel.getUser_id() + "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<StaffDetailsModel> getStaffs() {
        List<StaffDetailsModel> staffList = new ArrayList<>();
        String sql = "select user_id,name, mobile, email, role, status,password  from tbl_register where role !='A'";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                StaffDetailsModel staff = new StaffDetailsModel();
                staff.setName(rs.getString("name"));
                staff.setUser_id(rs.getInt("user_id"));
                staff.setMobile(rs.getString("mobile"));
                staff.setEmail(rs.getString("email"));
                staff.setPassword(rs.getString("password"));
                staff.setStatus(rs.getInt("status"));
                staff.setRole(rs.getString("role"));

                staffList.add(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public int deleteStaff(int id) {
        SQLRun sqlObj = new SQLRun();
          String sql = "update tbl_register set "
                    + "status = '0'"
                    + " where user_id = '" + id + "' && " + "role != 'A'";
        return sqlObj.sqlUpdate(sql);
    }

    public StaffDetailsModel getFoodDetailsById(int id) {
        StaffDetailsModel foodItem = new StaffDetailsModel();
        foodItem.setUser_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select user_id,name, mobile, email, password, role, status from tbl_register where user_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                foodItem.setUser_id(rs.getInt("user_id"));
                foodItem.setName(rs.getString("name"));
                foodItem.setMobile(rs.getString("mobile"));
                foodItem.setEmail(rs.getString("email"));
                foodItem.setRole(rs.getString("role"));
                foodItem.setStatus(rs.getInt("status"));
                foodItem.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return foodItem;
    }
}
