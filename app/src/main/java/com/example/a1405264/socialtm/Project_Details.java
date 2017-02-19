package com.example.a1405264.socialtm;

/**
 * Created by 1405264 on 2/18/2017.
 */

public class Project_Details {

    private String field;
    private String project_name;

    public Project_Details(){

    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {

        this.project_name = project_name;
    }

    public Project_Details(String field, String project_name) {

        this.field = field;
        this.project_name = project_name;
    }
}
