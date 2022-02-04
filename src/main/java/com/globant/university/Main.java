package com.globant.university;

import com.globant.university.Exception.InvalidScannerInputException;
import com.globant.university.Repository.UniversityRepository;
import com.globant.university.Service.University;

import java.util.*;

/**
 * Runner class that initialize the functionality of a university, at this point it has available 6 options, but it can be extended according to requirements.
 * Functionalities:
 * 1.Print all teachers and their data
 * 2.Print Course Data
 * 3.Create and enroll student
 * 4.Create course
 * 5.List courses in which a student is enrolled
 * 6.Quit
 */
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
                    option= getOptionFromPrincipalMenu(sc);
                }
                switch (option){
                    case 1:
                        printTeachersInfo(university);
                        if(getReturnToMenuOption(sc)==2)returnToMenu=false;
                        break;
                    case 2:
                        int courseOption= getOptionFromCoursesSubmenu(sc, university);
                        printCourseData(university,courseOption);
                        if(getReturnToMenuOption(sc)==2)returnToMenu=false;
                        break;
                    case 3:
                        String studentName= getNameDataInput(sc).toUpperCase();
                        int studentAge= getAgeDataInput(sc);
                        courseOption= getOptionFromCoursesSubmenu(sc, university);
                        String enrollStudent = university.createAndEnrollStudent(studentName, studentAge, courseOption);
                        System.out.println(enrollStudent);
                        if(getReturnToMenuOption(sc)==2)returnToMenu=false;
                        break;
                    case 4:
                        String courseName= getNameDataInput(sc).toUpperCase();
                        String courseClassroom= getClassroomDataInput(sc).toUpperCase();
                        String teacherOption= getOptionFromCommunityMemberSubmenu(sc, university,1);
                        if(!university.doesTeacherIdExist(teacherOption)){
                            System.out.println("Teacher id not found, no teacher assignation");
                            teacherOption="";
                        }
                        String[] studentsId= getStudentsIdsInputData(sc, university);
                        int newCourseId = university.createCourse(courseName, courseClassroom, teacherOption, studentsId);
                        System.out.println("Course created successfully");
                        printCourseData(university,newCourseId);
                        if(getReturnToMenuOption(sc)==2)returnToMenu=false;
                        break;
                    case 5:
                        sc.nextLine();
                        String idStudent= getOptionFromCommunityMemberSubmenu(sc, university,2);
                        printResultCourseSearch(university,idStudent);
                        if(getReturnToMenuOption(sc)==2)returnToMenu=false;
                        break;
                    case 6:
                        System.out.println("Quitting...");
                        keepLooping=false;
                        break;
                    default:
                        throw new InvalidScannerInputException("Invalid option,select between 1 and 6, try again");
                }
            }catch(InvalidScannerInputException e){
                System.out.println("--------------------------------------------------");
                System.out.println("Error: "+e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("--------------------------------------------------");
                System.out.println("Error: Invalid input,int needed");

                sc.next();
            }

        }


    }

    private static void printResultCourseSearch(University university, String idStudent) {
        System.out.println("--------------------------------------------------");
        System.out.println("Student "+idStudent+" result search: ");
        System.out.println("--------------------------------------------------");
        if(university.doesStudentIdExist(idStudent)){
            String studentCoursesById = university.getStudentCoursesById(idStudent);
            System.out.println(studentCoursesById);
        } else{
            System.out.println("Student "+idStudent+ " does not exist");
        }
    }

    private static void printCourseData(University university, int courseOption)  {
        String courseData = university.getCourseData(courseOption);
        System.out.println("--------------------------------------------------");
        System.out.println(courseData);
    }

    private static int getOptionFromPrincipalMenu(Scanner sc){
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

    private static void printTeachersInfo(University university){
        System.out.println("--------------------------------------------------");
        System.out.println(university.getTeachersList());
    }

    private static int getOptionFromCoursesSubmenu(Scanner sc, University university){
        System.out.println("Select course:");
        System.out.println("--------------------------------------------------");
        System.out.println(university.getCourseList());
        System.out.println("--------------------------------------------------");
        System.out.println("*Courses Ids are integer numbers*");
        System.out.print("Insert the id of the course selected:");
        return sc.nextInt();
    }

    private static String getOptionFromCommunityMemberSubmenu(Scanner sc, University university, int type){
        if(type==1){
            System.out.println("Select teacher:");
        } else {
            System.out.println("Select student:");
        }
        System.out.println(university.getCommunityMemberList(type));
        System.out.println("--------------------------------------------------");
        System.out.print("Insert the id selected: ");
        return sc.nextLine().toUpperCase();
    }

    private static String getNameDataInput(Scanner sc) throws InvalidScannerInputException {
        sc.nextLine();
        System.out.println("The name to register should have at least 3 characters");
        System.out.println("Insert name:");
        String name = sc.nextLine();
        if(name.length()<3)throw new InvalidScannerInputException("Wrong name string input,try again");
        return name;
    }

    private static int getAgeDataInput(Scanner sc) throws InvalidScannerInputException {
        System.out.println("Insert student's age: ");
        int age = sc.nextInt();
        if(age<0)throw new InvalidScannerInputException("Wrong age integer input,try again");
        return age;
    }

    private static String getClassroomDataInput(Scanner sc) throws InvalidScannerInputException {
        System.out.println("Insert course classroom (at least 3 characters):");
        String classroom = sc.nextLine();
        if(classroom.length()<3)throw new InvalidScannerInputException("Wrong classroom string input,try again");
        return classroom;
    }

    private static String[] getStudentsIdsInputData(Scanner sc, University university) {
        System.out.println("Proceed to insert the ids of the students to enroll:");
        System.out.println("--------------------------------------------------");
        System.out.println("How many students are going to be enrolled? :");
        int numberOfStudents=sc.nextInt();
        sc.nextLine();
        String[] studentsId=new String[numberOfStudents];
        for (int i = 0; i < studentsId.length; i++) {
            System.out.println("Select from the list id nro."+(i+1));
            String studentOption= getOptionFromCommunityMemberSubmenu(sc, university,2);
            if(university.doesStudentIdExist(studentOption)){
                studentsId[i]=studentOption;
            }else{
                System.out.println("Id does not exist");
            }
        }
        System.out.println("--------------------------------------------------");
        return studentsId;
    }

    private static int getReturnToMenuOption(Scanner sc){
        System.out.println("--------------------------------------------------");
        System.out.println("Return to menu?: (1)YES (2)NO");
        System.out.print("Insert option:");
        int result= sc.nextInt();
        if(result<0||result>3)return 2;
        return result;
    }
}
