package Exercise02;

import java.util.Scanner;

public class MainRun {
    public static Student[] students = new Student[100];
    public static Subject subjects[] = new Subject[100];
    public static void main(String[] args) {

        while (true) {
            showMenu();
            int functionchoice = selectMenuOption();
            logicHandle(functionchoice);
        }
    }

    private static int selectMenuOption() {
        int functionchoice;
        do {
            functionchoice = new Scanner(System.in).nextInt();
            if(functionchoice>=1 && functionchoice<=8) {
                break;
            }
            System.out.println("Wrong select. Please input again");
        } while (true);
        return functionchoice;
    }
    private static void logicHandle (int functionchoice) {
        switch (functionchoice) {
            case 1:
                addNewStudent();
                break;
            case 2:
                showStudentInfo();
                break;
            case 3:
                addNewSubject();
                break;
            case 4:
                showSubjectInfo();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                System.exit(0);
        }

    }
    private static void showMenu() {
        System.out.println("----STUDENT SCCORE MANAGEMENT PROGRAM-----");
        System.out.println("Please select option below: ");
        System.out.println("1. Input new student");
        System.out.println("2. Print all student list");
        System.out.println("3. Input new subject");
        System.out.println("4. Print all subject list");
        System.out.println("5. Input student score");
        System.out.println("6. List Sorting");
        System.out.println("7. Final score calculation");
        System.out.println("8. Exit");
    }

    private static void addNewStudent() {
        System.out.println("Input number of student to add: ");
        int studentNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student();
            student.InputInfo();
            saveStudent(student);
        }
    }
    private static void saveStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if(students[i]==null) {
                students[i] = student;
                break;
            }
        }
    }
    private static void showStudentInfo() {
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null) {
                System.out.println(students[i]);
            }
        }
    }

    private static void addNewSubject() {
        System.out.println("Input number of subject to add: ");
        int subjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = new Subject();
            subject.InputSubjectInfo();
            saveSubject(subject);
        }
    }
    private static void saveSubject(Subject subject){
        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i]==null) {
                subjects[i] = subject;
                break;
            }
        }
    }
    private static void showSubjectInfo() {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i]!=null) {
                System.out.println(subjects[i]);
            }
        }
    }
}
