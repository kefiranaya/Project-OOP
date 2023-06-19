package com.layout;

import java.util.Scanner;

import com.controllers.DbController;
import com.models.Produk;

public class Edit {
    public static void showEditData(String name) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Silahkan Pilih Data yang Ingin Diedit");
        System.out.println("================================");
        DbController.getDatabase();
        System.out.println("================================");
        System.out.println("**Note: Input nama produk dengan benar!!!");
        System.out.print("Pilih Nama Produk: ");
        name = sc.nextLine();

        System.out.println("================================");
        System.out.println("Silahkan Pilih Menu Update Data");
        System.out.println("================================");
        System.out.println("1. Update Nama");
        System.out.println("2. Update Harga");
        System.out.println("3. Update Jumlah");
        System.out.println("4. Back to Menu");

        System.out.println("================================");
        System.out.print("Pilihan: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    showEditNama(name);
                    break;
                case 2:
                    showEditHarga(name);
                    break;
                case 3:
                    showEditJumlah(name);
                    break;
                case 4:
                    Menu.showMenu();
                    break;
                default:
                    System.out.println("================================");
                    System.out.println("Maaf Nama Produk atau Menu yang Dipilih Tidak Ada");
                    System.out.println("--------------------------------");
                    Menu.showMenu();
            }
        } catch (Exception e) {
            System.out.println("================================");
            System.out.println("Maaf Nama Produk atau Menu yang Dipilih Tidak Ada");
            System.out.println("--------------------------------");
            Menu.showMenu();
        }
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditNama(String name) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(name);

        System.out.println("================================");
        System.out.println("Edit Nama");
        System.out.println("================================");
        System.out.println("Nama Awal: " + produk.getName());
        System.out.println("--------------------------------");
        System.out.print("Nama Baru: ");
        String namaBaru = sc.nextLine();
        DbController.updateNama(produk.getId(), namaBaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data Nama");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditHarga(String name) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(name);

        System.out.println("================================");
        System.out.println("Edit Nama");
        System.out.println("================================");
        System.out.println("Harga Awal: " + produk.getPrice());
        System.out.println("--------------------------------");
        System.out.print("Harga Baru: ");
        long hargaBaru = sc.nextLong();
        DbController.updateHarga(produk.getId(), hargaBaru);

        System.out.println("================================");
        System.out.println("Berhasil Update Data Harga");
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }

    public static void showEditJumlah(String name) {
        Scanner sc = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(name);

        System.out.println("=".repeat(40));
        System.out.println("Edit Nama");
        System.out.println("=".repeat(40));
        System.out.println("Jumlah Awal: " + produk.getPrice());
        System.out.println("-".repeat(40));
        System.out.print("Jumlah Baru: ");
        int jumlahBaru = sc.nextInt();
        DbController.updateStok(produk.getId(), jumlahBaru);

        System.out.println("=".repeat(40));
        System.out.println("Berhasil Update Data Stok");
        System.out.println("-".repeat(40));
        Menu.showMenu();
        sc.close();
    }
}
