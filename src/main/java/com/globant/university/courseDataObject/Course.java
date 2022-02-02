package com.globant.university.courseDataObject;

import com.globant.university.peopleDataObject.*;
import com.globant.university.peopleDataObject.empty.*;
import com.globant.university.utilities.Header;
import com.jakewharton.fliptables.FlipTable;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private String name;
    private String classroom;
    private Teacher teacher;
    private Set<Student> studentsEnrolled;
    private int id;
    private static int counter=1;

    public Course(){
        this.name = "";
        this.classroom = "";
        this.teacher=null;
        this.studentsEnrolled=new HashSet<>();
        this.id=0;
    }
    public Course(String name, String classroom) {
        this.name = name;
        this.classroom = classroom;
        this.teacher=null;
        this.studentsEnrolled=new HashSet<>();
        this.id=counter++;
    }

    public int getId() {
        return id;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher=teacher;
    }

    public void enrollStudent(Student student) {
        if(!(student instanceof EmptyStudent)){
            this.studentsEnrolled.add(student);
        }
    }

    public void enrollStudents(Set<Student> studentList)  {
        for(Student student: studentList){
            enrollStudent(student);
        }
    }

    public String getName(){
        return this.name;
    }

    public boolean isStudentEnrolled(String id){
        boolean result=false;
        if(!this.studentsEnrolled.isEmpty()){
            for (Student student:
                    this.studentsEnrolled) {
                if(student.getId().equals(id)) result=true;
            }
        }
        return result;
    }

    public static String[] getBasicHeader(){
        return new String[]{"ID","NAME"};
    }
    public String[] getCourseBasicInfo(){
        return new String[]{this.id+"",this.name};
    }


    public String getCourseData() {
        String[] header= Header.getBasicHeader();
        String teacherString="Teacher is not assigned";
        if(!(this.teacher instanceof EmptyTeacher)){
            String[][] teacherData={this.teacher.getResumedCommunityMemberData()};
            teacherString= FlipTable.of(header,teacherData);
        }
        String studentsString="No students assigned";
        if(!this.studentsEnrolled.isEmpty()){
            String[][] studentData=new String[this.studentsEnrolled.size()][];
            int position=0;
            for (Student student:
                    this.studentsEnrolled) {
                studentData[position]=student.getResumedCommunityMemberData();
                position++;
            }
            studentsString=FlipTable.of(header,studentData);
        }
        return "COURSE: "+ this.name+"\n"
                +"CLASSROOM: "+ this.classroom+"\n"
                +"TEACHER:"+"\n"
                + teacherString+"\n"
                +"STUDENTS ENROLLED:"+"\n"
                +studentsString;
    }
}
