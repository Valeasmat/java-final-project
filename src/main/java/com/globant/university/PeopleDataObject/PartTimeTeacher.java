package com.globant.university.PeopleDataObject;

import java.text.DecimalFormat;

public class PartTimeTeacher extends Teacher{
    private int activeHoursPerWeek;

    public PartTimeTeacher(String name, int age, double baseSalary,int activeHoursPerWeek) {
        super(name, age, baseSalary);
        this.activeHoursPerWeek=activeHoursPerWeek;
    }

    @Override
    public double getSalary() {
        return this.getBaseSalary() * activeHoursPerWeek;
    }

    @Override
    public String[] getFullCommunityMemberData() {
        return new String[]{
                this.getId(),
                this.getName(),
                String.valueOf(this.getAge()),
                String.format("%.2f",this.getSalary()),
                this.getClass().getSimpleName()
                        .substring(0,this.getClass().getSimpleName().indexOf("Teacher")),
                "-",
                String.valueOf(this.activeHoursPerWeek)};

    }
}
