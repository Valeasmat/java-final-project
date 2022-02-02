package com.globant.university.Utilities;

public class Header {
    public static String[] getBasicHeader(){
        return new String[]{"ID","NAME"};
    }
    public static String[] getTeacherFullHeader(){
        return new String[]{"ID","NAME","AGE","SALARY","TYPE","YEARS OF EXPERIENCE","ACTIVE HRS/WEEK"};
    }
    public static String[] getStudentFullHeader(){
        return new String[]{"ID","NAME","AGE"};
    }

}
