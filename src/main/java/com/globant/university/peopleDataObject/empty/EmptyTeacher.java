package com.globant.university.peopleDataObject.empty;

import com.globant.university.peopleDataObject.Teacher;

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
