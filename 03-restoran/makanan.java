public class makanan extends menuitem {
    private String jenisMakanan;

    public makanan(String nama, double harga, String jenisMakanan) {
        super(nama, harga, "Makanan");
        this.jenisMakanan = jenisMakanan;
    }

    //Metode tampilmenu (menuitem) untuk makanan
    @Override
    public void tampilMenu(){
        System.out.println(nama + " ("+jenisMakanan+") - Rp. "+ harga);
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }
}
