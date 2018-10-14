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
import model.TableModel;
import model.TableModel;

/**
 *
 * @author Group name
 */
public class TableService {

    public int saveOrUpdateTabledetails(TableModel tableModel, boolean isAdd) {
        int status = 0;
        SQLRun sqlObj = new SQLRun();
        String sql = "";
        if (isAdd) {
            sql = "Insert into tbl_table (table_name, no_of_seat, status) "
                    + "values('" + tableModel.getTable_name()+ "','" + tableModel.getNo_of_seat()+ "','"
                    + tableModel.getStatus() + "')";
            status = sqlObj.sqlUpdate(sql);

        } else {
            sql = "update tbl_table set "
                    + "table_name = '" + tableModel.getTable_name() + "', "
                    + "no_of_seat = '" + tableModel.getNo_of_seat() + "', "
                    + "status = '" + tableModel.getStatus() 
                    + "' where table_id = '" + tableModel.getTable_id()+ "'";

            status = sqlObj.sqlUpdate(sql);

        }

        return status;
    }

    public List<TableModel> getAllTables() {
        List<TableModel> tableList = new ArrayList<>();
        String sql = "select table_id,table_name, no_of_seat, status  from tbl_table";
        SQLRun sqlObj = new SQLRun();

        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                TableModel table = new TableModel();
                table.setTable_name(rs.getString("table_name"));
                table.setTable_id(rs.getInt("table_id"));
                table.setStatus(rs.getInt("status"));
                table.setNo_of_seat(rs.getInt("no_of_seat"));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableList;
    }

    public int deleteTable(int id) {
        SQLRun sqlObj = new SQLRun();
        String sql = "delete from tbl_table where table_id = '" + id + "'";
        return sqlObj.sqlUpdate(sql);
    }

    public TableModel gettableModelById(int id) {
        TableModel table = new TableModel();
        table.setTable_id(id);

        SQLRun sqlObj = new SQLRun();
        String sql = "select table_id,table_name,status, no_of_seat from tbl_table where table_id = '" + id + "'";
        ResultSet rs = sqlObj.sqlQuery(sql);
        try {
            while (rs.next()) {
                table.setTable_id(rs.getInt("table_id"));
                table.setTable_name(rs.getString("table_name"));
                table.setStatus(rs.getInt("status"));
                table.setNo_of_seat(rs.getInt("no_of_seat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
}
