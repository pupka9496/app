package ru.jdrm.jdrmapp.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import ru.jdrm.jdrmapp.design.Audit.DataClass;
import ru.jdrm.jdrmapp.design.Audit.categor.Category;
import ru.jdrm.jdrmapp.design.Audit.categor.Sections;
import ru.jdrm.jdrmapp.design.Audit.categor.SubCategory;

public class Read {

    String getNewAudit = "SELECT * FROM New_Audits";
    static String getCascadeNewReport = "SELECT t.*, d.* " +
            "FROM New_Audits t " +
            "LEFT JOIN New_Report d  ON t.report_id = d.report_id ";
    
    String AuditName = "name";
    static String AuditReportId = "report_id";

    String getNewReport = "SELECT * FROM New_Report";
    
    static String ReportSection = "section";
    String ReportEvaCat = "evaluation_category";
    String ReportItemNUM = "sub_item_number";
    static String ReportRoadMap = "requirements_of_the_roadmap";

//    public static List<Report> getDishById() {
//
//        String query = "SELECT * FROM New_Report";
//
//        List<Report> reports = new ArrayList<>();
//
//        CompletableFuture.supplyAsync(() -> {
//            DBHelper.connectAsync(); // Запускаем асинхронное соединение
//
//            while (DBHelper.connection == null) {
//                try {
//                    Thread.sleep(100); // Ждем 100 миллисекунд
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            try {
//
//                Statement stmt = DBHelper.connection.createStatement();
//                ResultSet rs = stmt.executeQuery(query);
//                while (rs.next()) {
//                    report.setPlantId(rs.getInt("plant_id"));
//                    report.setSection(rs.getString("section"));
//                    reports.add(report);
//                }
//                DBHelper.closeConn(DBHelper.connection, stmt, rs);
//            } catch (SQLException e) {}
//            return reports;
//        }).join();
//
//        return reports;
//    }

    public static DataClass getCascadeNewReportData() {

        String query = getCascadeNewReport;

        DataClass dataClasses = new DataClass();

        CompletableFuture.supplyAsync(() -> {
            DBHelper.connectAsync(); // Запускаем асинхронное соединение

            while (DBHelper.connection == null) {
                try {
                    Thread.sleep(100); // Ждем 100 миллисекунд
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Map<String, Sections> mainMap = new HashMap<>();
                Statement stmt = DBHelper.connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String sectionName = rs.getString("name");

                    SubCategory subCategories = new SubCategory();
                    subCategories.setEvaluation(rs.getString("evaluation")); // оценка
                    subCategories.setRequirements_of_the_roadmap(rs.getString(ReportRoadMap));
                    subCategories.setComments(rs.getString("comments"));

                    Category categories = new Category();
                    categories.setName(rs.getString("evaluation_category"));
                    Map<String, SubCategory> map = new HashMap<>();
                    map.put(String.valueOf(rs.getInt("sub_item_number")),subCategories);
                    categories.setSubCategory(map);

                    Sections sections = new Sections();
                    Map<String, Map<String, Category>> maps = new HashMap<>();
                    Map<String, Category> d = new HashMap<>();
                    d.put(String.valueOf(rs.getInt(AuditReportId)),categories);
                    maps.put(String.valueOf(rs.getString(ReportSection)),d);
                    sections.setCategory(maps);
                    // Добавляем Sections в mainMap

                    mainMap.put(sectionName, sections);
                }
                dataClasses.setDataclass(mainMap);
                DBHelper.closeConn(DBHelper.connection, stmt, rs);
            } catch (SQLException e) {}

            return dataClasses;
        }).join();

        return dataClasses;
    }
}

