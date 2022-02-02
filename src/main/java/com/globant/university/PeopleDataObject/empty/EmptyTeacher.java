package com.globant.university.PeopleDataObject.empty;

import com.globant.university.PeopleDataObject.Teacher;

/**
 * Child class of community member that holds an empty instance of a teacher
 */
public class EmptyTeacher extends Teacher {
    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public String[] getFullCommunityMemberData() {
        return new String[0];
    }
}
