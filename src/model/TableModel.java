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
public class TableModel {
    private int table_id, no_of_seat,status;

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getNo_of_seat() {
        return no_of_seat;
    }

    public void setNo_of_seat(int no_of_seat) {
        this.no_of_seat = no_of_seat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
    private String table_name;

   
}
