import java.util.ArrayList;

public class pesanan {
    private ArrayList<menuitem> pesananpel = new ArrayList<>();

    public void tambahpesan(menuitem item){
        pesananpel.add(item);
    }

    public double hitungtotal() {
        double total = 0;
        for (menuitem item : pesananpel) {
            if (item instanceof diskon) {
                diskon diskonitem = (diskon) item;
                total -= diskonitem.getDiskon();
            } else{
                total += item.getHarga();
            }
        }
        return total;
    }

    public void cetakStruk(){
        for (menuitem item : pesananpel){
            item.tampilMenu();
        }
    }

    public ArrayList<menuitem> getPesanPel(){
        return pesananpel;
    }
}
