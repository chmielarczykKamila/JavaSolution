package com.github.kamila;

import com.github.kamila.Utils.UserUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("To create new user : press 1 " + "\r\n" +
                "For delete user : press 2");
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number == 1) {
            System.out.println("Set user name : ");
            String name = scanner.nextLine();
            System.out.println("Set user age : ");
            int age = scanner.nextInt();
            User user = new User(name, age);
            UserUtils.addNewUser(user);
        }
        if (number == 2) {
            System.out.println("Set user name : ");
            String name = scanner.nextLine();
            UserUtils.deleteUser(name);
        }
    }

}
