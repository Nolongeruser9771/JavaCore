package Data;

import constant.PhoneTypeConstant;
import entities.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductData {
    //Khởi tạo CSDL cho sản phẩm
    public ArrayList<Product> productData(ArrayList<Product> products) {
    Product prod1 = new Product("Iphone6", PhoneTypeConstant.A.value, "Smart and fast",1120000);
    Product prod2 = new Product("Iphone6s", PhoneTypeConstant.A.value, "Smart and fast",1135000);
    Product prod3 = new Product("Iphone6s plus", PhoneTypeConstant.A.value, "Smart and fast",1250000);
    Product prod4 = new Product("Iphone7", PhoneTypeConstant.A.value, "Smart and fast",2450000);
    Product prod5 = new Product("Iphone7s", PhoneTypeConstant.A.value, "Smart and fast",2630000);
    Product prod6 = new Product("Iphone7s plus", PhoneTypeConstant.A.value, "Smart and fast",2990000);
    Product prod7 = new Product("Iphone8", PhoneTypeConstant.A.value, "Smart and fast",4500000);
    Product prod8 = new Product("Iphone8s", PhoneTypeConstant.A.value, "Smart and fast",5200000);
    Product prod9 = new Product("Iphone8s plus",PhoneTypeConstant.A.value, "Smart and fast",5600000);
    Product prod10 = new Product("IphoneXS", PhoneTypeConstant.A.value, "Smart and fast",9999000);
    Product prod11 = new Product("IphoneSX pro", PhoneTypeConstant.A.value, "Smart and fast",12500000);
    Product prod12 = new Product("Iphone11", PhoneTypeConstant.A.value, "Smart and fast",16500000);
    Product prod13 = new Product("Iphone11 pro max", PhoneTypeConstant.A.value, "Smart and fast",18500000);
    Product prod14 = new Product("Iphone13", PhoneTypeConstant.A.value, "Smart and fast",21500000);
    Product prod15 = new Product("Iphone13 pro max", PhoneTypeConstant.A.value, "Smart and fast",22650000);
    Product prod16 = new Product("Iphone14", PhoneTypeConstant.A.value, "Smart and fast",29800000);
    Product prod17 = new Product("Iphone14 pro max", PhoneTypeConstant.A.value, "Smart and fast",31560000);
    Product prod18 = new Product("Samsung Galaxy A093", PhoneTypeConstant.S.value, "Smart and fast",3190000);
    Product prod19 = new Product("Samsung Galaxy A13", PhoneTypeConstant.S.value, "Smart and fast",4690000);
    Product prod20 = new Product("Samsung Galaxy A22", PhoneTypeConstant.S.value, "Smart and fast",5890000);
    Product prod21 = new Product("Samsung Galaxy A32", PhoneTypeConstant.S.value, "Smart and fast",6490000);
    Product prod22 = new Product("Samsung Galaxy A53 5G", PhoneTypeConstant.S.value, "Smart and fast",9900000);
    Product prod23 = new Product("Samsung Galaxy M53", PhoneTypeConstant.S.value, "Smart and fast",11490000);
    Product prod24 = new Product("Samsung Galaxy A73 5G",PhoneTypeConstant.S.value, "Smart and fast",11900000);
    Product prod25 = new Product("Samsung Galaxy S22 5G", PhoneTypeConstant.S.value, "Smart and fast",22990000);
    Product prod26 = new Product("Samsung Galaxy Fold3 5G", PhoneTypeConstant.S.value, "Smart and fast",31990000);
    Product prod27 = new Product("Samsung Galaxy z Fold4 5G",PhoneTypeConstant.S.value, "Smart and fast",37990000);
    Product prod28 = new Product("OPPO A15s", PhoneTypeConstant.O.value, "Smart and fast",3490000);
    Product prod29 = new Product("OPPO Reno7", PhoneTypeConstant.O.value, "Smart and fast",20990000);
    Product prod30 = new Product("OPPO Reno6 Pro 5G", PhoneTypeConstant.O.value, "Smart and fast",11990000);
    Product prod31 = new Product("OPPO Reno8 Pro 5G", PhoneTypeConstant.O.value, "Smart and fast",18990000);
    Product prod32 = new Product("OPPO Reno8 5G", PhoneTypeConstant.O.value, "Smart and fast",13990000);
    Product prod33 = new Product("OPPO A17", PhoneTypeConstant.O.value, "Smart and fast",3990000);

    products = new ArrayList<Product>(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7,prod8,prod9,prod10,prod11,prod12,prod13,prod14,prod15,prod16,prod17,prod18,
            prod19,prod20,prod21,prod22,prod23,prod24,prod25,prod26,prod27,prod28,prod29,prod30,prod31,prod32,prod33));
        return products;
    }
}
