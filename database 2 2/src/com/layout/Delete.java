package com.layout;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

import com.controllers.DbController;

public class Delete {
    public static void showDeleteData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=".repeat(40));
        System.out.println("Silahkan Pilih Data yang Ingin Dihapus");
        System.out.println("-".repeat(40));
        DbController.getDatabase();
        System.out.println("-".repeat(40));
        System.out.println("**Note: Input nama produk dengan benar!");
        System.out.print("Pilih Nama Produk: ");
        String name = sc.nextLine();
        System.out.println("=".repeat(40));

        if (DbController.deleteData(name)) {
            System.out.println("Berhasil Delete Data");
        } else {
            System.out.println("Maaf, Gagal Delete Data");
        }

        System.out.println("-".repeat(40));
        Menu.showMenu();
        sc.close();
    }
}
