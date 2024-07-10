package ru.jdrm.jdrmapp.design.Audit.Section;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.design.Audit.EAudit;

public class SectionC {
    private String Title;
    public SectionC(){}

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public static ArrayList<SectionC> getNameAudit(){
        ArrayList<SectionC> sectionArrayList = new ArrayList<>();

        for(String i : EAudit.getListNameColumn()){
            SectionC dataSection = new SectionC(){};
            dataSection.setTitle(i);
            sectionArrayList.add(dataSection);
        }
        return sectionArrayList;
    }
}
