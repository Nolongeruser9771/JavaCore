package main;

import entities.Member;
import entities.Order;
import entities.Product;
import view.LoginHomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            LoginHomeView loginHomeView = new LoginHomeView();
            loginHomeView.displayLoginHomeView(scanner, products, members, orders);
        }
    }
}