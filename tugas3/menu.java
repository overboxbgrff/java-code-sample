import java.util.ArrayList;

public class menu {
    private ArrayList<menuitem> daftarmenu = new ArrayList<>();

    public void tambahMenu(menuitem item) {
        daftarmenu.add(item);
    }

    public void tampilMenuRes() {
        System.out.println("++++++++++ DAFTAR MENU ++++++++++");
        for (menuitem item : daftarmenu) {
            item.tampilMenu();
        }
        System.out.println("+++++++++++++++++++++++++++++++++");
    }

    public menuitem cariItem(String nama) {
        for (menuitem item : daftarmenu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<menuitem> getDaftarMenu() {
        return daftarmenu;
    }
}
