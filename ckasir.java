package ProjectAkhir;

public class ckasir {
    //atribut kasir
    private int id;
    private String nama;
    private String password;

    //constructor
    public ckasir() {
        System.out.println("Object Kasir berhasil dibuat..");
    }

    //constructor dengan parameter
    public ckasir(int id, String nama, String password) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        System.out.println("Object Kasir dengan nama " + this.nama + " berhasil dibuat..");
    }

    //Getter
    public int getId() {return this.id;}
    public String getNama() {return this.nama;}
    public String getPassword() {return this.password;}

    //query
    public String toString() {
        return "ID Kasir : " + this.id + "\nNama Kasir : " + this.nama;
    } 
}
