package com.globant.university.Service;

import com.globant.university.CourseDataObject.Course;
import com.globant.university.CourseDataObject.empty.EmptyCourse;
import com.globant.university.PeopleDataObject.Student;
import com.globant.university.PeopleDataObject.Teacher;
import com.globant.university.PeopleDataObject.UniversityCommunityMember;
import com.globant.university.PeopleDataObject.empty.EmptyStudent;
import com.globant.university.PeopleDataObject.empty.EmptyTeacher;
import com.globant.university.Repository.UniversityRepository;
import com.globant.university.Utilities.Header;
import com.jakewharton.fliptables.FlipTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniversityService {
    private UniversityRepository universityRepository;

    public UniversityService(){
        this.universityRepository=new UniversityRepository();
    }

    public UniversityService(UniversityRepository universityRepository){
        this.universityRepository=universityRepository;
    }

    public String getTeachersList(){
        String[] header= Header.getTeacherFullHeader() ;
        Set<Teacher> teacherList = this.universityRepository.getTeacherList();
        String[][] teachersData=new String[teacherList.size()][];
        int position=0;
        for (Teacher teacher: teacherList) {
            teachersData[position]=teacher.getFullCommunityMemberData();
            position++;
        }
        return FlipTable.of(header, teachersData);
    }

    public String getCourseList(){
        String[] header=Header.getBasicHeader();
        List<Course> courseList = this.universityRepository.getCourseList();
        String[][] coursesNames=new String[courseList.size()][];
        int position=0;
        for (Course course: courseList) {
            coursesNames[position]=course.getCourseBasicInfo();
            position++;
        }
        return FlipTable.of(header,coursesNames);
    }

    public String getCourseData(int id) {
        Course courseById = this.universityRepository.findCourseById(id);
        String result;
        if(courseById instanceof EmptyCourse){
            result="Course with id: "+id+" not found, no data available";
        }else {
            result=courseById.getCourseData();
        }
        return result;
    }

    public String getCommunityMemberList(int type){
        List<UniversityCommunityMember> membersList=new ArrayList<>();
        if(type==1){
            membersList.addAll(this.universityRepository.getTeacherList());
        } else if(type==2){
            membersList.addAll(this.universityRepository.getStudentList());
        }
        String[][] communityMembersData=new String[membersList.size()][];
        int position=0;
        for (UniversityCommunityMember member:membersList) {
            communityMembersData[position]=member.getResumedCommunityMemberData();
            position++;
        }
        return FlipTable.of(Header.getBasicHeader(),communityMembersData);
    }


    public String getStudentCoursesById(String id)  {
        List<Course> coursesEnrolled=this.universityRepository.getCoursesByStudentId(id);
        String result;
        if(coursesEnrolled.isEmpty()){
            result="Student with id "+id+" is not enrolled in any course";
        }else{
            String[] header=Header.getBasicHeader();
            String[][] coursesNames=new String[coursesEnrolled.size()][];
            int position=0;
            for (Course course:coursesEnrolled) {
                coursesNames[position]=course.getCourseBasicInfo();
                position++;
            }
            result=FlipTable.of(header,coursesNames);
        }
        return result;
    }

    public String createAndEnrollStudent(String studentName,int studentAge,int courseId) {
        Student studentToEnroll=new Student(studentName,studentAge);
        this.universityRepository.addStudent(studentToEnroll);
        String result="Student created id: "+studentToEnroll.getId()+",now enrolled in the university"+"\n";
        Course course=this.universityRepository.findCourseById(courseId);
        if(course instanceof EmptyCourse){
            result=result+"Course with id: "+courseId+" not found, student enrollment in course unsuccessful";
        }else{
            course.enrollStudent(studentToEnroll);
            result=result+"Student enrolled successfully \n";
            String[] header=Header.getStudentFullHeader();
            String[][] studentInfo=new String[1][];
            studentInfo[0]=studentToEnroll.getFullCommunityMemberData();
            result=result+FlipTable.of(header,studentInfo);
        }
        return result;
    }

    public boolean doesTeacherIdExist(String id)  {
        Teacher teacherById = this.universityRepository.findTeacherById(id);
        return !(teacherById instanceof EmptyTeacher);
    }

    public boolean doesStudentIdExist(String id) {
        Student studentById=this.universityRepository.findStudentById(id);
        return !(studentById instanceof EmptyStudent);
    }


    public String createCourse(String courseName,String courseClassroom,String teacherId,String[] studentsId)  {
        Course newCourse=new Course(courseName,courseClassroom);
        Teacher teacher=this.universityRepository.findTeacherById(teacherId);
        newCourse.assignTeacher(teacher);
        Set<Student> studentsToEnroll=new HashSet<>();
        for (String j : studentsId) {
            studentsToEnroll.add(this.universityRepository.findStudentById(j));
        }
        newCourse.enrollStudents(studentsToEnroll);
        this.universityRepository.addCourse(newCourse);
        return newCourse.getCourseData();
    }
}
