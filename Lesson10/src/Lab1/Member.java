package Lab1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Member implements Inputable {

    private static int AUTO_ID=100;
    private int id;
    private String name;
    private LocalDate dob;
    private String job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id= AUTO_ID;
        System.out.println("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập ngày sinh theo định dạng dd/MM/yyyy: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dob = LocalDate.parse(new Scanner(System.in).nextLine(),formatter);
        System.out.println("Nhập nghề nghiệp: ");
        this.job = new Scanner(System.in).nextLine();
    }
}
