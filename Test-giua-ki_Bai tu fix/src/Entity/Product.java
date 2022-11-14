package Entity;

import Constant.ProductGroupConstant;

import java.util.Scanner;

public class Product implements Inputable {
    private static int AUTO_ID=1000;
    private int id;
    private String productName;
    private String productGroup;
    private double price;
    private int quanTiTy;

    public Product() {
    }

    public Product(Product product) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanTiTy() {
        return quanTiTy;
    }

    public void setQuanTiTy(int quanTiTy) {
        this.quanTiTy = quanTiTy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productGroup='" + productGroup + '\'' +
                ", price=" + price +
                ", quanTiTy='" + quanTiTy + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id = AUTO_ID;
        System.out.println("Nhập tên mã hàng");
        this.productName = new Scanner(System.in).nextLine();
        System.out.println("Nhập nhóm hàng: ");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");
        selectOption();
        System.out.println("Nhập giá bán");
        this.price = new Scanner(System.in).nextDouble();
        System.out.println("Nhập số lượng");
        this.quanTiTy = new Scanner(System.in).nextInt();
    }
    private void selectOption() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if(choice>=1 && choice<=4) {
                break;
            }
            System.out.println("Sai loại. Mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                this.productGroup = ProductGroupConstant.DT.value;
                break;
            case 2:
                this.productGroup = ProductGroupConstant.DL.value;
                break;
            case 3:
                this.productGroup = ProductGroupConstant.MT.value;
                break;
            case 4:
                this.productGroup = ProductGroupConstant.TBVP.value;
                break;
        }
    }
}
