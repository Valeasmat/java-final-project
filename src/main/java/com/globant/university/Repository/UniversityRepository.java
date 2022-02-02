package com.globant.university.Repository;

import com.globant.university.PeopleDataObject.*;
import com.globant.university.PeopleDataObject.empty.*;
import com.globant.university.CourseDataObject.Course;
import com.globant.university.CourseDataObject.empty.EmptyCourse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniversityRepository {
    private Set<Teacher> teacherList;
    private Set<Student> studentList;
    private List<Course> courseList;

    public UniversityRepository(){
        this.teacherList=new HashSet<>();
        this.studentList=new HashSet<>();
        this.courseList=new ArrayList<>();
    }

    public UniversityRepository(Set<Teacher> teacherList,Set<Student> studentList, List<Course> courseList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.courseList = courseList;
    }
    public Teacher findTeacherById(String id) {
        Teacher teacherResult=new EmptyTeacher();
        if(id!=null){
            for (Teacher teacher: this.teacherList) {
                if(teacher.getId().equals(id))teacherResult=teacher;
            }
        }
        return teacherResult;
    }

    public Set<Teacher> getTeacherList() {
        return teacherList;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public Student findStudentById(String id) {
        Student studentResult=new EmptyStudent();
        if(id != null){
            for (Student student: this.studentList) {
                if(student.getId().equals(id))studentResult=student;
            }
        }
        return studentResult;
    }

    public Course findCourseById(int id) {
        Course courseResult=new EmptyCourse();
        for (Course course: this.courseList) {
            if(course.getId()==id)courseResult=course;
        }
        return courseResult;
    }

    public List<Course> getCoursesByStudentId(String id){
        List<Course> coursesEnrolled=new ArrayList<>();
        for (Course course: this.courseList) {
            if(course.isStudentEnrolled(id))coursesEnrolled.add(course);
        }
        return coursesEnrolled;
    }

    public boolean addStudent(Student student){
        boolean result=false;
        if(!(student instanceof EmptyStudent)){
            result=this.studentList.add(student);
        }
        return result;
    }

    public boolean addTeacher(Teacher teacher){
        boolean result=false;
        if(!(teacher instanceof EmptyTeacher)){
            result=this.teacherList.add(teacher);
        }
        return result;
    }
    public boolean addCourse(Course course){
        boolean result=false;
        if(!(course instanceof EmptyCourse)){
            result=this.courseList.add(course);
        }
        return result;
    }
}
