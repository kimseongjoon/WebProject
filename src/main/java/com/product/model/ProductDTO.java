package com.product.model;

import lombok.Builder;

@Builder
public class ProductDTO {
    private String code;
    private long id;
    private String name;
    private long price;
    private String detail;
    private String category;
    private String manufacturer;
    private long stock;
    private String condition;
    private String filename;

    public long getId() {
        return  id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return (name == null) ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return  price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDetail() {
        return (detail == null) ? "" : detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return (category == null) ? "" : category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return (manufacturer == null) ? "" : manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getCondition() {
        return (condition == null) ? "" : condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFilename() {
        return (filename == null) ? "" : filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCode() {
        return (code == null) ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
