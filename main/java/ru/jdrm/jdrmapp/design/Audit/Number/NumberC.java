package ru.jdrm.jdrmapp.design.Audit.Number;

import java.util.ArrayList;

public class NumberC {
    private String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
    public NumberC(){}
    public static ArrayList<NumberC> getNameAudit(int col){
        ArrayList<NumberC> sectionArrayList = new ArrayList<>();

        for(int i =0 ; i < col; i++){
            NumberC dataSection = new NumberC(){};
            dataSection.setTitle(String.valueOf(i));
            sectionArrayList.add(dataSection);
        }
        return sectionArrayList;
    }
}
