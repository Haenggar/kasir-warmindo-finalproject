package ProjectAkhir;

import java.util.ArrayList;

public class cPesanan {
    //atribut pesanan
    private int idPesanan;
    private cPelanggan pembeli;
    private ArrayList<cItemPesanan> items;
    private ckasir kasir;

    // constructor
    public cPesanan() {
        System.out.println("Constructor Pesanan dipanggil");
        items = new ArrayList<>();
    }

    // constructor dengan parameter
    public cPesanan(int idPesanan, cPelanggan pembeli, ckasir kasir) {
        this.idPesanan = idPesanan;
        this.pembeli = pembeli;
        this.kasir = kasir;
        this.items = new ArrayList<>();
        System.out.println("Objek Pesanan dengan ID " + this.idPesanan + " berhasil dibuat");
    }

    // getter
    public int getIdPesanan() { return this.idPesanan; }
    public cPelanggan getPembeli() { return this.pembeli; }
    public ArrayList<cItemPesanan> getItems() { return this.items; }
    public ckasir getKasir() { return this.kasir; }

    // setter
    public void setIdPesanan(int idPesanan) { this.idPesanan = idPesanan; }
    public void setPembeli(cPelanggan pembeli) { this.pembeli = pembeli; }
    public void setKasir(ckasir kasir) { this.kasir = kasir; }

    // method
    public void addItem(cItemPesanan item) {
        items.add(item);
    }

    public void tambahItem(cMenu menu, int jumlah) {
        if (menu.getStokMenu() < jumlah) {
            System.out.println("Stok " + menu.getNamaMenu() + " tidak cukup. Stok tersedia: " + menu.getStokMenu());
            return;
        }

        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        cItemPesanan item = new cItemPesanan(menu, jumlah);
        addItem(item);
        menu.kurangiStok(jumlah);

        System.out.println("Berhasil menambahkan " + jumlah + " " + menu.getNamaMenu() + " ke keranjang.");
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getSubtotal();
        }
        return total;
    }

    public void hapusItem(int nomor) {
        int indeks = nomor - 1; // Konversi ke indeks ArrayList (dimulai dari 0)
        
        if (indeks >= 0 && indeks < items.size()) {
            cItemPesanan itemDihapus = items.get(indeks);
            
            // 1. Ambil informasi menu dan jumlah untuk mengembalikan stok
            cMenu menu = itemDihapus.getMenu();
            int jumlah = itemDihapus.getJumlah();
            
            // 2. Kembalikan stok menu (tambah kembali karena batal dipesan)
            menu.setStokMenu(menu.getStokMenu() + jumlah);
            
            // 3. Hapus dari ArrayList
            String namaMenu = menu.getNamaMenu();
            items.remove(indeks);
            
            System.out.println("Berhasil menghapus " + namaMenu + " dari keranjang.");
        } else {
            System.out.println("Gagal menghapus: Nomor item tidak ditemukan.");
        }
    }

    public void tampilkanKeranjang() {
        if (items.isEmpty()) {
            System.out.println("Keranjang masih kosong.");
            return;
        }
        System.out.println("Isi keranjang sementara:");
        for (int i = 0; i < items.size(); i++) {
            cItemPesanan item = items.get(i);
            System.out.printf("%d. %s x%d = Rp%.0f%n", i + 1, item.getMenu().getNamaMenu(), item.getJumlah(), item.getSubtotal());
        }
        System.out.println("Total sementara: Rp" + getTotal());
    }

    // toString
    public String toString() {
        System.out.println("ID Pesanan: " + this.idPesanan);
        System.out.println("Pembeli: " + this.pembeli.getNama());
        System.out.println("Items:");
        for ( int i = 0; i < items.size(); i++) {
            System.out.println("- " + items.get(i).toString());
        }
        System.out.println("Total: " + this.getTotal());
        return "";
    }
}
