package main;

import entities.User;
import view.LogInMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
       while (true) {
           LogInMenu menu = new LogInMenu();
           menu.displayMenu(scanner, users);
       }
    }
}