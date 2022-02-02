package com.globant.university.Utilities;

/**
 * Utility class that gives the headers of the tables for printing purposes
 */
public class Header {
    /**
     * @return The basic header (id, name)
     */
    public static String[] getBasicHeader(){
        return new String[]{"ID","NAME"};
    }

    /**
     * @return The full header for a teacher information table
     */
    public static String[] getTeacherFullHeader(){
        return new String[]{"ID","NAME","AGE","SALARY","TYPE","YEARS OF EXPERIENCE","ACTIVE HRS/WEEK"};
    }

    /**
     * @return The full header for a student information table
     */
    public static String[] getStudentFullHeader(){
        return new String[]{"ID","NAME","AGE"};
    }

}
