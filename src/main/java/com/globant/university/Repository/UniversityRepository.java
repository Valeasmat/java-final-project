package com.globant.university.Repository;

import com.globant.university.PeopleDataObject.*;
import com.globant.university.PeopleDataObject.empty.*;
import com.globant.university.CourseDataObject.Course;
import com.globant.university.CourseDataObject.empty.EmptyCourse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class manages the repository of the university, contains the list of teachers,students and courses of a University
 */
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

    /**
     * @param id The id of the teacher requested
     * @return The instance of the teacher requested. If not found an instance of an EmptyTeacher
     */
    public Teacher findTeacherById(String id) {
        Teacher teacherResult=new EmptyTeacher();
        if(id!=null){
            for (Teacher teacher: this.teacherList) {
                if(teacher.getId().equals(id))teacherResult=teacher;
            }
        }
        return teacherResult;
    }

    /**
     * @return Returns the set of teachers in this repo
     */
    public Set<Teacher> getTeacherList() {
        return teacherList;
    }

    /**
     * @return Returns the set of students in this repo
     */
    public Set<Student> getStudentList() {
        return studentList;
    }

    /**
     * @return Returns the list of  courses in this repo
     */
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * @param id The id of the student requested
     * @return The instance of the student requested. If not found an instance of an EmptyStudent
     */
    public Student findStudentById(String id) {
        Student studentResult=new EmptyStudent();
        if(id != null){
            for (Student student: this.studentList) {
                if(student.getId().equals(id))studentResult=student;
            }
        }
        return studentResult;
    }

    /**
     * @param id The id of the course requested
     * @return The instance of the course requested. If not found an instance of an EmptyCourse
     */
    public Course findCourseById(int id) {
        Course courseResult=new EmptyCourse();
        for (Course course: this.courseList) {
            if(course.getId()==id)courseResult=course;
        }
        return courseResult;
    }

    /**
     * @param id The id of the student whose courses are requested
     * @return A list of courses in which the student is enrolled
     */
    public List<Course> getCoursesByStudentId(String id){
        List<Course> coursesEnrolled=new ArrayList<>();
        for (Course course: this.courseList) {
            if(course.isStudentEnrolled(id))coursesEnrolled.add(course);
        }
        return coursesEnrolled;
    }

    /**
     * @param student The student to be added in the university repo
     * @return True if the enrollment is successful
     */
    public boolean addStudent(Student student){
        boolean result=false;
        if(!(student instanceof EmptyStudent)){
            result=this.studentList.add(student);
        }
        return result;
    }

    /**
     * @param teacher The teacher to be added in the university repo
     * @return True if the enrollment is successful
     */
    public boolean addTeacher(Teacher teacher){
        boolean result=false;
        if(!(teacher instanceof EmptyTeacher)){
            result=this.teacherList.add(teacher);
        }
        return result;
    }

    /**
     * @param course The course to be added in the university repo
     * @return True if the course addition is successful
     */
    public boolean addCourse(Course course){
        boolean result=false;
        if(!(course instanceof EmptyCourse)){
            result=this.courseList.add(course);
        }
        return result;
    }

    /**
     * This method initializes a university repo by default
     */
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
