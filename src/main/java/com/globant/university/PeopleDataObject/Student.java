package com.globant.university.PeopleDataObject;

public class Student extends UniversityCommunityMember{
    public Student(){
        super();
    }
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String[] getFullCommunityMemberData() {
        return new String[]{
                this.getId(),
                this.getName(),
                String.valueOf(this.getAge())};
    }
}
