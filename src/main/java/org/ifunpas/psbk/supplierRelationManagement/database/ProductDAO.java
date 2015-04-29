/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.ifunpas.psbk.supplierRelationManagement.model.Product;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "productDAO")
@ApplicationScoped
public class ProductDAO {

    public List<Product> getProduct() {
        List<Product> products = null;
        Connection connection = DBConnection.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Product\"");
            products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getString("pd_id"));
                product.setProductName(resultSet.getString("pd_name"));
                product.setProductPrice(resultSet.getInt("pd_price"));
                product.setSupplierId(resultSet.getString("sp_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBConnection.close(connection);
        }
        return products;
    }

    public List<Product> getProductTable(String suppierId) {
        List<Product> products = null;
        Connection connection = DBConnection.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Product\" WHERE \"sp_id\" =\'" + suppierId + "\'");
            products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getString("pd_id"));
                product.setProductName(resultSet.getString("pd_name"));
                product.setProductPrice(resultSet.getInt("pd_price"));
                product.setSupplierId(resultSet.getString("sp_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBConnection.close(connection);
        }
        return products;
    }

    public void insertProduct(String productId, String productName, int productPrice, String supplierId) {
        Connection connection = DBConnection.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Product\" VALUES (?,?,?,?)");
            statement.setString(1, productId);
            statement.setString(2, productName);
            statement.setInt(3, productPrice);
            statement.setString(4, supplierId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBConnection.close(connection);
        }
    }

    public void deleteProduct(String productId) {
        Connection connection = DBConnection.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Product\" WHERE \"pd_id\" = ?");
            statement.setString(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBConnection.close(connection);
        }
    }

    public void updateProduct(String productId, String productName, int productPrice, String supplierId) {
        Connection connection = DBConnection.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"Product\" SET \"pd_name\" = ?, \"pd_price\" = ?, \"sp_id\" = ? WHERE \"pd_id\" = ?");
            statement.setString(1, productName);
            statement.setInt(2, productPrice);
            statement.setString(3, supplierId);
            statement.setString(4, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBConnection.close(connection);
        }
    }
}
