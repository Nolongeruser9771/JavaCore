package Exercise02;

import Exercise01.Person;

import java.util.Scanner;

public class Student extends Person {
    private int studentID;
    private String studentGrade;

    private static int AUTO_STUDENT_ID=0;

    public Student() {
        if(AUTO_STUDENT_ID==0) {
            AUTO_STUDENT_ID=9999;
        }
        AUTO_STUDENT_ID++;
        this.studentID = AUTO_STUDENT_ID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public static int getAutoStudentId() {
        return AUTO_STUDENT_ID;
    }

    public static void setAutoStudentId(int autoStudentId) {
        AUTO_STUDENT_ID = autoStudentId;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", studentID=" + studentID +
                ", studentGrade='" + studentGrade + '\'' +
                '}';
    }

    @Override
    public void InputInfo() {
        super.InputInfo();
        System.out.print("Input student grade: ");
        this.studentGrade = new Scanner(System.in).nextLine();
    }
}
