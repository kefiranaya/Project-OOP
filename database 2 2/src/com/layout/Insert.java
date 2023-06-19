package com.layout;

import java.util.Scanner;

import com.controllers.DbController;

public class Insert {
    public static void showInsertData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(40));
        System.out.println("Silahkan Input Data Produk");
        System.out.println("=".repeat(40));

        System.out.print("Nama Produk : ");
        String name = sc.nextLine();
        System.out.print("Harga : ");
        long price = sc.nextLong();
        System.out.print("Jumlah : ");
        int stock = sc.nextInt();
        System.out.println("=".repeat(40));

        if (DbController.insertData(name, price, stock)) {
            System.out.println("Berhasil Insert Data");
        } else {
            System.out.println("Gagal Insert Data");
        }

        System.out.println("-".repeat(40));
        Menu.showMenu();
        sc.close();
    }
}
