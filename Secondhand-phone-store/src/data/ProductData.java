package data;

import constant.PhoneTypeConstant;
import entities.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductData {
    //Khởi tạo CSDL cho sản phẩm
    public ArrayList<Product> productData(ArrayList<Product> products) {
    Product prod1 = new Product("Iphone6", PhoneTypeConstant.A.value, "5.55' HD+",1120000,30);
    Product prod2 = new Product("Iphone6s", PhoneTypeConstant.A.value, "6.25' HD+",1135000,30);
    Product prod3 = new Product("Iphone6s+", PhoneTypeConstant.A.value, "5.0' HD+",1250000,30);
    Product prod4 = new Product("Iphone7", PhoneTypeConstant.A.value, "5.5' HD+",2450000,30);
    Product prod5 = new Product("Iphone7s", PhoneTypeConstant.A.value, "5.2' HD+",2630000,30);
    Product prod6 = new Product("Iphone7s+", PhoneTypeConstant.A.value, "5.65' HD+",2990000,30);
    Product prod7 = new Product("Iphone8", PhoneTypeConstant.A.value, "Liquid HD+",4500000,30);
    Product prod8 = new Product("Iphone8s", PhoneTypeConstant.A.value, "5.25'FullHD+",5200000,30);
    Product prod9 = new Product("Iphone8s+",PhoneTypeConstant.A.value, "6.55' FullHD+",5600000,30);
    Product prod10 = new Product("IphoneXS", PhoneTypeConstant.A.value, "6.1' LiqRe",9999000,30);
    Product prod11 = new Product("IphoneSX P", PhoneTypeConstant.A.value, "5.65' HD+",12500000,30);
    Product prod12 = new Product("Iphone11", PhoneTypeConstant.A.value, "6.7' HD+",16500000,30);
    Product prod13 = new Product("Iphone11 P", PhoneTypeConstant.A.value, "FullHD+",18500000,30);
    Product prod14 = new Product("Iphone13", PhoneTypeConstant.A.value, "6.56' HD+",21500000,30);
    Product prod15 = new Product("Iphone13 P", PhoneTypeConstant.A.value, "RAM 8GB",22650000,30);
    Product prod16 = new Product("Iphone14", PhoneTypeConstant.A.value, "6.1' FullHD+",29800000,30);
    Product prod17 = new Product("Iphone14 P", PhoneTypeConstant.A.value, "Sup.RetXDR",31560000,0);
    Product prod18 = new Product("Samsung A093", PhoneTypeConstant.S.value, "32GB FullHD",3190000,30);
    Product prod19 = new Product("Samsung A13", PhoneTypeConstant.S.value, "6.25' FullHD",4690000,30);
    Product prod20 = new Product("Samsung A22", PhoneTypeConstant.S.value, "64GB FullHD",5890000,30);
    Product prod21 = new Product("Samsung A32", PhoneTypeConstant.S.value, "64GB FullHD",6490000,30);
    Product prod22 = new Product("Samsung A53", PhoneTypeConstant.S.value, "64GB FullHD+",9900000,30);
    Product prod23 = new Product("Samsung M53", PhoneTypeConstant.S.value, "S128GB HD+",11490000,30);
    Product prod24 = new Product("Samsung A73",PhoneTypeConstant.S.value, "128GB HD+",11900000,30);
    Product prod25 = new Product("Samsung S22", PhoneTypeConstant.S.value, "128GB HD+",22990000,30);
    Product prod26 = new Product("Samsung F3", PhoneTypeConstant.S.value, "128GB FullHD+",31990000,30);
    Product prod27 = new Product("Samsung F4",PhoneTypeConstant.S.value, "256GB FullHD++",37990000,30);
    Product prod28 = new Product("OPPO A15s", PhoneTypeConstant.O.value, "6.43' FullHD+",3490000,30);
    Product prod29 = new Product("OPPO Reno7", PhoneTypeConstant.O.value, "6.44 FullHD+",20990000,30);
    Product prod30 = new Product("OPPO Reno6P", PhoneTypeConstant.O.value, "6.43' FullHD+",11990000,30);
    Product prod31 = new Product("OPPO Reno8P", PhoneTypeConstant.O.value, "6.55 FullHD+",18990000,30);
    Product prod32 = new Product("OPPO Reno8", PhoneTypeConstant.O.value, "6.7' FullHD+",13990000,30);
    Product prod33 = new Product("OPPO A17 4G", PhoneTypeConstant.O.value, "5.45' FullHD+",3990000,30);

    products = new ArrayList<Product>(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7,prod8,prod9,prod10,prod11,prod12,prod13,prod14,prod15,prod16,prod17,prod18,
            prod19,prod20,prod21,prod22,prod23,prod24,prod25,prod26,prod27,prod28,prod29,prod30,prod31,prod32,prod33));
        return products;
    }
}
