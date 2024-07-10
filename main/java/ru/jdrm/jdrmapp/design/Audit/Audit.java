package ru.jdrm.jdrmapp.design.Audit;


import java.util.ArrayList;


public class Audit {


    public static ArrayList<Audit> AuditList = new ArrayList<>();

    public static ArrayList<Audit> AuditForSection(String eAudit){
        ArrayList<Audit> audits = new ArrayList<>();
        for(Audit audit: AuditList){
            if(audit.SectionAudit.equals(eAudit)){
                audits.add(audit);
            }
        }
        return audits;
    }

    public static Audit AuditForSectionAndPosition(String sectionAudit, int positionAudit) {

        for (Audit audit : AuditList) {
            if (audit.SectionAudit.equals(sectionAudit) && audit.PositionAudit == positionAudit) {
                return audit;
            }
        }
        return null;
    }

    public static int getReportId(String sectionAudit, String Title){
        int count = 0;
        for (Audit audit : AuditList) {
            if (audit.SectionAudit.equals(sectionAudit) && audit.Title == Title) {
                count+=1;
            }
        }
        return count;
    }

    public static int getSubItem(String sectionAudit, int Sub_item_number){
        int count = 0;
        for (Audit audit : AuditList) {
            if (audit.SectionAudit.equals(sectionAudit) && audit.Sub_item_number == Sub_item_number) {
                count+=1;
            }
        }
        return count;
    }




    private String Title;
    private String Description;
    private String SectionAudit;

    public int PositionAudit;



    private Integer Report_id;
    private String Name_category;
    private Integer Sub_item_number;
    private String Roadmap;
    private String Evaluation;
    private String Comments;

//    public Audit(EAudit sectionAudit, int positionAudit, String title, String description) {
//        Title = title;
//        Description = description;
//        SectionAudit = sectionAudit;
//
//        PositionAudit = positionAudit;
//
//    }

    public Audit(String title, String description, String sectionAudit, int positionAudit, Integer report_id, String name_category, Integer sub_item_number, String roadmap, String evaluation, String comments) {
        this.Title = title;
        this.Description = description;
        this.SectionAudit = sectionAudit;
        this.PositionAudit = positionAudit;
        this.Report_id = report_id;
        this.Name_category = name_category;
        this.Sub_item_number = sub_item_number;
        this.Roadmap = roadmap;
        this.Evaluation = evaluation;
        this.Comments = comments;
    }
    public Audit(){}

    public int getPositionAudit() {
        return PositionAudit;
    }
    public void setPositionAudit(int positionAudit) {
        PositionAudit = positionAudit;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }
    public Integer getReport_id() {
        return Report_id;
    }

    public void setReport_id(Integer report_id) {
        Report_id = report_id;
    }

    public String getName_category() {
        return Name_category;
    }

    public void setName_category(String name_category) {
        Name_category = name_category;
    }

    public Integer getSub_item_number() {
        return Sub_item_number;
    }

    public void setSub_item_number(Integer sub_item_number) {
        Sub_item_number = sub_item_number;
    }

    public String getEvaluation() {
        return Evaluation;
    }

    public void setEvaluation(String evaluation) {
        Evaluation = evaluation;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getRoadmap() {
        return Roadmap;
    }

    public void setRoadmap(String roadmap) {
        Roadmap = roadmap;
    }
}
