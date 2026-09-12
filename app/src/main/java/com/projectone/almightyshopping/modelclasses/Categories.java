package com.projectone.almightyshopping.modelclasses;

public class Categories {
    public String categoryId;
    public String categoryName;
    public String categoryImg;

    public Categories(String categoryId, String categoryName, String categoryImg) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }
}
