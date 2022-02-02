package com.globant.university.peopleDataObject;

public class FullTimeTeacher extends Teacher{
    private int yearsOfExperience;
    public FullTimeTeacher(String name, int age, double baseSalary,int yearsOfExperience) {
        super(name, age,baseSalary);
        this.yearsOfExperience=yearsOfExperience;
    }

    @Override
    public double getSalary() {
        return Math.round((this.getBaseSalary()*(1.1*yearsOfExperience))* 100.0) / 100.0;
    }


    @Override
    public String[] getFullCommunityMemberData() {
        return new String[]{
                this.getId(),
                this.getName(),
                String.valueOf(this.getAge()),
                String.valueOf(this.getSalary()),
                this.getClass().getSimpleName()
                        .substring(0,this.getClass().getSimpleName().indexOf("Teacher"))};

    }
}
