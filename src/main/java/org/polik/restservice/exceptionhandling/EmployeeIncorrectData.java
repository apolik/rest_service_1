package org.polik.restservice.exceptionhandling;

public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
