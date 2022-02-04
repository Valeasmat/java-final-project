package com.globant.university.PeopleDataObject;

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

    /**
     * @return The salary of the teacher calculated by its type(full time or part-time)
     */
    public abstract double getSalary();

}
