package ProjectAkhir;

public class cPelanggan {
    //atribut pembeli
    private int id;
    private String nama;
    private boolean isMember;

    //constructor
    public cPelanggan() {
        System.out.println("constructor cPembeli dipanggil");
    }

    //constructor dengan parameter
    public cPelanggan(int id, String nama) {
        this.id = id;
        this.nama = nama;
        this.isMember = false; // default bukan member
        System.out.println("objek Pembeli dengan nama " + this.nama + " berhasil dibuat");
    }

    //constructor dengan parameter termasuk member
    public cPelanggan(int id, String nama, boolean isMember) {
        this.id = id;
        this.nama = nama;
        this.isMember = isMember;
        System.out.println("objek Pembeli dengan nama " + this.nama + " berhasil dibuat");
    }

    //setter
    public void setNama(String nama) {this.nama = nama;}
    public void setMember(boolean isMember) {this.isMember = isMember;}
    
    //getter
    public int getId() {return this.id;}
    public String getNama() {return this.nama;}
    public boolean isMember() {return this.isMember;}

    //query
    public String toString() {
        return "ID Pembeli : " + this.id + "\nNama Pembeli : " + this.nama + "\nMember : " + (this.isMember ? "Ya" : "Tidak");
    }
}
