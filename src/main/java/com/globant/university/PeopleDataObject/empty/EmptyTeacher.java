package com.globant.university.PeopleDataObject.empty;

import com.globant.university.PeopleDataObject.Teacher;

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
