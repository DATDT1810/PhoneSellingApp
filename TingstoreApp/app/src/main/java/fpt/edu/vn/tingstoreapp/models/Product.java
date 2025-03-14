package fpt.edu.vn.tingstoreapp.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product  implements Serializable {
    private String id;
    private String name;
    private String productImage;
    private String description;
    private double price;
    private Integer stock;
    private Date createAt;
    private Date updateAt;
    private String categoryId;
    private Boolean isActive;
    private List<Image> images;

    public Product (){}

    public Product(String id, String name, String productImage, String description, double price, Integer stock, Date createAt, Date updateAt, String categoryId, Boolean isActive, List<Image> images) {
        this.id = id;
        this.name = name;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.categoryId = categoryId;
        this.isActive = isActive;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
