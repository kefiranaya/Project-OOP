# App.java
didalam App.java terdapat method static yaitu method main. Dimana dalam method main terdapat Menu.showMenu();

# com
terdapat 4 package yaitu:
## config
di dalam package config terdapat java class yaitu MyConfig

## controllers
di dalam package controllers terdapat java class yaitu DbController terdapat method static getDatabase untuk mengambil data yang ada dalam dalam database yang kita buat, selain itu terdapat juga getProdukByNama(), insertData(), updateNama(), updateHarga(), updataStok() dan deleteData()

## layout
di dalam package layout terdapat java class yaitu:
a. Delete: berfungsi untuk menghapus data yang ingin dihapus dengan cara menginput nama produk dengan benar

b. Edit: berfungsi untuk mengedit data yang sudah ada

c. Insert: berfungsi untuk menambahkan data baru

d. Menu: berfungsi untuk menampilkan menu serta user dapat menginput menu yang diinginkan

e. Read: berfungsi menampilkan seluruh data yang tersimpan

## models
di dalam package models terdapat java class Produk yang menyimpan atribut Id, name, price, stock, serta terdapat method setter dan getter untuk masing-masing atribut.