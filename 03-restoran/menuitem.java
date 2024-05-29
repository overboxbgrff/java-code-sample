public abstract class menuitem {
    protected String nama;
    protected String kategori;
    protected double harga;
    protected double qua;

    public menuitem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public abstract void tampilMenu();

    public double getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }
}
