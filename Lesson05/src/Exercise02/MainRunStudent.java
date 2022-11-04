package Exercise02;

//Bài 2: Sử dụng lớp sinh viên trong bài 1, nhập vào danh sách n sinh viên và thực hiện: 

import Exercise02.Student;

import java.util.Objects;
import java.util.Scanner;

public class MainRunStudent {
    public static void main(String[] args) {
        System.out.print("Input number of student to add: ");
        int n = new Scanner(System.in).nextInt();
        Student[] student = new Student[n];

        for (int i = 0; i < n; i++) {
            student[i] = new Student();
            System.out.printf("---------------------------------------\n");
            System.out.print("Student ID 00"+i);
            student[i].id = "00"+i;
            System.out.print("\nInput Name student: ");
            student[i].name = new Scanner(System.in).nextLine();
            System.out.print("Input Class student: ");
            student[i].Class = new Scanner(System.in).nextLine();
            System.out.print("Input SchoolYear student: ");
            student[i].schoolYear = new Scanner(System.in).nextLine();
        }
        //In toàn bộ DSSV
        System.out.println("List of all students");
        System.out.printf("-------------------------------------------------------------------------");
        System.out.printf("\n%10s %20s %20s %20s\n","ID student","Student Name","Class", "School Year");
        for (int i = 0; i < n; i++) {
            student[i].showInfo();
        }

        //Sắp xếp
       Student tempt =student[0];
       for (int i = 0; i < n - 1; i++) {
               for (int j = i + 1; j < n; j++) {
                    if (student[i].getName().compareTo(student[j].getName())>1) {
                        tempt = student[j];
                         student[j] = student[i];
                         student[i] = tempt;
                         }
                    }
               }

        System.out.println("List after NameSorting");
        System.out.printf("-------------------------------------------------------------------------");
        System.out.printf("\n%10s %20s %20s %20s\n","ID student","Student Name","Class", "School Year");
        for (int i = 0; i < n; i++) {
            student[i].showInfo();
        }

        //In DS theo lớp
        System.out.println("Input class needed to be printed: ");
        String classInput = new Scanner(System.in).nextLine();
        System.out.println(classInput);

        System.out.printf("-------------------------------------------------------------------------");
        System.out.printf("\n%10s %20s %20s %20s\n","ID student","Student Name","Class", "School Year");
        for (int i = 0; i < n; i++) {
            if(student[i].getStudentClass().equals(classInput)) {
                student[i].showInfo();
            }
            }
        }
    }
