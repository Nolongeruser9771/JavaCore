package main;

import data.ProductData;
import data.UserData;
import entities.*;
import view.LoginHomeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<PreOrder> preOrders = new ArrayList<>();

        ArrayList<User> users = new ArrayList<>();
        UserData userData = new UserData();
        users = userData.userData(users);

        Scanner scanner = new Scanner(System.in);

        ProductData productData = new ProductData();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> prods = productData.productData(products);



        while (true) {
            LoginHomeView loginHomeView = new LoginHomeView();
            loginHomeView.displayLoginHomeView(scanner, prods, users, orders,preOrders);
        }
    }
}