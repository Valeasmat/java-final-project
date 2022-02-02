package com.globant.university;

import com.globant.university.Exception.InvalidScannerInputException;
import com.globant.university.Repository.UniversityRepository;
import com.globant.university.Service.University;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to our university");
        University university =new University(new UniversityRepository());

        boolean keepLooping=true;
        boolean returnToMenu=true;
        while(keepLooping){
            try{
                int option=6;
                if(returnToMenu){
                    option=printMenu(sc);
                }
                switch (option){
                    case 1:
                        printTeachersInfo(university);
                        if(returnToMenu(sc)==2)returnToMenu=false;
                        break;
                    case 2:
                        int courseOption=printCoursesSubmenu(sc, university);
                        printCourseData(university,courseOption);
                        if(returnToMenu(sc)==2)returnToMenu=false;
                        break;
                    case 3:
                        System.out.println("Insert student's full name,at least 3 characters");
                        String studentName=nameDataInput(sc).toUpperCase();
                        int studentAge=ageDataInput(sc);
                        System.out.println("Select course to enroll:");
                        courseOption=printCoursesSubmenu(sc, university);
                        String enrollStudent = university.createAndEnrollStudent(studentName, studentAge, courseOption);
                        System.out.println(enrollStudent);
                        if(returnToMenu(sc)==2)returnToMenu=false;
                        break;
                    case 4:
                        String courseName=nameDataInput(sc).toUpperCase();
                        String courseClassroom=classroomDataInput(sc).toUpperCase();
                        System.out.println("Select teacher to assign:");
                        String teacherOption=printCommunityMemberSubmenu(sc, university,1);
                        if(!university.doesTeacherIdExist(teacherOption)){
                            System.out.println("Teacher id not found, assign later");
                            teacherOption="";
                        }
                        System.out.println("Proceed to insert the ids of the students to enroll:");
                        String[] studentsId=studentsIdsInputData(sc, university);
                        String newCourse = university.createCourse(courseName, courseClassroom, teacherOption, studentsId);
                        System.out.println("--------------------------------------------------");
                        System.out.println("Course created successfully");
                        System.out.println(newCourse);
                        System.out.println("--------------------------------------------------");
                        if(returnToMenu(sc)==2)returnToMenu=false;
                        break;
                    case 5:
                        System.out.println("Select id student to start search:");
                        sc.nextLine();
                        String idStudent=printCommunityMemberSubmenu(sc, university,2);
                        String studentCoursesById = university.getStudentCoursesById(idStudent);
                        System.out.println("--------------------------------------------------");
                        System.out.println("Student "+idStudent+" result search: ");
                        System.out.println(studentCoursesById);
                        if(returnToMenu(sc)==2)returnToMenu=false;
                        break;
                    case 6:
                        System.out.println("Quitting...");
                        keepLooping=false;
                        break;
                    default:
                        throw new InvalidScannerInputException("Invalid option, try again");
                }
            }catch(InvalidScannerInputException e){
                System.out.println("--------------------------------------------------");
                System.out.println("Error: "+e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("--------------------------------------------------");
                System.out.println("Error: Invalid input,number needed");

                sc.next();
            }

        }


    }

    private static void printCourseData(University newUniversity, int courseOption)  {
        String courseData = newUniversity.getCourseData(courseOption);
        System.out.println("--------------------------------------------------");
        System.out.println(courseData);
        System.out.println("--------------------------------------------------");
    }

    public static int printMenu(Scanner sc){
        System.out.println("--------------------------------------------------");
        System.out.println("Principal Menu:");
        System.out.println("1. Print all teachers and their data");
        System.out.println("2. Print Course Data");
        System.out.println("3. Create and assign student");
        System.out.println("4. Create course");
        System.out.println("5. List courses in which a student is enrolled");
        System.out.println("6. Quit");
        System.out.println("--------------------------------------------------");
        System.out.print("Insert option:");
        return sc.nextInt();
    }

    public static void printTeachersInfo(University university){
        System.out.println("--------------------------------------------------");
        System.out.println(university.getTeachersList());
        System.out.println("--------------------------------------------------");
    }

    public static int printCoursesSubmenu(Scanner sc, University university){
        System.out.println("--------------------------------------------------");
        System.out.println(university.getCourseList());
        System.out.println("--------------------------------------------------");
        System.out.print("Insert the id of the course selected:");
        return sc.nextInt();
    }

    public static String printCommunityMemberSubmenu(Scanner sc, University university, int type){
        System.out.println("--------------------------------------------------");
        System.out.println(university.getCommunityMemberList(type));
        System.out.println("--------------------------------------------------");
        System.out.print("Insert id selected: ");
        return sc.nextLine().toUpperCase();
    }

    public static String nameDataInput(Scanner sc) throws InvalidScannerInputException {
        sc.nextLine();
        System.out.println("Insert name:");
        String name = sc.nextLine();
        if(name.length()<3)throw new InvalidScannerInputException("Wrong name input,try again");
        return name;
    }

    public static int ageDataInput(Scanner sc) throws InvalidScannerInputException {
        System.out.println("Insert student's age: ");
        int age = sc.nextInt();
        if(age<0)throw new InvalidScannerInputException("Wrong age input,try again");
        return age;
    }

    public static String classroomDataInput(Scanner sc) throws InvalidScannerInputException {
        System.out.println("Insert course classroom (at least 3 characters):");
        String classroom = sc.nextLine();
        if(classroom.length()<3)throw new InvalidScannerInputException("Wrong classroom input,try again");
        return classroom;
    }

    public static String[] studentsIdsInputData(Scanner sc, University university) {
        System.out.println("How many students are going to be enrolled?");
        int numberOfStudents=sc.nextInt();
        sc.nextLine();
        String[] studentsId=new String[numberOfStudents];
        for (int i = 0; i < studentsId.length; i++) {
            System.out.println("Select from the list id nro."+(i+1));
            String studentOption=printCommunityMemberSubmenu(sc, university,2);
            if(university.doesStudentIdExist(studentOption)){
                studentsId[i]=studentOption;
            }else{
                System.out.println("Id does not exist, insert another id");
                i--;
            }
        }
        return studentsId;
    }

    public static int returnToMenu(Scanner sc){
        System.out.println("Return to menu?: (1)YES (2)NO");
        System.out.print("Insert option:");
        int result= sc.nextInt();
        if(result<0||result>3)return 2;
        return result;
    }
}
