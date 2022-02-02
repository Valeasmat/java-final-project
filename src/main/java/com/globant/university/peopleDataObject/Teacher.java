package com.globant.university.peopleDataObject;

public abstract class Teacher extends UniversityCommunityMember{
    private double baseSalary;
    public Teacher(){
        super();
        this.baseSalary=0.0;
    }

    public Teacher(String name, int age,double baseSalary) {
        super(name, age);
        this.baseSalary=baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double getSalary();

}
