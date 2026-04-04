package ProjectAkhir;

public class cMenu {
    // atribut menu
    private int idMenu;
    private String namaMenu;
    private String kategoriMenu;
    private double hargaMenu;
    private int stokMenu;

    // constructor
    public cMenu() {
        System.out.println("Constructor cMenu dipanggil");
    }

    // constructor dengan parameter
    public cMenu(int idMenu, String namaMenu, String kategoriMenu, double hargaMenu, int stokMenu) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.kategoriMenu = kategoriMenu;
        this.hargaMenu = hargaMenu;
        this.stokMenu = stokMenu;
        System.out.println("Objek Menu dengan nama " + this.namaMenu + " berhasil dibuat");
    }

    // setter
    public void setHargaMenu(double hargaMenu) {this.hargaMenu = hargaMenu;}
    public void setStokMenu(int stokMenu) {this.stokMenu = stokMenu;}

    // getter
    public int getIdMenu() {return this.idMenu;}
    public String getNamaMenu() {return this.namaMenu;}
    public String getKategoriMenu() {return this.kategoriMenu;}
    public double getHargaMenu() {return this.hargaMenu;}
    public int getStokMenu() {return this.stokMenu;}

    // extra info for subclass
    public String getExtraInfo() {
        return "";
    }

    //query
    public String toString() {
        String result = "ID Menu : " + this.idMenu + "\nNama Menu : " + this.namaMenu + "\nKategori Menu : " + this.kategoriMenu + "\nHarga Menu : " + this.hargaMenu + "\nStok Menu : " + this.stokMenu;
        String extra = getExtraInfo();
        if (!extra.isEmpty()) {
            result += "\n" + extra;
        }
        return result;
    }
}
