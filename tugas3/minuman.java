public class minuman extends menuitem {
    private String jenisMinuman;

    public minuman(String nama, double harga, String jenisMinuman) {
        super(nama, harga, "minuman");
        this.jenisMinuman = jenisMinuman;
    }

    @Override
    public void tampilMenu(){
        System.out.println(nama + " ("+jenisMinuman+") - Rp. "+ harga);
    }

    public String getJenisminuman() {
        return jenisMinuman;
    }
    
}
