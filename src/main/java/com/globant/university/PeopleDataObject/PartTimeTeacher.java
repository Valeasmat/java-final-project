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
        DecimalFormat twoDecimalFormat=new DecimalFormat("#.##");
        double calculatedSalary = this.getBaseSalary() * activeHoursPerWeek;
        return Double.parseDouble(twoDecimalFormat.format(calculatedSalary));
    }

    @Override
    public String[] getFullCommunityMemberData() {
        return new String[]{
                this.getId(),
                this.getName(),
                String.valueOf(this.getAge()),
                String.valueOf(this.getSalary()),
                this.getClass().getSimpleName()
                        .substring(0,this.getClass().getSimpleName().indexOf("Teacher")),
                "-",
                String.valueOf(this.activeHoursPerWeek)};

    }
}
