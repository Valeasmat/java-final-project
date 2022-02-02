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
        initializeRepository();
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

    private void initializeRepository(){
        this.teacherList=new HashSet<>();
        FullTimeTeacher teacher1 = new FullTimeTeacher("VALERIA ASMAT", 30, 4700.50, 5);
        teacherList.add(teacher1);
        FullTimeTeacher teacher2 = new FullTimeTeacher("RAMIRO ALEGRE", 31, 4300.60, 3);
        teacherList.add(teacher2);
        PartTimeTeacher teacher3 = new PartTimeTeacher("ANTONIO CUELLAR", 27, 1000.10, 15);
        teacherList.add(teacher3);
        PartTimeTeacher teacher4 = new PartTimeTeacher("RICARDO CHANG", 36, 1000.20, 10);
        teacherList.add(teacher4);
        this.studentList=new HashSet<>();
        Student student1=new Student("MARIA RAMOS",20);
        Student student2=new Student("ANGIE FLORES",21);
        Student student3=new Student("CAMILO BUENDIA",23);
        Student student4=new Student("IRINA CHAVEZ",23);
        Student student5=new Student("JUAN QUISPE",22);
        Student student6=new Student("LORENZO DELACOURT",24);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        this.courseList=new ArrayList<>();
        Course course1=new Course("CALCULUS","201A");
        course1.assignTeacher(teacher1);
        course1.enrollStudent(student1);
        course1.enrollStudent(student3);
        course1.enrollStudent(student6);
        course1.enrollStudent(student4);
        Course course2=new Course("PHYSICS","300B");
        course2.assignTeacher(teacher2);
        course2.enrollStudent(student2);
        course2.enrollStudent(student4);
        course2.enrollStudent(student1);
        course2.enrollStudent(student5);
        Course course3=new Course("LITERATURE","300C");
        course3.enrollStudent(student1);
        course3.enrollStudent(student3);
        course3.enrollStudent(student5);
        course3.enrollStudent(student6);
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
    }
}
