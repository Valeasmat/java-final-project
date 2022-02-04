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

    /**
     * Constructor initializes a repo with default data
     */
    public UniversityRepository(){
        initializeRepository();
    }

    /**
     * @param teacherList A list of teachers to initialize the list of teachers in the repo
     * @param studentList A list of students to initialize the list of students in the repo
     * @param courseList A list of courses to initialize the list of courses in the repo
     */
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

    private void initializeRepository(){
        this.teacherList=new HashSet<>();
        FullTimeTeacher valeria_asmat = new FullTimeTeacher("VALERIA ASMAT", 30, 4700.50, 5);
        FullTimeTeacher ramiro_alegre = new FullTimeTeacher("RAMIRO ALEGRE", 31, 4300.60, 3);
        PartTimeTeacher antonio_cuellar = new PartTimeTeacher("ANTONIO CUELLAR", 27, 1000.10, 15);
        PartTimeTeacher ricardo_chang = new PartTimeTeacher("RICARDO CHANG", 36, 1000.20, 10);
        teacherList.add(valeria_asmat);
        teacherList.add(ramiro_alegre);
        teacherList.add(antonio_cuellar);
        teacherList.add(ricardo_chang);
        this.studentList=new HashSet<>();
        Student maria_ramos=new Student("MARIA RAMOS",20);
        Student angie_flores=new Student("ANGIE FLORES",21);
        Student camilo_buendia=new Student("CAMILO BUENDIA",23);
        Student irina_chavez=new Student("IRINA CHAVEZ",23);
        Student juan_quispe=new Student("JUAN QUISPE",22);
        Student lorenzo_delacourt=new Student("LORENZO DELACOURT",24);
        studentList.add(maria_ramos);
        studentList.add(angie_flores);
        studentList.add(camilo_buendia);
        studentList.add(irina_chavez);
        studentList.add(juan_quispe);
        studentList.add(lorenzo_delacourt);
        this.courseList=new ArrayList<>();
        Course calculus=new Course("CALCULUS","201A");
        calculus.assignTeacher(valeria_asmat);
        calculus.enrollStudent(maria_ramos);
        calculus.enrollStudent(camilo_buendia);
        calculus.enrollStudent(lorenzo_delacourt);
        calculus.enrollStudent(irina_chavez);
        Course physics=new Course("PHYSICS","300B");
        physics.assignTeacher(ramiro_alegre);
        physics.enrollStudent(angie_flores);
        physics.enrollStudent(irina_chavez);
        physics.enrollStudent(maria_ramos);
        physics.enrollStudent(juan_quispe);
        Course literature=new Course("LITERATURE","300C");
        literature.assignTeacher(antonio_cuellar);
        literature.enrollStudent(maria_ramos);
        literature.enrollStudent(camilo_buendia);
        literature.enrollStudent(juan_quispe);
        literature.enrollStudent(lorenzo_delacourt);
        courseList.add(calculus);
        courseList.add(physics);
        courseList.add(literature);
    }
}
