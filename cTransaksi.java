package ProjectAkhir;

public class cTransaksi {
    //atribut transaksi
    private int idTransaksi;
    private cPesanan pesanan;
    private double totalHarga;
    private double diskon;
    private double totalSetelahDiskon;
    private String tanggalTransaksi;
    private String statusPembayaran;

    // constructor
    public cTransaksi() {
        System.out.println("Constructor cTransaksi dipanggil");
        this.statusPembayaran = "Belum Lunas";
    }

    // constructor dengan parameter
    public cTransaksi(int idTransaksi, cPesanan pesanan, double totalHarga, String tanggalTransaksi) {
        this.idTransaksi = idTransaksi;
        this.pesanan = pesanan;
        this.totalHarga = totalHarga;
        this.diskon = pesanan.getPembeli().isMember() ? totalHarga * 0.1 : 0; // diskon 10% untuk member
        this.totalSetelahDiskon = totalHarga - this.diskon;
        this.tanggalTransaksi = tanggalTransaksi;
        this.statusPembayaran = "Belum Lunas";
        System.out.println("Objek Transaksi dengan ID " + this.idTransaksi + " berhasil dibuat");
    }

    // getter
    public String getStatusPembayaran() { return this.statusPembayaran; }
    public int getIdTransaksi() { return this.idTransaksi; }
    public cPesanan getPesanan() { return this.pesanan; }
    public double getTotalHarga() { return this.totalHarga; }
    public double getDiskon() { return this.diskon; }
    public double getTotalSetelahDiskon() { return this.totalSetelahDiskon; }
    public String getTanggalTransaksi() { return this.tanggalTransaksi; }

    // setter
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public void setPesanan(cPesanan pesanan) { this.pesanan = pesanan; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }
    public void setDiskon(double diskon) { this.diskon = diskon; }
    public void setTotalSetelahDiskon(double totalSetelahDiskon) { this.totalSetelahDiskon = totalSetelahDiskon; }
    public void setTanggalTransaksi(String tanggalTransaksi) { this.tanggalTransaksi = tanggalTransaksi; }
    public void setStatusPembayaran(String statusPembayaran) { this.statusPembayaran = statusPembayaran; }

    // toString
    public String toString() {
        String result = "ID Transaksi: " + this.idTransaksi + "\nPesanan: " + this.pesanan.toString() + "\nTotal Harga: " + this.totalHarga;
        if (this.diskon > 0) {
            result += "\nDiskon Member: " + this.diskon + "\nTotal Setelah Diskon: " + this.totalSetelahDiskon;
        }
        result += "\nTanggal: " + this.tanggalTransaksi;
        result += "\nStatus Pembayaran: " + this.statusPembayaran;
        return result;
    }
}
