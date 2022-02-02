package com.globant.university.peopleDataObject;

public class PartTimeTeacher extends Teacher{
    private int activeHoursPerWeek;

    public PartTimeTeacher(String name, int age, double baseSalary,int activeHoursPerWeek) {
        super(name, age, baseSalary);
        this.activeHoursPerWeek=activeHoursPerWeek;
    }

    @Override
    public double getSalary() {
        return Math.round((this.getBaseSalary()*activeHoursPerWeek)* 100.0) / 100.0;
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
