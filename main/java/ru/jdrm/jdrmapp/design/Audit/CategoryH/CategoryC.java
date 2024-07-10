package ru.jdrm.jdrmapp.design.Audit.CategoryH;

import java.util.ArrayList;

public class CategoryC {
    public void setTitle(String title) {
        Title = title;
    }

    public CategoryC(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    private String Title;
    public CategoryC(){}

    public static ArrayList<CategoryC> getNameAudit(int col){
        ArrayList<CategoryC> sectionArrayList = new ArrayList<>();

        for(int i =0 ; i < col; i++){
            CategoryC dataSection = new CategoryC(){};
            dataSection.setTitle(String.format("M%s", i));
            sectionArrayList.add(dataSection);
        }
        return sectionArrayList;
    }
}
