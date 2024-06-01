public class diskon extends menuitem {
    private double diskon;
    
    public diskon(String nama, double harga, double diskon){
        super(nama, harga, "Diskon");
        this.diskon = diskon;
    }

    //Metode tampilmenu (menuitem) untuk diskon
    @Override
    public void tampilMenu() {
        System.out.println(nama + " - Diskon Rp. " + diskon);
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }
}