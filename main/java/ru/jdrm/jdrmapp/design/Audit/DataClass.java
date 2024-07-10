package ru.jdrm.jdrmapp.design.Audit;

import java.util.Map;

import ru.jdrm.jdrmapp.design.Audit.categor.Sections;


public class DataClass {
    // название аудита
    private Map<String, Sections>  dataclass;

    public DataClass() {

    }
    public Map<String, Sections> getDataclass() {
        return dataclass;
    }

    public void setDataclass(Map<String, Sections> dataclass) {
        this.dataclass = dataclass;
    }

}
