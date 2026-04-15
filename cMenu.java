package ProjectAkhir;

import java.util.ArrayList;

public class cMenu {
    // atribut menu
    private int idMenu;
    private String namaMenu;
    private String kategoriMenu;
    private double hargaMenu;
    private int stokMenu;
    private int jumlahTerjual = 0;

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
    public int getJumlahTerjual() { return this.jumlahTerjual; }

    public void tambahPenjualan(int jumlah) {
        this.jumlahTerjual += jumlah;
    }

    public static cMenu cariMenuByNama(ArrayList<cMenu> daftarMenu, String kategori, String namaMenu) {
        for (int i = 0; i < daftarMenu.size(); i++) {
            if (daftarMenu.get(i).getKategoriMenu().equalsIgnoreCase(kategori)
                && daftarMenu.get(i).getNamaMenu().equalsIgnoreCase(namaMenu)) {
                return daftarMenu.get(i);
            }
        }
        return null;
    }

    public static cMenu cariMenuById(ArrayList<cMenu> daftarMenu, int idMenu) {
        for (int i = 0; i < daftarMenu.size(); i++) {
            if (daftarMenu.get(i).getIdMenu() == idMenu) {
                return daftarMenu.get(i);
            }
        }
        return null;
    }

    public static void tampilkanMenuKategori(ArrayList<cMenu> daftarMenu, String kategori) {
        boolean found = false;
        for (int i = 0; i < daftarMenu.size(); i++) {
            if (daftarMenu.get(i).getKategoriMenu().equalsIgnoreCase(kategori)) {
                found = true;
                System.out.printf("%-2d | %-15s | Rp%-5.0f | %-4d | %-12s%n",
                daftarMenu.get(i).getIdMenu(), daftarMenu.get(i).getNamaMenu(), daftarMenu.get(i).getHargaMenu(), daftarMenu.get(i).getStokMenu(), daftarMenu.get(i).getExtraInfo());
            }
        }
        if (!found) {
            System.out.println("Tidak ada menu " + kategori + " tersedia.");
        }
    }

    public void kurangiStok(int jumlah) {
        this.stokMenu = Math.max(0, this.stokMenu - jumlah);
    }

    public static void hapusId(ArrayList<cMenu> daftarMenu, int idMenu) {
        for (int i = 0; i < daftarMenu.size(); i++) {
            if (daftarMenu.get(i).getIdMenu() == idMenu) {
                daftarMenu.remove(i);
                return;
            }
        System.out.println("Menu dengan ID " + idMenu + " tidak ditemukan.");
        }
        
    }


    public String getExtraInfo() {
        return "";
    }

    public static void Tampilmenu(ArrayList<cMenu> daftarMenu) {
        System.out.printf("%-2s | %-15s | %-10s | %-7s | %-4s | %-12s%n", "ID", "Nama", "Jenis", "Harga", "Stok", "Info");
        System.out.println("---+-----------------+------------+---------+------+--------------");
        for (int i = 0; i < daftarMenu.size(); i++) {
            cMenu m = daftarMenu.get(i);
            System.out.printf("%-2d | %-15s | %-10s | Rp%-5.0f | %-4d | %-12s%n", m.getIdMenu(), m.getNamaMenu(), m.getKategoriMenu(), m.getHargaMenu(), m.getStokMenu(), m.getExtraInfo());
        }
        
    }
}
