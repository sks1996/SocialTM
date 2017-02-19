package com.example.a1405264.socialtm;

/**
 * Created by 1405264 on 2/18/2017.
 */

public class New_Project_Details
{
    public String project_name;
    public String field;

    public New_Project_Details() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public New_Project_Details(String project_name, String field) {
        this.project_name = project_name;
        this.field = field;
    }

}
