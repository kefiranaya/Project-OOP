package com.controllers;

import java.sql.SQLException;

import com.config.MyConfig;
import com.models.Produk;

public class DbController extends MyConfig {

    public static void getDatabase() {
        connection();
        try {
            // query = "SELECT nama, harga, stok FROM tb_produk ORDER BY ID DESC";
            query = "SELECT NAME, PRICE, STOCK FROM muti_table";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        String.format("%s - Rp.%d - Stok %d", resultSet.getString("name"), resultSet.getInt("price"),
                                resultSet.getInt("stock")));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Produk getProdukByNama(String name) {
        Produk produk = null;
        connection();
        query = "SELECT * FROM muti_table WHERE NAME=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getLong("price"),
                        resultSet.getInt("stock"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }

    public static boolean insertData(String name, long price, int stock) {
        connection();
        query = "INSERT INTO muti_table (NAME, PRICE, STOCK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, price);
            preparedStatement.setInt(3, stock);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateNama(int id, String name) {
        connection();
        query = "UPDATE muti_table SET NAME=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long price) {
        connection();
        query = "UPDATE muti_table SET PRICE=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStok(int id, int stock) {
        connection();
        query = "UPDATE muti_table SET STOCK=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(String name) {
        connection();
        query = "DELETE FROM muti_table WHERE NAME=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            int affectedRowDelete = preparedStatement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
