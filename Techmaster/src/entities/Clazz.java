package entities;

import java.util.ArrayList;

public class Clazz {
    private static ArrayList<Subject> subjects;
    private static ArrayList<Student> students;

    public Clazz(ArrayList<Subject> subjects, ArrayList<Student> students) {
        Clazz.subjects = subjects;
        Clazz.students = students;
    }

    public ArrayList<Subject> getSubject() {
        return subjects;
    }

    public void setSubject(ArrayList<Subject> subject) {
        subjects = subject;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        Clazz.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "subjects=" + subjects +
                ", students=" + students +
                '}';
    }
}
