package ProjectAkhir;

import java.util.Scanner;

public class appWarmindo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat datang di Program Kasir Warmindo");
        System.out.println("Silahkan masukkan data kasir terlebih dahulu..");
        System.out.print("ID Kasir : ");
        int id = input.nextInt();
        System.out.print("Nama Kasir : ");
        String nama = input.nextLine();

        ckasir kasir1 = new ckasir(id, nama);
        System.out.println("\n Selamat datang " + kasir1.getNama() + " di Program Kasir Warmindo..");
        System.out.println("1. Pesanan \n 2. Tambah Menu \n 3. Keluar");
        System.out.println("Pilih :");
        int pilih1 = input.nextInt();
        switch (pilih1) {
            case 1 :
                cPesanan pesanan = new cPesanan();
            break;
            case 2 :
                System.out.println("1. Tambah Menu \n 2. Lihat Menu \n 3. Edit Menu \n 4. Hapus Menu \n 5. Kembali");
                System.out.println("Pilih :");
                cMenu menuBaru = null;
                int pilih2 = input.nextInt();
                switch (pilih2) {
                    case 1 :
                        System.out.println("Masukkan data menu baru");
                        System.out.println("ID Menu : ");
                        int idMenu = input.nextInt();
                        System.out.println("Nama Menu : ");
                        String namaMenu = input.next();
                        System.out.println("Kategori Menu : ");
                        String kategoriMenu = input.next();
                        System.out.println("Harga Menu : ");
                        double hargaMenu = input.nextDouble();
                        System.out.println("Stok Menu : ");
                        int stokMenu = input.nextInt();
                        menuBaru = new cMenu(idMenu, namaMenu, kategoriMenu, hargaMenu, stokMenu);
                    break;
                    case 2 :
                        System.out.println("Daftar Menu : ");
                        if (menuBaru.getNamaMenu() != null) {
                            menuBaru.ToString();
                        } else {
                            System.out.println("Menu masih kosong..");
                        }
                    break;
                    case 3 :
                        if (menuBaru.getNamaMenu() != null) {
                            System.out.println("Masukkan harga baru : ");
                            double hargaBaru = input.nextDouble();
                            menuBaru.setHargaMenu(hargaBaru);
                            System.out.println("Masukkan stok baru : ");
                            int stokBaru = input.nextInt();
                            menuBaru.setStokMenu(stokBaru);
                            System.out.println("Data menu berhasil di update..");
                        } else {
                            System.out.println("Menu masih kosong..");
                        }
                    break;
                    case 4 :
                        System.out.println("Yakin ingin menghapus data menu? (Y/N) : ");
                        String hapus = input.next();
                        if (hapus.equalsIgnoreCase("Y")) {
                            menuBaru = null;
                            System.out.println("Data menu berhasil di hapus..");
                        } else {
                            System.out.println("Data menu gagal di hapus..");
                        }
                    break;
                    case 5 :
                        System.out.println("Kembali ke menu utama");
                    break;
                }
            break;
        }
    }
}
