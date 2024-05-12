/*
Author : Danang Priyombodo
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Variable bagian pesan
    static MenuRes menures = new MenuRes();

    //variable pesan
    static String pesanchar = "";
    static int pesanjumlah = 0;
    static Integer[] arraypesan = {};
    static Integer[] jumlahpesan = {};


    static int totalsemua = 0;
    static int finaltotal = 0;

    //variable menu
    static String[] listmenuall; // untuk list semua menu
    static int[] listhargaall; //untuk list semua harga menu

    //Variable bagian manajemen


    public static void main(String[] args) {
        allmenu();
        //tampilmenu();
        pesan();
    }

    public static Integer[] addmenu(int n, Integer arr[], int x) {
        //menambahkan data ke array
        List<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(arraypesan));
        arrlist.add(x);
        arraypesan = arrlist.toArray(arraypesan);
        return arraypesan;
    }

    public static Integer[] svjumlahmenu(int n, Integer arr[], int x) {
        List<Integer> arrList = new ArrayList<Integer>(Arrays.asList(jumlahpesan));
        arrList.add(x);
        jumlahpesan = arrList.toArray(jumlahpesan);
        return jumlahpesan;
    }

    //Region "Pesan Menu"
    public static void tampilmenu() {
        //print makanan
        for (int makan = 0; makan < menures.makanan.length; makan++) {
            System.out.println(1 + makan + ". " +
                    menures.makanan[makan] + " ..... Rp. " +
                    menures.hargamakan[makan]);
        }
        //print minuman
        for (int minum = 0; minum < menures.minuman.length; minum++) {
            System.out.println(menures.makanan.length + 1 + minum + ". " +
                    menures.minuman[minum] + " ..... Rp. " +
                    menures.hargaminum[minum]);
        }
        System.out.println("99. Selesai");
    }

    public static void allmenu() {
        listmenuall = new String[menures.makanan.length + menures.minuman.length];
        System.arraycopy(menures.makanan, 0, listmenuall, 0, menures.makanan.length);
        System.arraycopy(menures.minuman, 0, listmenuall, menures.makanan.length, menures.minuman.length);

        listhargaall = new int[menures.hargamakan.length + menures.hargaminum.length];
        System.arraycopy(menures.hargamakan, 0, listhargaall, 0, menures.hargamakan.length);
        System.arraycopy(menures.hargaminum, 0, listhargaall, menures.hargamakan.length, menures.hargaminum.length);

        for (int makan = 0; makan < listmenuall.length; makan++) {
            System.out.println(1 + makan + ". " +
                    listmenuall[makan] + " ..... Rp. " +
                    listhargaall[makan]);
        }
        System.out.println();
        System.out.println("98. Pesan");
        System.out.println("99. Keluar");
    }

    public static void pesan() {
        int jumlahmenu = arraypesan.length + 1;
        Scanner inputmakan = new Scanner(System.in);
        Scanner inputjumlah = new Scanner(System.in);

        System.out.print("Mau pesan Apa? (Menu ke " + jumlahmenu + ") : ");
        pesanchar = inputmakan.nextLine();

        try {
            if (Integer.parseInt(pesanchar) <= listmenuall.length) {
                arraypesan = addmenu(arraypesan.length, arraypesan, Integer.parseInt(pesanchar) - 1);
                System.out.print("Mau berapa porsi? : ");
                pesanjumlah = inputjumlah.nextInt();
                System.out.println();
                jumlahpesan = svjumlahmenu(jumlahpesan.length, jumlahpesan, pesanjumlah);
                System.out.println(Arrays.toString(jumlahpesan));
                //System.out.println(Arrays.toString(arraypesan));
                //System.out.println(listmenuall[Integer.parseInt(pesanchar) - 1]);
                pesan();
            } else if (Integer.parseInt(pesanchar) == 98) {
                //pesan
                cetakstruk();
            } else if (Integer.parseInt(pesanchar) == 99) {
                //Keluar
                System.out.println("Terima Kasih dan Selamat Datang Kembali! :)");
                return;
            } else {
                System.out.println("Menu tidak dikenali. Coba pesan di menu kami, kak!");
                System.out.println();
                pesan();
            }
        } catch (NumberFormatException e) {
            if (Arrays.asList(listmenuall).contains(pesanchar)) {
                for (int sweep = 0; sweep < listmenuall.length - 1; sweep++) {
                    if (pesanchar.equals(listmenuall[sweep])) {
                        //System.out.println(pesanchar + " ada di elemen" + sweep);
                        arraypesan = addmenu(arraypesan.length, arraypesan, sweep);

                        System.out.print("Mau berapa porsi? : ");
                        pesanjumlah = inputjumlah.nextInt();
                        System.out.println();
                        jumlahpesan = svjumlahmenu(jumlahpesan.length, jumlahpesan, pesanjumlah);
                        System.out.println(Arrays.toString(jumlahpesan));

                        //System.out.println(Arrays.toString(arraypesan));
                        //System.out.println(listmenuall[sweep]);
                        pesan();
                    }
                }
            } else if (pesanchar.equals("exit") || pesanchar.equals("keluar")) {
                System.out.println("Terima Kasih dan Selamat Datang Kembali! :)");
                return;
            } else if (pesanchar.equals("selesai") || pesanchar.contains("pesan")) {
                //proses disini
                cetakstruk();
            } else {
                System.out.println("Menu tidak dikenali. Coba pesan di menu kami, kak!");
                System.out.println();
                pesan();
            }
        }
    }

    public static void cetakstruk() {
        int i = 0;
        int totalsemuatemp = 0;
        int swminum = 0, hminum = 0;
        String minum = "";

        for (int j = 0; j < arraypesan.length; j++) {
            int jumlahtotal = jumlahpesan[j] * listhargaall[arraypesan[j]];
            totalsemuatemp = totalsemuatemp + jumlahtotal;
        }

        if (totalsemuatemp > 50000) {
            System.out.println("Selamat, Anda mendapatkan promo 'Beli satu minuman gratis satu'");
            for (int j = 0; j < menures.minuman.length; j++) {
                int k = j + 1;
                System.out.println(k + ". " + menures.minuman[j] + "..... Rp. " +
                        menures.hargaminum[j]);
            }
            System.out.println("0. Tidak, Terima Kasih");

            System.out.print("Pilihan Menu Minuman : ");

            Scanner inminum = new Scanner(System.in);
            swminum = inminum.nextInt();

        }

        System.out.println();
        do {
            System.out.println(listmenuall[arraypesan[i]] + "........."
                    + jumlahpesan[i] + " Porsi/Sajian");
            int hargamenu = jumlahpesan[i] * listhargaall[arraypesan[i]];
            System.out.println(jumlahpesan[i] + " x Rp. " + listhargaall[arraypesan[i]] +
                    " = Rp." + hargamenu);
            totalsemua = totalsemua + hargamenu;
            i++;
        } while (i < arraypesan.length);

        if (swminum > 0) {
            hminum = menures.hargaminum[swminum];
            minum = menures.minuman[swminum];
            System.out.println(minum + "...... 1 + 1 (Gratis) porsi/sajian");
            System.out.println("1 x Rp" + hminum + " + 1 Free");
        } else {
        }

        System.out.println();
        System.out.println("================================================");

        System.out.println("Total Harga : Rp. " + totalsemua);
    }
    //End Region

    //Region Manajemen
    public static void manajemen() {

    }
    //End Region
}