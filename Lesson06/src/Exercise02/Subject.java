package Exercise02;

import java.util.Scanner;

public class Subject {
    private int subjectID;
    private String subjectName;
    private int teachingUnit;
    private String subjectType;

    private static int AUTO_SUBJECT_ID;

    public Subject() {
        if (AUTO_SUBJECT_ID==0) {
            AUTO_SUBJECT_ID=99;
        }
        AUTO_SUBJECT_ID++;
        this.subjectID = AUTO_SUBJECT_ID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTechingUnit() {
        return teachingUnit;
    }

    public void setTechingUnit(int techingUnit) {
        this.teachingUnit = techingUnit;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public static int getAutoSubjectId() {
        return AUTO_SUBJECT_ID;
    }

    public static void setAutoSubjectId(int autoSubjectId) {
        AUTO_SUBJECT_ID = autoSubjectId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectID=" + subjectID +
                ", subjectName='" + subjectName + '\'' +
                ", techingUnit=" + teachingUnit +
                ", subjectType='" + subjectType + '\'' +
                '}';
    }

    public void InputSubjectInfo() {
        System.out.println("Input Subject Name: ");
        this.subjectName = new Scanner(System.in).nextLine();
        System.out.println("Input Teaching Unit: ");
        this.teachingUnit = new Scanner(System.in).nextInt();
        System.out.println("Input Subject Type: ");
        System.out.println("1. General Subject");
        System.out.println("2. Core Subject");
        System.out.println("3. Specialized Subject");
        selectSubjectType();
    }
    private void selectSubjectType() {
        int selectedSubjectType;
        do {
            selectedSubjectType = new Scanner(System.in).nextInt();
            if (selectedSubjectType>=1 && selectedSubjectType<=3) {
                break;
            }
            System.out.println("Wrong input. Please input again");
        } while (true);

        switch (selectedSubjectType) {
            case 1:
                this.subjectType = SubjectConstantType.GENERAL;
                break;
            case 2:
                this.subjectType = SubjectConstantType.CORE;
                break;
            case 3:
                this.subjectType = SubjectConstantType.SPECIALIZED;
                break;
        }
    }
}
