package fpt.edu.vn.tingstoreapp.models;

import java.io.Serializable;
import java.util.Date;

public class Image implements Serializable {
    private String imageUrl;
    private Boolean isPrimary;
    private Date createAt;

    public Image(){}

    public Image(String imageUrl, Boolean isPrimary, Date createAt) {
        this.imageUrl = imageUrl;
        this.isPrimary = isPrimary;
        this.createAt = createAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
