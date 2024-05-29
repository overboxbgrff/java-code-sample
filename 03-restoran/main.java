import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu menures = new menu();
        pesanan pesanpel = new pesanan();

        // int qua = 0;
        int choice = 0;

        menures.tambahMenu(new makanan("Mie Ayam", 20000, "Makanan Utama"));
        menures.tambahMenu(new minuman("Es Teh Manis", 5000, "Minuman Dingin"));
        menures.tambahMenu(new diskon("Promo 1", 0, 10000));

        do {
            //tampilkan daftar menu 
            menures.tampilMenuRes();
            System.out.println();
            System.out.println("++++++++++ Main Menu ++++++++++");
            System.out.println("1. Tambah Item Menu");
            System.out.println("2. Simpan Daftar Menu");
            System.out.println("3. Pesan Menu");
            System.out.println("4. Hitung Total Biaya Pesanan");
            System.out.println("5. Tampilkan Struk Pesanan");
            System.out.println("6. Cetak Struk ke File");
            System.out.println("7. Import Daftar Menu dari File");
            System.out.println("8. Keluar");
            System.out.println("++++++++++++++++++++++++++++++++");

            try {
                System.out.print("Pilih Menu: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Tambah menu
                        System.out.print("Nama item: ");
                        scanner.nextLine();
                        String namaItem = scanner.nextLine();
                        System.out.print("Harga: Rp. ");
                        double hargaItem = scanner.nextDouble();
                        System.out.print("Kategori (Makanan/Minuman/Diskon): ");
                        scanner.nextLine();
                        String kategoriItem = scanner.nextLine();

                        menuitem newItem;
                        if (kategoriItem.equalsIgnoreCase("Makanan")) {
                            System.out.print("Jenis Makanan: ");
                            String jenisMakanan = scanner.nextLine();
                            newItem = new makanan(namaItem, hargaItem, jenisMakanan);
                        } else if (kategoriItem.equalsIgnoreCase("Minuman")) {
                            System.out.print("Jenis Minuman: ");
                            String jenisMinuman = scanner.nextLine();
                            newItem = new minuman(namaItem, hargaItem, jenisMinuman);
                        } else if (kategoriItem.equalsIgnoreCase("Diskon")) {
                            System.out.print("Persentase Diskon (%): ");
                            double persentaseDiskon = scanner.nextDouble();
                            newItem = new diskon(namaItem, hargaItem, persentaseDiskon);
                        } else {
                            System.out.println("Kategori tidak valid!");
                            continue;
                        }
                        menures.tambahMenu(newItem);
                        System.out.println("Item berhasil ditambahkan ke menu.");
                        System.out.println();
                        break;
                    case 2:
                        // tampil daftar menu
                        //menures.tampilMenuRes();
                        System.out.print("Masukkan path untuk menyimpan struk (termasuk nama file): ");
                        scanner.nextLine();
                        String pathexport = scanner.nextLine();
                        IOFile.simpanmenu(pathexport, menures);
                        System.out.println();
                        break;
                    case 3:
                        // Pesan Menu
                        System.out.print("Masukkan nama item yang ingin dipesan: ");
                        scanner.nextLine();
                        String itemPesan = scanner.nextLine();

                        // System.out.println("Banyaknya pesanan : ");
                        // qua = scanner.nextInt();

                        menuitem pesananItem = menures.cariItem(itemPesan);

                        if (pesananItem != null) {
                            pesanpel.tambahpesan(pesananItem);
                            System.out.println("Pesanan berhasil ditambahkan.");
                        } else {
                            System.out.println("Item tidak ditemukan dalam menu.");
                        }
                        System.out.println();
                        break;
                    case 4:
                        // Hitung total biaya pesanan
                        double totalBiaya = pesanpel.hitungtotal();
                        System.out.println("Total Biaya Pesanan: Rp" + totalBiaya);
                        System.out.println();
                        break;
                    case 5:
                        //menampilkan struk pemesanan makanan
                        pesanpel.cetakStruk();
                        System.out.println();
                        break;
                    case 6:
                        // Cetak Struk ke file atau save struk sebagai file
                        System.out.print("Masukkan path untuk menyimpan struk (termasuk nama file): ");
                        scanner.nextLine();
                        String pathStruk = scanner.nextLine();
                        IOFile.exportstruk(pathStruk, pesanpel);
                        System.out.println();
                        break;
                    case 7:
                        // Import daftar menu dari file
                        System.out.print("Masukkan path file untuk mengimport daftar menu: ");
                        scanner.nextLine();
                        String pathMenu = scanner.nextLine();
                        menu menuImport = IOFile.loadmenu(pathMenu);
                        if (menuImport != null) {
                            menures = menuImport;
                            //System.out.println("Daftar menu berhasil diimport dari " + pathMenu);
                        } else {
                            //System.out.println("Gagal mengimport daftar menu dari " + pathMenu);
                        }
                        System.out.println();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Masukan tidak valid. Harap masukkan angka.");
                scanner.nextLine();
                choice = 0;
                System.out.println();
            }
        } while (choice != 8);
        scanner.close();
    }
}
