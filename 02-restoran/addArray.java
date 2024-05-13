import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addArray {
    static MenuRes menures = new MenuRes();
    //tambah menu
    public static Integer[] addmenu(int n, Integer arr[], int x) {
        //menambahkan data ke array
        List<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(Main.arraypesan));
        arrlist.add(x);
        Main.arraypesan = arrlist.toArray(Main.arraypesan);
        return Main.arraypesan;
    }

    //tambah harga menu
    public static Integer[] svjumlahmenu(int n, Integer arr[], int x) {
        List<Integer> arrList = new ArrayList<Integer>(Arrays.asList(Main.jumlahpesan));
        arrList.add(x);
        Main.jumlahpesan = arrList.toArray(Main.jumlahpesan);
        return Main.jumlahpesan;
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

}
