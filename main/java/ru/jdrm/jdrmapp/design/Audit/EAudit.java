package ru.jdrm.jdrmapp.design.Audit;

import java.util.ArrayList;

public enum EAudit {

    Management("Safety"),
    ProductionPreparation("production_preparation"),
    SFMManualOperations("sf_m_manual_operations"),
    SFEEquipment("sf_e_equipment"),
    OTiB("otib"),
    Quality("quality"),
    SupplyChain("supply_chain"),
    TechnicalDevelopment("technical_development");

    private final String value;

    EAudit(String value){
        this.value = value;
    }

    public static String getValue(EAudit audit){
        return audit.value;
    }

    public static ArrayList<String> getListNameColumn(){
        ArrayList<String> list = new ArrayList<>();
        for(EAudit section : EAudit.values()){
            list.add(section.value);
        }
       return list;
    }

    public static EAudit fromValue(String value) {
        for (final EAudit eRole : values()) {
            if (eRole.value.equalsIgnoreCase(value)) {
                return eRole;
            }
        }
        return null;
    }
}
