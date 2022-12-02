package main;

import data.ProductData;
import entities.*;
import view.LoginHomeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<PreOrder> preOrders = new ArrayList<>();
        User user1 = new User("Nguyên", "0704690014", "BD","nt@gmail.com","Nguyen","Nguyen@97","MEMBER");
        User user2 = new User("Nguyên", "0704690014", "BD","ntt@gmail.com","NguyenNguyen","Nguyen@97","ADMIN");
        ArrayList<User> users = new ArrayList<>(Arrays.asList(user1,user2));

        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        ProductData productData = new ProductData();
        ArrayList<Product> prods = productData.productData(products);



        while (true) {
            LoginHomeView loginHomeView = new LoginHomeView();
            loginHomeView.displayLoginHomeView(scanner, prods, users, orders,preOrders);
        }
    }
}