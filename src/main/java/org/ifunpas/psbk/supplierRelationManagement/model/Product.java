/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.ifunpas.psbk.supplierRelationManagement.database.ProductDAO;
import org.primefaces.component.fileupload.FileUpload;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "product")
@ApplicationScoped
public class Product {
    
    private String productId;
    private String productName;
    private int productPrice;
    private String supplierId;
    private FileUpload image;
    
    public Product() {
    }
    
    public Product(String productId, String productName, int productPrice, String SupplierId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.supplierId = SupplierId;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    public String getSupplierId() {
        return supplierId;
    }
    
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public FileUpload getImage() {
        return image;
    }

    public void setImage(FileUpload image) {
        this.image = image;
    }
}
