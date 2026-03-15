package ProjectAkhir;

public class appWarmindo {
    public static void main(String[] args) {
        //membuat objek pembeli
        cPelanggan pembeli = new cPelanggan();
        cPelanggan pembeli1 = new cPelanggan(1, "Hinggar Ramadhana");
        
        //membuat objek kasir
        ckasir kasir1 = new ckasir(1, "Rizky");

        //membuat objek barang
        cMenu menu = new cMenu();
        cMenu menu1 = new cMenu(123, "Indomie Ayam Bawang", "Mie Rebus", 5000, 2);

    }
}
