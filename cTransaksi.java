package ProjectAkhir;

public class cTransaksi {
    //atribut transaksi
    private int idTransaksi;
    private cPesanan pesanan;
    private double totalHarga;
    private String tanggalTransaksi;

    // constructor
    public cTransaksi() {
        System.out.println("Constructor cTransaksi dipanggil");
    }

    // constructor dengan parameter
    public cTransaksi(int idTransaksi, cPesanan pesanan, double totalHarga, String tanggalTransaksi) {
        this.idTransaksi = idTransaksi;
        this.pesanan = pesanan;
        this.totalHarga = totalHarga;
        this.tanggalTransaksi = tanggalTransaksi;
        System.out.println("Objek Transaksi dengan ID " + this.idTransaksi + " berhasil dibuat");
    }

    // getter
    public int getIdTransaksi() { return this.idTransaksi; }
    public cPesanan getPesanan() { return this.pesanan; }
    public double getTotalHarga() { return this.totalHarga; }
    public String getTanggalTransaksi() { return this.tanggalTransaksi; }

    // setter
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public void setPesanan(cPesanan pesanan) { this.pesanan = pesanan; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }
    public void setTanggalTransaksi(String tanggalTransaksi) { this.tanggalTransaksi = tanggalTransaksi; }

    // toString
    public String toString() {
        return "ID Transaksi: " + this.idTransaksi + "\nPesanan: " + this.pesanan.toString() + "\nTotal Harga: " + this.totalHarga + "\nTanggal: " + this.tanggalTransaksi;
    }
}
