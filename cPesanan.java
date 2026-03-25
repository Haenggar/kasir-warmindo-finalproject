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
        System.out.println("Constructor cPesanan dipanggil");
        items = new ArrayList<>();
    }

    // constructor dengan parameter
    public cPesanan(int idPesanan, cPelanggan pembeli, ckasir kasir) {
        this.idPesanan = idPesanan;
        this.pembeli = pembeli;
        this.kasir = kasir;
        this.items = new ArrayList<>();
        System.out.println("Objek cPesanan dengan ID " + this.idPesanan + " berhasil dibuat");
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

    public double getTotal() {
        double total = 0;
        for (cItemPesanan item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Pesanan: ").append(this.idPesanan).append("\n");
        sb.append("Pembeli: ").append(this.pembeli.getNama()).append("\n");
        sb.append("Items:\n");
        for (cItemPesanan item : items) {
            sb.append("- ").append(item.toString()).append("\n");
        }
        sb.append("Total: ").append(this.getTotal());
        return sb.toString();
    }
}
