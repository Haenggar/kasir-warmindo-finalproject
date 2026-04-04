package ProjectAkhir;

public class cPelanggan {
    //atribut pembeli
    private int id;
    private String nama;

    //constructor
    public cPelanggan() {
        System.out.println("constructor cPembeli dipanggil");
    }

    //constructor dengan parameter
    public cPelanggan(int id, String nama) {
        this.id = id;
        this.nama = nama;
        System.out.println("objek Pembeli dengan nama " + this.nama + " berhasil dibuat");
    }

    //setter
    public void setNama(String nama) {this.nama = nama;}
    
    //getter
    public int getId() {return this.id;}
    public String getNama() {return this.nama;}

    //query
    public String toString() {
        return "ID Pembeli : " + this.id + "\nNama Pembeli : " + this.nama;
    }
}
