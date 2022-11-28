package entities;

import java.util.ArrayList;

public class Techmaster {

    private String classManagement;
    private String tutor;
    private Clazz clazz;

    public Techmaster(String classManagement, String tutor, Clazz clazz) {
        this.classManagement = classManagement;
        this.tutor = tutor;
        this.clazz = clazz;
    }

    public String getClassManagement() {
        return classManagement;
    }

    public void setClassManagement(String classManagement) {
        this.classManagement = classManagement;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Techmaster{" +
                "classManagement='" + classManagement + '\'' +
                ", tutor='" + tutor + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
