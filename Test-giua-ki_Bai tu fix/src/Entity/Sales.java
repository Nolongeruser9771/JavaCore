package Entity;

import java.util.Scanner;

public class Sales extends Person{
    private static int AUTO_ID=1000;
    private int id;
    private String signDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", signDate='" + signDate + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id= AUTO_ID;
        super.inputInfo();
        System.out.println("Nhập ngày kí hợp đồng theo định dạng dd/mm/yyyy: ");
        this.signDate = new Scanner(System.in).nextLine();
    }
}
