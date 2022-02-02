package com.globant.university.CourseDataObject;

import com.globant.university.PeopleDataObject.*;
import com.globant.university.PeopleDataObject.empty.*;
import com.globant.university.Utilities.Header;
import com.jakewharton.fliptables.FlipTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that holds the data of a course, and manages its information (enrollments or assignations)
 */
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

    /**
     * @param teacher the teacher to be assigned to the course
     */
    public void assignTeacher(Teacher teacher) {
        this.teacher=teacher;
    }

    /**
     * @param student The student to be enrolled in the course
     */
    public void enrollStudent(Student student) {
        if(!(student instanceof EmptyStudent)){
            this.studentsEnrolled.add(student);
        }
    }

    /**
     * @param studentList The set of students to be enrolled in the course
     */
    public void enrollStudents(Set<Student> studentList)  {
        for(Student student: studentList){
            enrollStudent(student);
        }
    }


    /**
     * @param id The id of the student to verify if he is enrolled
     * @return True if he's enrolled ,false otherwise
     */
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

    /**
     * @return An array of strings holding the basic data of the course(name,id)
     */
    public String[] getCourseBasicInfo(){
        return new String[]{this.id+"",this.name};
    }


    /**
     * @return A string holding the complete data of the course
     */
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
