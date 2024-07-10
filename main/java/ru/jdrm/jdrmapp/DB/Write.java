package ru.jdrm.jdrmapp.DB;

import static ru.jdrm.jdrmapp.DB.Read.getCascadeNewReportData;

import java.util.Map;

import ru.jdrm.jdrmapp.design.Audit.Audit;
import ru.jdrm.jdrmapp.design.Audit.DataClass;
import ru.jdrm.jdrmapp.design.Audit.EAudit;
import ru.jdrm.jdrmapp.design.Audit.categor.Category;
import ru.jdrm.jdrmapp.design.Audit.categor.Sections;
import ru.jdrm.jdrmapp.design.Audit.categor.SubCategory;

public class Write {

    public static void test() {
        DataClass d =  getCascadeNewReportData();

        if(Audit.AuditList.isEmpty()){
            int count = 0;
            for (Map.Entry<String, Sections> entry_Audit : d.getDataclass().entrySet()) {
                String NameAudit = entry_Audit.getKey();
                Map<String, Map<String, Category>> val = entry_Audit.getValue().getCategory();
                for (Map.Entry<String, Map<String, Category>> entry_section: val.entrySet()) {
                    String section = entry_section.getKey();
                    Map<String, Category> vall = entry_section.getValue();
                    for (Map.Entry<String, Category> entry_category : vall.entrySet()) {
                        String report_id = entry_category.getKey();
                        Map<String, SubCategory> valll = entry_category.getValue().getSubCategory();
                        for (Map.Entry<String, SubCategory> entry_subcategory : valll.entrySet()) {
                            String Name_category = entry_category.getValue().getName();
                            String sub_item_number = entry_subcategory.getKey();
                            String roadmap  = entry_subcategory.getValue().getRequirements_of_the_roadmap();
                            String Evaluation = entry_subcategory.getValue().getEvaluation();
                            String Comments = entry_subcategory.getValue().getComments();
                            Audit audit = new Audit(NameAudit,"",section,count,
                                    Integer.parseInt(report_id),
                                    Name_category,
                                    Integer.parseInt(sub_item_number),
                                    roadmap,Evaluation,Comments);
                            count += 1;
                            Audit.AuditList.add(audit);
                        }
                    }
                }
            }
        }
    }
}
