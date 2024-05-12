import java.awt.Menu;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        //import class MenuRes
        MenuRes menu = new MenuRes();

        //inisiasi variable awal
        String menu1 = "", menu2 = "", menu3 = "", menu4 = "", menu5 = "";
        int hmenu1 = 0, hmenu2 = 0, hmenu3 = 0, hmenu4 = 0, hmenu5 = 0;
        int jumlah1 = 0, jumlah2 = 0, jumlah3 = 0, jumlah4 = 0, jumlah5 = 0;
        int swmenu1, swmenu2, swmenu3, swmenu4, swmenu5;

        int diskon = 0, totalkes = 0;

        //inisiasi scanner
        Scanner inmenu1 = new Scanner(System.in), inmenu2 = new Scanner(System.in),
                inmenu3 = new Scanner(System.in), inmenu4 = new Scanner(System.in),
                inmenu5 = new Scanner(System.in);

        Scanner injumlah1 = new Scanner(System.in), injumlah2 = new Scanner(System.in),
                injumlah3 = new Scanner(System.in), injumlah4 = new Scanner(System.in);

        System.out.println("Pilih pilihan makanan/minuman");
        System.out.println("1." + menu.makanan[0] + " - Rp. " + menu.hargamakan[0]);
        System.out.println("2." + menu.makanan[1] + " - Rp. " + menu.hargamakan[1]);
        System.out.println("3." + menu.makanan[2] + " - Rp. " + menu.hargamakan[2]);
        System.out.println("4." + menu.makanan[3] + " - Rp. " + menu.hargamakan[3]);

        System.out.println("5." + menu.minuman[0] + " - Rp. " + menu.hargaminum[0]);
        System.out.println("6." + menu.minuman[1] + " - Rp. " + menu.hargaminum[1]);
        System.out.println("7." + menu.minuman[2] + " - Rp. " + menu.hargaminum[2]);
        System.out.println("8." + menu.minuman[3] + " - Rp. " + menu.hargaminum[3]);

        System.out.println("9. Batalkan/tidak ada lagi");

        System.out.println("");

        //switch case untuk menu 1
        System.out.print("Pilihan menu 1 : ");
        swmenu1 = inmenu1.nextInt();
        switch (swmenu1) {
            case 1:
                menu1 = menu.makanan[0];
                hmenu1 = menu.hargamakan[0];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 2:
                menu1 = menu.makanan[1];
                hmenu1 = menu.hargamakan[1];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 3:
                menu1 = menu.makanan[2];
                hmenu1 = menu.hargamakan[2];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 4:
                menu1 = menu.makanan[3];
                hmenu1 = menu.hargamakan[3];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 5:
                menu1 = menu.minuman[0];
                hmenu1 = menu.hargaminum[0];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 6:
                menu1 = menu.minuman[1];
                hmenu1 = menu.hargaminum[1];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 7:
                menu1 = menu.makanan[2];
                hmenu1 = menu.hargaminum[2];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 8:
                menu1 = menu.minuman[3];
                hmenu1 = menu.hargaminum[3];
                System.out.print(menu1 + " = ");
                jumlah1 = injumlah1.nextInt();
                System.out.println("");
                break;
            case 9:
                System.out.print("Terima Kasih, Selamat Datang Kembali!");
                jumlah1 = 0;
                System.out.println("");
                return;
            default:
                System.out.print("Terima Kasih, Selamat Datang Kembali!");
                jumlah1 = 0;
                System.out.println("");
                return;
        }

        //switch case untuk menu 2
        System.out.print("Pilihan Menu 2 : ");
        swmenu2 = inmenu2.nextInt();
        switch (swmenu2) {
            case 1:
                menu2 = menu.makanan[0];
                hmenu2 = menu.hargamakan[0];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 2:
                menu2 = menu.makanan[1];
                hmenu2 = menu.hargamakan[1];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 3:
                menu2 = menu.makanan[2];
                hmenu2 = menu.hargamakan[2];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 4:
                menu2 = menu.makanan[3];
                hmenu2 = menu.hargamakan[3];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 5:
                menu2 = menu.minuman[0];
                hmenu2 = menu.hargaminum[0];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 6:
                menu2 = menu.minuman[1];
                hmenu2 = menu.hargaminum[1];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 7:
                menu2 = menu.makanan[2];
                hmenu2 = menu.hargaminum[2];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 8:
                menu2 = menu.minuman[3];
                hmenu2 = menu.hargaminum[3];
                System.out.print(menu2 + " = ");
                jumlah2 = injumlah2.nextInt();
                break;
            case 9:
                menu2 = "";
                jumlah2 = 0;
                break;
            default:
                menu2 = "";
                jumlah2 = 0;
                break;
        }
        System.out.println("");

        //switch case untuk menu 3
        System.out.print("Pilihan Menu 3 : ");
        swmenu3 = inmenu3.nextInt();
        switch (swmenu3) {
            case 1:
                menu3 = menu.makanan[0];
                hmenu3 = menu.hargamakan[0];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 2:
                menu3 = menu.makanan[1];
                hmenu3 = menu.hargamakan[1];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 3:
                menu3 = menu.makanan[2];
                hmenu3 = menu.hargamakan[2];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 4:
                menu3 = menu.makanan[3];
                hmenu3 = menu.hargamakan[3];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 5:
                menu3 = menu.minuman[0];
                hmenu3 = menu.hargaminum[0];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 6:
                menu3 = menu.minuman[1];
                hmenu3 = menu.hargaminum[1];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 7:
                menu3 = menu.makanan[2];
                hmenu3 = menu.hargaminum[2];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 8:
                menu3 = menu.minuman[3];
                hmenu3 = menu.hargaminum[3];
                System.out.print(menu3 + " = ");
                jumlah3 = injumlah3.nextInt();
                break;
            case 9:
                menu3 = "";
                jumlah3 = 0;
                break;
            default:
                menu3 = "";
                jumlah3 = 0;
                break;
        }
        System.out.println("");

        //switch case untuk menu 4
        System.out.print("Pilihan Menu 4 : ");
        swmenu4 = inmenu4.nextInt();
        switch (swmenu4) {
            case 1:
                menu4 = menu.makanan[0];
                hmenu4 = menu.hargamakan[0];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 2:
                menu4 = menu.makanan[1];
                hmenu4 = menu.hargamakan[1];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 3:
                menu4 = menu.makanan[2];
                hmenu4 = menu.hargamakan[2];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 4:
                menu4 = menu.makanan[3];
                hmenu4 = menu.hargamakan[3];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 5:
                menu4 = menu.minuman[0];
                hmenu4 = menu.hargaminum[0];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 6:
                menu4 = menu.minuman[1];
                hmenu4 = menu.hargaminum[1];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 7:
                menu4 = menu.makanan[2];
                hmenu4 = menu.hargaminum[2];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 8:
                menu4 = menu.minuman[3];
                hmenu4 = menu.hargaminum[3];
                System.out.print(menu4 + " = ");
                jumlah4 = injumlah4.nextInt();
                break;
            case 9:
                menu4 = "";
                jumlah4 = 0;
                break;
            default:
                menu4 = "";
                jumlah4 = 0;
                break;
        }
        System.out.println("");

        //total menu yang di pesan
        int totalmenu1 = jumlah1 * hmenu1;
        int totalmenu2 = jumlah2 * hmenu2;
        int totalmenu3 = jumlah3 * hmenu3;
        int totalmenu4 = jumlah4 * hmenu4;
        int totalmenu5 = 0;

        int totalpesan = totalmenu1 + totalmenu2 + totalmenu3 + totalmenu4;


        //buy one get one minuman
        if (totalpesan > 50000) {
            System.out.println("");
            System.out.println("Anda mendapatkan promo 'Beli satu minuman gratis satu'");
            System.out.println("1." + menu.minuman[0] + " - Rp. " + menu.hargaminum[0]);
            System.out.println("2." + menu.minuman[1] + " - Rp. " + menu.hargaminum[1]);
            System.out.println("3." + menu.minuman[2] + " - Rp. " + menu.hargaminum[2]);
            System.out.println("4." + menu.minuman[3] + " - Rp. " + menu.hargaminum[3]);
            System.out.println("5. Tidak, terima kasih");

            System.out.print("Pilihan Menu Minuman : ");
            swmenu5 = inmenu5.nextInt();
            switch (swmenu5) {
                case 1:
                    menu5 = menu.minuman[0];
                    hmenu5 = menu.hargaminum[0];
                    break;
                case 2:
                    menu5 = menu.minuman[1];
                    hmenu5 = menu.hargaminum[1];
                    break;
                case 3:
                    menu5 = menu.makanan[2];
                    hmenu5 = menu.hargaminum[2];
                    break;
                case 4:
                    menu5 = menu.minuman[3];
                    hmenu5 = menu.hargaminum[3];
                    break;
                case 5:
                    menu5 = "";
                    hmenu5 = 0;
                    break;
                default:
                    menu5 = "";
                    hmenu5 = 0;
                    break;    
            }
            //diskon 10% jika pesanan lebih dari Rp. 100.000


        }

        System.out.println();
        System.out.println();
        System.out.println();

        //cetak struk
        System.out.println("=========================================");
        System.out.println("RESTORAN BAHAGIA SEDERHANA");
        System.out.println("STRUK BELANJA");
        System.out.println("=========================================");
        System.out.println("");

        //cetak menu 1
        System.out.println(menu1 + "......" + jumlah1 + " porsi/sajian");
        System.out.println(jumlah1 + " x Rp" + hmenu1 + " = Rp." + totalmenu1);
        System.out.println();

        //tampilkan jika memesan menu ke 2
        if (totalmenu2 > 0) {
            System.out.println(menu2 + "......" + jumlah2 + " porsi/sajian");
            System.out.println(jumlah2 + " x Rp" + hmenu2 + " = Rp." + totalmenu2);
            System.out.println();
        } else {
        }
        //tampilkan jika memesan menu ke 3
        if (totalmenu3 > 0) {
            System.out.println(menu3 + "......" + jumlah3 + " porsi/sajian");
            System.out.println(jumlah3 + " x Rp" + hmenu3 + " = Rp." + totalmenu3);
            System.out.println();
        } else {
        }
        //tampilkan jika memesan menu ke 4
        if (totalmenu4 > 0) {
            System.out.println(menu4 + "......" + jumlah4 + " porsi/sajian");
            System.out.println(jumlah4 + " x Rp" + hmenu4 + " = Rp." + totalmenu4);
            System.out.println();
        } else {
        }

        //cetak struk jika mendapatkan minuman
        if (hmenu5 > 0) {
            System.out.println(menu5 + "...... 1 + 1 (Gratis) porsi/sajian");
            System.out.println("1 x Rp" + hmenu5 + " + 1 Free");
            System.out.println();
        } else {
        }

        System.out.println("=========================================");
        int totalbel = totalpesan + hmenu5;
        System.out.println("Total Belanja : Rp. " + totalbel);
        
        //diskon 10% jika pembelian lebih dari 100000
        if (totalpesan > 100000) {
            diskon = 10 * totalbel / 100;
            totalkes = totalbel - diskon;
            System.out.println("Diskon 10% : Rp. " + diskon);
        } else {
            totalkes = totalbel;
        }

        int ppn = totalbel * 10 / 100;
        System.out.println("Pajak Restoran 10% : Rp. " + ppn);

        int biayapel = totalbel * 5 / 100;
        System.out.println("Biaya Pelayanan : Rp. " + biayapel);

        int finaltotal = totalkes + ppn + biayapel;
        System.out.println("TOTAL  : Rp. " + finaltotal);

    }
}