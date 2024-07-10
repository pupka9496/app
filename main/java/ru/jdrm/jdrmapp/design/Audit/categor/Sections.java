package ru.jdrm.jdrmapp.design.Audit.categor;

import java.util.Map;


public class Sections {
    private Map<String, Map<String, Category>>  category;
    public Sections(){}

    public Sections(Map<String, Map<String, Category>> category) {
        this.category = category;
    }

    public Map<String, Map<String, Category>> getCategory() {
        return category;
    }

    public void setCategory(Map<String, Map<String, Category>> category) {
        this.category = category;
    }

    // manage список из м
}