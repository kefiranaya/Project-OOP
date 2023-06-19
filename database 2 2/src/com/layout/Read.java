package com.layout;

import java.util.Scanner;

import com.controllers.DbController;

public class Read {
    public static void showReadData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(40));
        System.out.println("Data Produk");
        System.out.println("=".repeat(40));
        DbController.getDatabase();
        System.out.println("=".repeat(40));

        System.out.println("1. Menu");
        System.out.println("2. Exit");
        System.out.print("Pilihan: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    Menu.showMenu();
                    break;
                case 2:
                    System.out.println("=".repeat(40));
                    System.out.println("Terima Kasih Telah Berkunjung");
                    System.out.println("-".repeat(40));
                    System.exit(0);
                default:
                    System.out.println("=".repeat(40));
                    System.out.println("Maaf Menu yang Dipilih Tidak Ada");
                    System.out.println("-".repeat(40));
                    Menu.showMenu();
                    System.exit(0);
                    break;
            }
        } catch (Exception e) {
            System.out.println("=".repeat(40));
            System.out.println("Maaf Inputan Error");
            System.out.println("-".repeat(40));
            System.exit(0);
        }

        System.out.println("-".repeat(40));
        Menu.showMenu();

        sc.close();
    }
}
