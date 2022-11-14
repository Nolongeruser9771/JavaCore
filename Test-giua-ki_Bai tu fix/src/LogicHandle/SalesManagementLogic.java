package LogicHandle;

import Entity.Product;
import Entity.Sales;
import Entity.SalesManagement;
import Entity.productDetail;

import java.util.Scanner;

import static MainRun.MainRun.*;

public class SalesManagementLogic {

    public static void addNewSalesManagement() {
        if(!isOfNull()) {
            System.out.println("Bạn cần dữ liệu để tính");
            return;
        }
        System.out.println("Nhập số lượng nhân viên muốn in DS:");
        int salesNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < salesNum; i++) {
            System.out.println("Nhập thông tin bán hàng của nhân viên thứ " + (i + 1));
            System.out.println("Nhập id nhân viên thứ " + (i + 1));
            int salesID;
            Sales sale;
            do {
                salesID = new Scanner(System.in).nextInt();
                sale = SalesLogic.findSalesById(salesID);
                if (sale != null) {
                    break;
                }
                System.out.println("Không có id nhân viên này");
            } while (true);
            System.out.println("Nhân viên này bán bao nhiêu mặt hàng?");
            int productNum;
            do {
                productNum = new Scanner(System.in).nextInt();
                if (productNum < 5) {
                    break;
                }
                System.out.println("Mỗi nhân viên không được bán trên 5 mặt hàng");
            }while (true);
            productDetail[] productDetails = new productDetail[productNum];
            int count = 0;
            Product product;
            for (int j = 0; j < productNum; j++) {
                    System.out.println("Nhập id loại hàng thứ " + (j + 1));
                    int productID;
                    do {
                        productID = new Scanner(System.in).nextInt();
                        product = ProductLogic.findProductById(productID);
                        if (product == null) {
                            System.out.println("Không có loại sản phẩm id " + productID);
                            continue;
                        }
                        if (!isOfIdAvailable(productDetails, productID)){
                            break;
                        }
                        System.out.println("Id đã tồn tại. mời nhập lại");
                    } while (true);
                productDetails[count] = new productDetail(product);
                count++;
            }
            SalesManagement salesManagement = new SalesManagement(sale, productDetails);
            saveSalesManagementInfo(salesManagement);
        }
    }

    private static boolean isOfNull(){
        boolean salesValid = false;
        boolean productsValid = false;
        for (int i = 0; i < sales.length; i++) {
            if(sales[i]!=null){
                salesValid = true;
            }
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i]!=null) {
                productsValid = true;
            }
        }
        return salesValid && productsValid;
    }
    private static boolean isOfIdAvailable(productDetail[] productDetails, int productID) {
        boolean checkIdAvailable = false;
        for (int i = 0; i < productDetails.length; i++) {
            if(productDetails[i]!=null && productDetails[i].getProduct().getId()== productID) {
                checkIdAvailable = true;
                break;
            }
        }
        return checkIdAvailable;
    }

    private static void saveSalesManagementInfo(SalesManagement salesManagement) {
        for (int i = 0; i < salesManagements.length; i++) {
            if (salesManagements[i] == null) {
                salesManagements[i] = salesManagement;
                break;
            }
        }
    }

    public static void showSalesManagementInfo() {
        for (int i = 0; i < salesManagements.length; i++) {
            if (salesManagements[i] != null) {
                System.out.println(salesManagements[i]);
            }
        }
    }

    public static SalesManagement[] sortByName() {
        for (int i = 0; i < salesManagements.length - 1; i++) {
            if (salesManagements[i] == null) {
                continue;
            }
            for (int j = i; j < salesManagements.length; j++) {
                if (salesManagements[j] == null) {
                    continue;
                }
                if ((salesManagements[i].getSale().getName()).compareTo(salesManagements[j].getSale().getName()) > 0) {
                    SalesManagement tempt = salesManagements[i];
                    salesManagements[i] = salesManagements[j];
                    salesManagements[j] = tempt;
                }
            }
        }
        return salesManagements;
    }

    public static SalesManagement[] sortByProductGroup() {
        for (int i = 0; i < salesManagements.length - 1; i++) {
            if (salesManagements[i] == null) {
                continue;
            }
            for (int j = i; j < salesManagements.length; j++) {
                if (salesManagements[j] == null) {
                    continue;
                }
                productDetail[] productDetails = salesManagements[i].getProductDetails();
                for (int k = 0; k < productDetails.length - 1; k++) {
                    if (productDetails[k] == null) {
                        continue;
                    }
                    for (int l = k; l < productDetails.length; l++) {
                        if (productDetails[l] == null) {
                            continue;
                        }
                        if (productDetails[k].getProduct().getProductGroup().compareTo(productDetails[l].getProduct().getProductGroup()) > 0) {
                            productDetail tempt = productDetails[k];
                            productDetails[k] = tempt;
                        }

                    }
                }
            }
        }
        return salesManagements;
    }

    public static void showSalesManagementAfterSortBProductGroup(SalesManagement[] salesManagements) {
        for (int i = 0; i < salesManagements.length; i++) {
            if (salesManagements[i] != null) {
                System.out.println(salesManagements[i]);
            }
        }
    }
    public static void showSalesManagementAfterSortByName(SalesManagement[] salesManagements) {
        for (int i = 0; i < salesManagements.length; i++) {
            if (salesManagements[i] != null) {
                System.out.println(salesManagements[i]);
            }
        }
    }

    public static void earningCount() {
        double earning =0;
        for (int i = 0; i < salesManagements.length; i++) {
            earning =0;
            SalesManagement sale1 = salesManagements[i];
            if(sale1==null) {
                continue;
            }
            String saleName = sale1.getSale().getName();
            productDetail[] productDetails = salesManagements[i].getProductDetails();
                for (int k = 0; k < productDetails.length; k++) {
                    if(productDetails[k]==null) {
                        continue;
                    }
                        earning += productDetails[k].getProduct().getPrice()*productDetails[k].getProduct().getPrice();
                    }
            System.out.println("Doanh thu của nhân viên tên "+ saleName + " là: "+ earning);
        }
    }
}
