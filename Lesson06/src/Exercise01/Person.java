package Exercise01;

import java.util.Scanner;

public class Person {
    private String name;
    private String adress;
    private String phoneNumber;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void InputInfo() {
        System.out.print("Input name: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Input adress: ");
        this.adress = new Scanner(System.in).nextLine();
        System.out.print("Input phone number: ");
        this.phoneNumber = new Scanner(System.in).nextLine();
    }
}
