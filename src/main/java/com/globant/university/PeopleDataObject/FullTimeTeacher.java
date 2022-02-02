package com.globant.university.PeopleDataObject;


/**
 * Child class of community member that implements the behavior of a full-time teacher
 */
public class FullTimeTeacher extends Teacher{
    private int yearsOfExperience;
    public FullTimeTeacher(String name, int age, double baseSalary,int yearsOfExperience) {
        super(name, age,baseSalary);
        this.yearsOfExperience=yearsOfExperience;
    }

    @Override
    public double getSalary() {
        return this.getBaseSalary() * (1.1 * yearsOfExperience);
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
                String.valueOf(this.yearsOfExperience),
                "-"};

    }
}
