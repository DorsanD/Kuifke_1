/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kuifke_1.domain;

import java.io.Serializable;
/**
 *
 * @author Dorsan
 */
public class BIBean implements Serializable{
    private int id;
    private String table;
    private String column;
    private String type;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        if (this.data == null) {
            this.data = "EMPTY";
        }
        return data;
    }

    public void setData(String data) {

        this.data = data;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTabelCol() {
        String prefix = null;
        if (getTable().equalsIgnoreCase("customer")) {
            prefix = "c";
        } else if (getTable().equalsIgnoreCase("track")) {
            prefix = "t";
        } else if (getTable().equalsIgnoreCase("artiest")) {
            prefix = "a";
        }
        return prefix + "." + getColumn();
    }

    public String getConverType() {
        String type = getType();
        if (type.equalsIgnoreCase("varchar")) {
            return "String";
        } else if (type.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (type.equalsIgnoreCase("longtext")) {
            return "String";
        } else if (type.equalsIgnoreCase("tinyint")) {
            return "Boolean";
        } else if (type.equalsIgnoreCase("int")) {
            return "int";
        }
        return null;
    }

    @Override
    public String toString() {
        return "BiBean{" + "id=" + id + ", table=" + table + ", column=" + column + ", type=" + type + ", data=" + data + '}';
    }
}
