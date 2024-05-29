import java.io.*;
import java.util.ArrayList;

public class IOFile {

    // menyimpan daftar menu ke file
    public static void simpanmenu(String path, menu menu) {
        try (PrintWriter writer = new PrintWriter(path + ".txt")) {
            for (menuitem item : menu.getDaftarMenu()) {
                writer.println(item.getClass().getSimpleName() + " | " +
                        item.getNama() + " | " +
                        item.getHarga() + " | " +
                        (item instanceof makanan ? ((makanan) item).getJenisMakanan()
                                : (item instanceof minuman ? ((minuman) item).getJenisminuman()
                                        : (item instanceof diskon ? String.valueOf(((diskon) item).getDiskon())
                                                : ""))));
            }
            System.out.println("Daftar menu berhasil tersimpan. Lokasi :" + path + ".txt");
        } catch (IOException e) {
            System.out.println("Gagal Menyimpan daftar menu ke file: " + path + ".txt");
            e.printStackTrace();
        }
    }

    // load file menjadi daftar menu
    public static menu loadmenu(String path) {
        menu Menu = new menu();
        try (BufferedReader rd = new BufferedReader(new FileReader(path + ".txt"))) {
            String line;
            while ((line = rd.readLine()) != null) {
                String[] data = line.split(" \\| ");
                if (data.length >= 4) {
                    String kategori = data[0];
                    String nama = data[1];
                    double harga = Double.parseDouble(data[2]);

                    switch (kategori) {
                        case "Makanan":
                            Menu.tambahMenu(new makanan(nama, harga, data[3]));
                            break;
                        case "Minuman":
                            Menu.tambahMenu(new minuman(nama, harga, data[3]));
                            break;
                        case "Diskon":
                            Menu.tambahMenu(new diskon(nama, harga, Double.parseDouble(data[3])));

                        default:
                            System.out.println("Kategori Tidak Dikenali");
                            break;
                    }
                }
            }
            System.out.println("Daftar Berhasil Dimuat. Lokasi File: " + path);
        } catch (IOException e) {
            System.out.println("Gagal memuat file: " + path);
            e.printStackTrace();
        }
        return Menu;
    }

    // ekspor struk pesanan ke dalam file
    public static void exportstruk(String path, pesanan Pesanan) {
        try (PrintWriter writer = new PrintWriter(path + ".txt")) {
            writer.println("++++++++++Struk Pesanan++++++++++");
            for (menuitem item : Pesanan.getPesanPel()) {
                writer.println(item.getClass().getSimpleName() + " | " +
                        item.getNama() + " | " +
                        item.getHarga() + " | " +
                        (item instanceof makanan ? ((makanan) item).getJenisMakanan()
                                : (item instanceof minuman ? ((minuman) item).getJenisminuman()
                                        : (item instanceof diskon ? String.valueOf(((diskon) item).getDiskon())
                                                : ""))));

            }
            writer.println("++++++++++++++++++++++++++++++++");
            writer.println("Total: Rp " + Pesanan.hitungtotal());
            writer.println("++++++++++++++++++++++++++++++++");
            System.out.println("Struk pesanan berhasil diekspor ke file: " + path);

        } catch (IOException e) {
            System.out.println("Gagal mengekspor struk pesanan ke file: " + path);
            e.printStackTrace();
        }
    }
}
