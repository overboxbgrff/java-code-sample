/*
Author : Danang Priyombodo
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Variable
    static MenuRes menures = new MenuRes();


    //variable pesan
    static String pesanchar = "";
    static int pesanjumlah = 0;
    static Integer[] arraypesan = {};
    static Integer[] jumlahpesan = {};
    static int diskon, biaya_res, biaya_pel;

    //convert Integer to int
    static int[] chargamakan = Arrays.stream(menures.hargamakan).mapToInt(Integer::intValue).toArray();
    static int[] chargaminum = Arrays.stream(menures.hargaminum).mapToInt(Integer::intValue).toArray();


    static int totalawal = 0;
    static int finaltotal = 0;

    //variable menu
    static String[] listmenuall; // untuk list semua menu
    static int[] listhargaall; //untuk list semua harga menu

    //Variable bagian manajemen


    public static void main(String[] args) {
        try {
            allmenu();
        } catch (ArrayStoreException e){
            System.out.println(e);
        }

        main_menu();
    }

    public static void main_menu() {
        int pick_menu;
        Scanner main_menu = new Scanner(System.in);
        System.out.println(".....................................................");
        System.out.println("Restoran Wawan - Main Menu");
        System.out.println(".....................................................");
        System.out.println("1. Untuk Manajemen");
        System.out.println("2. Untuk Pelanggan");
        System.out.println("3. Keluar");
        System.out.print("Pilihan: ");
        pick_menu = main_menu.nextInt();
        switch (pick_menu) {
            case 1:
                clearscreen();
                System.out.println(".....................................................");
                System.out.println("Restoran Wawan - Manajemen Menu");
                System.out.println(".....................................................");
                manajemen();
                break;
            case 2:
                clearscreen();
                System.out.println(".....................................................");
                System.out.println("Restoran Wawan - Pemesanan Makanan");
                System.out.println(".....................................................");
                pesan();
                break;
            case 3:
                return;
        }
    }

    public static void clearscreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    //Region "Pesan Menu"
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

    public static void tampilmenu() {
        //print makanan
        System.out.println("Makanan:");
        for (int makan = 0; makan < menures.makanan.length; makan++) {
            System.out.print("\t");
            System.out.println(1 + makan + ") " +
                    menures.makanan[makan] + " ..... Rp. " +
                    menures.hargamakan[makan]);
        }
        //print minuman
        System.out.println("Minuman");
        for (int minum = 0; minum < menures.minuman.length; minum++) {
            System.out.print("\t");
            System.out.println(menures.makanan.length + 1 + minum + ") " +
                    menures.minuman[minum] + " ..... Rp. " +
                    menures.hargaminum[minum]);
        }
    }

    public static void allmenu() {
        //mengkombinasikan menu makanan dan minuman beserta harganya.
        listmenuall = new String[menures.makanan.length + menures.minuman.length];
        System.arraycopy(menures.makanan, 0, listmenuall, 0, menures.makanan.length);
        System.arraycopy(menures.minuman, 0, listmenuall, menures.makanan.length, menures.minuman.length);

        listhargaall = new int[chargamakan.length + chargaminum.length];
        System.arraycopy(chargamakan, 0, listhargaall, 0, chargamakan.length);
        System.arraycopy(chargaminum, 0, listhargaall, chargamakan.length, chargaminum.length);

        /*for (int makan = 0; makan < listmenuall.length; makan++) {
            System.out.println(1 + makan + ". " +
                    listmenuall[makan] + " ..... Rp. " +
                    listhargaall[makan]);
        }
        System.out.println();
        System.out.println("98. Pesan");
        System.out.println("99. Keluar");*/
    }

    public static void pesan() {
        tampilmenu();
        System.out.println();
        System.out.println("98. Pesan");
        System.out.println("99. Keluar");
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
                pesan();

                //hanya kepentingan testing!!
                //System.out.println(Arrays.toString(jumlahpesan));
                //System.out.println(Arrays.toString(arraypesan));
                //System.out.println(listmenuall[Integer.parseInt(pesanchar) - 1]);
            } else if (Integer.parseInt(pesanchar) == 98) {
                //pesan
                cetakstruk();
            } else if (Integer.parseInt(pesanchar) == 99) {
                //Keluar
                System.out.println("Terima Kasih dan Selamat Datang Kembali! :)");
                clearscreen();
                main_menu();
            } else {
                System.out.println("Menu tidak dikenali. Coba pesan di menu kami, kak!");
                System.out.println();
                pesan();
            }
        } catch (NumberFormatException e) {
            if (Arrays.asList(listmenuall).contains(pesanchar)) {
                for (int sweep = 0; sweep < listmenuall.length - 1; sweep++) {
                    if (pesanchar.equals(listmenuall[sweep])) {
                        arraypesan = addmenu(arraypesan.length, arraypesan, sweep);
                        System.out.print("Mau berapa porsi/sajian? : ");
                        pesanjumlah = inputjumlah.nextInt();
                        System.out.println();
                        jumlahpesan = svjumlahmenu(jumlahpesan.length, jumlahpesan, pesanjumlah);
                        pesan();

                        //hanya kepentingan testing!!
                        //System.out.println(pesanchar + " ada di elemen" + sweep);
                        //System.out.println(Arrays.toString(arraypesan));
                        //System.out.println(Arrays.toString(jumlahpesan));
                        //System.out.println(listmenuall[sweep]);
                    }
                }
            } else if (pesanchar.equals("exit") || pesanchar.equals("keluar")) {
                System.out.println("Terima Kasih dan Selamat Datang Kembali! :)");
                clearscreen();
                main_menu();
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
            totalawal = totalawal + hargamenu;
            i++;
        } while (i < arraypesan.length);

        if (swminum > 0) {
            swminum = swminum - 1;
            hminum = menures.hargaminum[swminum];
            minum = menures.minuman[swminum];
            System.out.println(minum + "...... 1 + 1 (Gratis) porsi/sajian");
            System.out.println("1 x Rp" + hminum + " + 1 Free");
        } else {
        }

        int init_total = totalawal + hminum;
        biaya_res = 10 * init_total / 100;
        biaya_pel = 5 * init_total / 100;

        System.out.println();
        System.out.println("================================================");

        System.out.println("Total Harga : Rp. " + totalawal);
        if (init_total > 100000) {
            diskon = 10 * init_total / 100;
            System.out.println("Diskon 10% : Rp. " + diskon);
        } else {
            diskon = 0;
        }
        finaltotal = init_total - diskon + biaya_res + biaya_pel;
        System.out.println("Pajak Restoran (10%): Rp. " + biaya_res);
        System.out.println("Biaya Pelayanan (5%): Rp. " + biaya_pel);
        System.out.println("Total Keseluruhan : Rp. " + finaltotal);

    }
    //End Region

    //Region Manajemen
    public static void manajemen() {
        int sman_menu = 0;
        Scanner man_mainmenu = new Scanner(System.in);
        tampilmenu();
        System.out.println();
        System.out.println(".....................................................");
        System.out.println("1. Tambah Menu");
        System.out.println("2. Edit Harga");
        System.out.println("3. Hapus Menu");
        System.out.println();
        System.out.println("99. Selesai");

        System.out.print("Pilihan: ");
        sman_menu = man_mainmenu.nextInt();
        switch (sman_menu) {
            case 1:
                tambahmenu();
                break;
            case 2:
                //editmenu();
                break;
            case 3:
                //hapusmenu();
                break;
            case 99:
                clearscreen();
                main_menu();
        }
    }

    public static void tambahmenu() {
        String menu = "", jenismenu = "", confirm="";
        int hargamenu = 0;
        Scanner smenu = new Scanner(System.in),
                sjenismenu = new Scanner(System.in),
                shargamenu = new Scanner(System.in),
                sconfirm = new Scanner(System.in);

        System.out.print("Menu apa yag ingin di tambahkan?: ");
        menu = smenu.nextLine();
        System.out.print("Makanan / Minuman?: ");
        jenismenu = sjenismenu.nextLine();
        System.out.print("Harga?: Rp. ");
        hargamenu = shargamenu.nextInt();
        System.out.print("Apakah anda yakin? (Y/N): ");
        confirm = sconfirm.nextLine();
        System.out.println("OK, Menu akan ditambahkan...");
        if (confirm.equals("Y")||confirm.equals("y")||confirm.equals("ya")||confirm.equals("yes")){
            if (jenismenu.contains("makan")||jenismenu.contains("makanan")){
                menures.makanan = addmakan_man(menures.makanan.length, menures.makanan, menu);
                menures.hargamakan = addhmakan_man(menures.hargamakan.length, menures.hargamakan, hargamenu);
                System.out.println("Selesai");
                System.out.println();
                manajemen();
            }else if (jenismenu.contains("minum")||jenismenu.contains("minuman")){
                menures.minuman = addmakan_man(menures.minuman.length, menures.minuman, menu);
                menures.hargaminum = addhmakan_man(menures.hargaminum.length, menures.hargaminum, hargamenu);
                System.out.println("Selesai");
                System.out.println();
                manajemen();
            }
        } else if (confirm.equals("N")||confirm.equals("n")||confirm.equals("no")){
            System.out.println("Ok...kembali ke menu utama manajemen...");
            System.out.println();
            manajemen();
        }

    }

    public static String[] addmakan_man(int n, String arr[], String x) {
        //menambahkan data ke array
        List<String> arrlist = new ArrayList<String>(Arrays.asList(menures.makanan));
        arrlist.add(x);
        menures.makanan = arrlist.toArray(menures.makanan);
        return menures.makanan;
    }

    public static Integer[] addhmakan_man(int n, Integer arr[], int x) {
        //menambahkan data ke array
        List<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(menures.hargamakan));
        arrlist.add(x);
        menures.hargamakan = arrlist.toArray(menures.hargamakan);
        return menures.hargamakan;
    }

    public static String[] addminum_man(int n, String arr[], String x) {
        //menambahkan data ke array
        List<String> arrlist = new ArrayList<String>(Arrays.asList(menures.minuman));
        arrlist.add(x);
        menures.minuman = arrlist.toArray(menures.minuman);
        return menures.minuman;
    }

    public static Integer[] addhminum_man(int n, int arr[], int x) {
        //menambahkan data ke array
        List<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(menures.hargaminum));
        arrlist.add(x);
        menures.hargaminum = arrlist.toArray(menures.hargaminum);
        return menures.hargaminum;
    }

    public static void editmenu() {
        System.out.println("Menu apa yang ingin di ubah harganya?: ");

        System.out.println("Makanan / Minuman?: ");

        System.out.println("Harga barunya?: ");

        System.out.println("Apakah anda yakin? (Y/N): ");

        System.out.println("OK, Harga menu akan diubah...");

        manajemen();
    }

    public static void hapusmenu() {
        System.out.println("Menu apa yang ingin di ubah harganya?: ");

        System.out.println("Makanan / Minuman?: ");

        System.out.println("Harga barunya?: ");

        System.out.println("Apakah anda yakin? (Y/N): ");

        System.out.println("OK, Harga menu akan diubah...");

        manajemen();
    }
    //End Region
}