package com.globant.university.PeopleDataObject;

import java.util.Objects;

/**
 * Parent class that holds the data of a university community member, it can be a teacher or a student
 */
public abstract class UniversityCommunityMember {
    private String name;
    private String id;
    private int age;
    private static int counter=1;

    public UniversityCommunityMember(){
        this.name="";
        this.age=0;
        this.id="0000";
    }

    public UniversityCommunityMember(String name, int age) {
        this.name = name;
        this.age = age;
        this.id=counter+this.name.substring(0,2).toUpperCase()+(age+this.name.length());
        counter++;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }


    /**
     * @return an array of strings with all the attributes corresponding to the community member
     */
    public abstract String[] getFullCommunityMemberData();

    /**
     * @return an array of strings with the id and name corresponding to the community member
     */
    public String[] getResumedCommunityMemberData(){
        return new String[]{this.id,this.name};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniversityCommunityMember)) return false;
        UniversityCommunityMember that = (UniversityCommunityMember) o;
        return Objects.equals(id, that.id) && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age);
    }
}
