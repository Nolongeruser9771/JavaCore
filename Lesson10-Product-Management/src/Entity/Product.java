package Entity;

import LogicHandle.Inputable;

import java.util.Scanner;

public class Product implements Inputable {
    private static int AUTO_ID = 1000;
    private int id;
    private String name;
    private String describe;
    private int quantity;
    private double price;
    private String unit;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id = AUTO_ID;
        System.out.println("Nhập tên sản phẩm");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả của sản phẩm");
        this.describe = new Scanner(System.in).nextLine();
        System.out.println("Nhập số lượng sản phẩm");
        this.quantity = new Scanner(System.in).nextInt();
        System.out.println("Nhập giá theo VND");
        this.price = new Scanner(System.in).nextDouble();
        System.out.println("Nhập đơn vị tính");
        this.unit = new Scanner(System.in).nextLine();
    }
}
