package com.globant.university.PeopleDataObject;

import java.text.DecimalFormat;

public class FullTimeTeacher extends Teacher{
    private int yearsOfExperience;
    public FullTimeTeacher(String name, int age, double baseSalary,int yearsOfExperience) {
        super(name, age,baseSalary);
        this.yearsOfExperience=yearsOfExperience;
    }

    @Override
    public double getSalary() {
        double calculatedSalary = this.getBaseSalary() * (1.1 * yearsOfExperience);
        DecimalFormat twoDecimalFormat=new DecimalFormat("#.##");
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
                String.valueOf(this.yearsOfExperience),
                "-"};

    }
}
