package com.globant.university.peopleDataObject;

public class Student extends UniversityCommunityMember{
    public Student(){
        super();
    }
    public Student(String name, int age) {
        super(name, age);
    }

    public static String[] getFullHeader() {
        return new String[]{"ID","NAME","AGE"};
    }

    @Override
    public String[] getFullCommunityMemberData() {
        return new String[]{
                this.getId(),
                this.getName(),
                String.valueOf(this.getAge())};
    }
}
