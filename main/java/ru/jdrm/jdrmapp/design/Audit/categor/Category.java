package ru.jdrm.jdrmapp.design.Audit.categor;

import java.util.Map;


public class Category{
    public Category(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, SubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Map<String, SubCategory> subCategory) {
        this.subCategory = subCategory;
    }


    private String name;
    private Map<String, SubCategory>  subCategory;
}
