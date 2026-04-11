package ProjectAkhir;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class appWarmindo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<cMenu> daftarMenu = new ArrayList<>();
        ArrayList<cTransaksi> daftarTransaksi = new ArrayList<>();
        ArrayList<ckasir> daftarKasir = new ArrayList<>();
        int idPesananCounter = 1;
        int idTransaksiCounter = 1;
        int idPelangganCounter = 1;
        int idMenuCounter = 2;

        // Inisialisasi daftar kasir
        daftarKasir.add(new ckasir(1, "Agus", "1234"));
        daftarKasir.add(new ckasir(2, "Eko", "1234"));
        daftarKasir.add(new ckasir(3, "Moniq", "1234"));

        // Inisialisasi daftar menu
        daftarMenu.add(new cMenuMakanan(1, "Mie Goreng", 5000, 10, "Null"));
        daftarMenu.add(new cMenuMinuman(2, "Es Teh", 5000, 20, "Null"));

        System.out.println("Selamat datang di Program Kasir Warmindo");
        System.out.println("Silahkan login sebagai kasir..");

        ckasir kasirLoggedIn = null;
        boolean loggedIn = false;
        while (loggedIn == false) {
            System.out.print("ID Kasir : ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Password : ");
            String password = input.nextLine();

            for (int i = 0; i < daftarKasir.size(); i++) {
                if (daftarKasir.get(i).getId() == id && daftarKasir.get(i).getPassword().equals(password)) {
                    kasirLoggedIn = daftarKasir.get(i);
                    loggedIn = true;
                    break;
                }
            }
            if (loggedIn == false) {
                System.out.println("ID atau password salah. Coba lagi.");
            }
        }

        System.out.println("\nSelamat datang " + kasirLoggedIn.getNama() + " di Program Kasir Warmindo..");

        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Kelola Menu");
            System.out.println("3. Lihat Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih : ");
            int pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    // Buat Pesanan
                    System.out.println("\n--- BUAT PESANAN ---");
                    int idPelanggan = idPelangganCounter++;
                    System.out.println("ID Pelanggan : " + idPelanggan);
                    System.out.print("Nama Pelanggan : ");
                    String namaPelanggan = input.nextLine();
                    System.out.print("Apakah pelanggan member? (Y/N) : ");
                    String memberInput = input.nextLine();
                    boolean isMember = memberInput.equalsIgnoreCase("Y");
                    cPelanggan pelanggan = new cPelanggan(idPelanggan, namaPelanggan, isMember);

                    cPesanan pesanan = new cPesanan(idPesananCounter++, pelanggan, kasirLoggedIn);

                    boolean tambahItem = true;
                    while (tambahItem) {
                        System.out.println("Daftar Menu:");
                        if (daftarMenu.isEmpty()) {
                            System.out.println("Menu masih kosong. Tambahkan menu terlebih dahulu.");
                            break;
                        }
                        System.out.println("Makanan(1) / Minuman(2), selesai(0)");
                        System.out.print("Pilih kategori menu : ");
                        int pilihkategori = input.nextInt();
                        input.nextLine();
                        switch (pilihkategori) {
                            case 0:
                                tambahItem = false;
                                break;
                            case 1:
                                System.out.println("Daftar Makanan:");
                                for (int i = 0; i < daftarMenu.size(); i++) {
                                    if (daftarMenu.get(i).getKategoriMenu().equalsIgnoreCase("Makanan")) {
                                        cMenu m = daftarMenu.get(i);
                                        System.out.printf("%-2d | %-15s | Rp%-5.0f | %-4d | %-12s%n", m.getIdMenu(), m.getNamaMenu(), m.getHargaMenu(), m.getStokMenu(), m.getExtraInfo());
                                    }
                                }
                                System.out.print("Masukkan nama makanan yang ingin dipesan (atau ketik selesai untuk kembali): ");
                                String namaMakanan = input.nextLine();
                                if (namaMakanan.equalsIgnoreCase("selesai")) {
                                    break;
                                }
                                cMenu menuMakanan = cariMenuByNama(daftarMenu, "Makanan", namaMakanan);
                                if (menuMakanan == null) {
                                    System.out.println("Menu makanan tidak ditemukan.");
                                    break;
                                }
                                System.out.print("Masukkan jumlah pesanan : ");
                                int jumlahMakanan = input.nextInt();
                                input.nextLine();
                                if (jumlahMakanan <= 0) {
                                    System.out.println("Jumlah harus lebih dari 0.");
                                    break;
                                }
                                if (jumlahMakanan > menuMakanan.getStokMenu()) {
                                    System.out.println("Stok tidak cukup. Stok tersedia : " + menuMakanan.getStokMenu());
                                    break;
                                }
                                System.out.println("1. Tidak Pedas \n2. Pedas \n3. Sangat Pedas");
                                System.out.print("Masukkan level pedas : ");
                                int pilihlevel = input.nextInt();
                                input.nextLine();
                                switch (pilihlevel) {
                                    case 1:
                                        System.out.println("Tidak Pedas");
                                        cMenuMakanan makanan = (cMenuMakanan) menuMakanan;
                                        makanan.setLevelPedas("Tidak Pedas");
                                        break;
                                    case 2:
                                        System.out.println("Pedas");
                                        cMenuMakanan makanan2 = (cMenuMakanan) menuMakanan;
                                        makanan2.setLevelPedas("Pedas");
                                        break;
                                    case 3:
                                        System.out.println("Sangat Pedas");
                                        cMenuMakanan makanan3 = (cMenuMakanan) menuMakanan;
                                        makanan3.setLevelPedas("Sangat Pedas");
                                        break;
                                    default:
                                        System.out.println("Level pedas tidak valid. Default: Tidak Pedas.");
                                        break;
                                }
                                cItemPesanan itemMakanan = new cItemPesanan(menuMakanan, jumlahMakanan);
                                pesanan.addItem(itemMakanan);
                                menuMakanan.setStokMenu(menuMakanan.getStokMenu() - jumlahMakanan);
                                break;
                            case 2:
                                System.out.println("Daftar Minuman:");
                                for (int i = 0; i < daftarMenu.size(); i++) {
                                    if (daftarMenu.get(i).getKategoriMenu().equalsIgnoreCase("Minuman")) {
                                        cMenu m = daftarMenu.get(i);
                                        System.out.printf("%-2d | %-15s | Rp%-5.0f | %-4d | %-12s%n", m.getIdMenu(), m.getNamaMenu(), m.getHargaMenu(), m.getStokMenu(), m.getExtraInfo());
                                    }
                                }
                                System.out.print("Masukkan nama minuman yang ingin dipesan (atau ketik selesai untuk kembali): ");
                                String namaMinuman = input.nextLine();
                                if (namaMinuman.equalsIgnoreCase("selesai")) {
                                    break;
                                }
                                cMenu menuMinuman = cariMenuByNama(daftarMenu, "Minuman", namaMinuman);
                                if (menuMinuman == null) {
                                    System.out.println("Menu minuman tidak ditemukan.");
                                    break;
                                }
                                System.out.print("Masukkan jumlah pesanan : ");
                                int jumlahMinuman = input.nextInt();
                                input.nextLine();
                                if (jumlahMinuman <= 0) {
                                    System.out.println("Jumlah harus lebih dari 0.");
                                    break;
                                }
                                if (jumlahMinuman > menuMinuman.getStokMenu()) {
                                    System.out.println("Stok tidak cukup. Stok tersedia : " + menuMinuman.getStokMenu());
                                    break;
                                }
                                cItemPesanan itemMinuman = new cItemPesanan(menuMinuman, jumlahMinuman);
                                pesanan.addItem(itemMinuman);
                                menuMinuman.setStokMenu(menuMinuman.getStokMenu() - jumlahMinuman);
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }

                    if (pesanan.getItems().isEmpty()) {
                        System.out.println("Pesanan kosong, dibatalkan.");
                        break;
                    }

                    // Buat Transaksi
                    double total = pesanan.getTotal();
                    String tanggal = new Date().toString();
                    cTransaksi transaksi = new cTransaksi(idTransaksiCounter++, pesanan, total, tanggal);
                    daftarTransaksi.add(transaksi);

                    // Cetak Struk
                    System.out.println("\n=== STRUK PEMBAYARAN ===");
                    System.out.println(transaksi.toString());
                    System.out.println("=========================");

                    // Proses pembayaran
                    double bayar = 0;
                    while (true) {
                        System.out.print("Masukkan jumlah bayar: ");
                        bayar = input.nextDouble();
                        input.nextLine();
                        if (bayar < transaksi.getTotalSetelahDiskon()) {
                            System.out.println("Jumlah bayar kurang. Total yang harus dibayar: Rp" + transaksi.getTotalSetelahDiskon());
                        } else {
                            break;
                        }
                    }
                    double kembalian = bayar - transaksi.getTotalSetelahDiskon();
                    transaksi.setStatusPembayaran("Lunas");
                    System.out.println("Pembayaran berhasil. Kembalian: Rp" + kembalian);
                    System.out.println("Status pembayaran: " + transaksi.getStatusPembayaran());
                    break;

                case 2:
                    // Kelola Menu
                    boolean menuRunning = true;
                    while (menuRunning) {
                        System.out.println("\n--- KELOLA MENU ---");
                        System.out.println("1. Tambah Menu");
                        System.out.println("2. Lihat Menu");
                        System.out.println("3. Edit Menu");
                        System.out.println("4. Hapus Menu");
                        System.out.println("5. Kembali");
                        System.out.print("Pilih : ");
                        int pilihMenuKelola = input.nextInt();
                        input.nextLine();

                        switch (pilihMenuKelola) {
                            case 1:
                                System.out.println("Masukkan data menu baru");
                                int idMenu = idMenuCounter++;
                                System.out.println("ID Menu : " + idMenu);
                                System.out.print("Jenis Menu (1=Makanan, 2=Minuman) : ");
                                int jenisMenu = input.nextInt();
                                input.nextLine();
                                System.out.print("Nama Menu : ");
                                String namaMenu = input.nextLine();
                                System.out.print("Harga Menu : ");
                                double hargaMenu = input.nextDouble();
                                System.out.print("Stok Menu : ");
                                int stokMenu = input.nextInt();
                                input.nextLine();
                                cMenu menuBaru;
                                switch (jenisMenu) {
                                    case 1:
                                        String levelPedas = "Null";
                                        menuBaru = new cMenuMakanan(idMenu, namaMenu, hargaMenu, stokMenu, levelPedas);
                                        break;
                                    case 2:
                                        String jenisGula = "Null";
                                        menuBaru = new cMenuMinuman(idMenu, namaMenu, hargaMenu, stokMenu, jenisGula);
                                        break;
                                    default:
                                        System.out.println("Jenis menu tidak valid.");
                                        continue;
                                }
                                daftarMenu.add(menuBaru);
                                System.out.println("Menu berhasil ditambahkan.");
                                break;
                            case 2:
                                System.out.println("Daftar Menu:");
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Menu masih kosong.");
                                } else {
                                    System.out.printf("%-2s | %-15s | %-10s | %-7s | %-4s | %-12s%n", "ID", "Nama", "Jenis", "Harga", "Stok", "Info");
                                    System.out.println("---+-----------------+------------+---------+------+--------------");
                                    for (int i = 0; i < daftarMenu.size(); i++) {
                                        cMenu m = daftarMenu.get(i);
                                        System.out.printf("%-2d | %-15s | %-10s | Rp%-5.0f | %-4d | %-12s%n", m.getIdMenu(), m.getNamaMenu(), m.getKategoriMenu(), m.getHargaMenu(), m.getStokMenu(), m.getExtraInfo());
                                    }
                                }
                                break;
                            case 3:
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Menu masih kosong.");
                                    break;
                                }
                                System.out.println("Pilih menu untuk edit:");
                                for (int i = 0; i < daftarMenu.size(); i++) {
                                    System.out.println((i+1) + ". " + daftarMenu.get(i).getNamaMenu());
                                }
                                System.out.print("Pilih nomor : ");
                                int editIdx = input.nextInt() - 1;
                                if (editIdx < 0 || editIdx >= daftarMenu.size()) {
                                    System.out.println("Pilihan tidak valid.");
                                    break;
                                }
                                cMenu menuEdit = daftarMenu.get(editIdx);
                                System.out.print("Harga baru : ");
                                double hargaBaru = input.nextDouble();
                                System.out.print("Stok baru : ");
                                int stokBaru = input.nextInt();
                                menuEdit.setHargaMenu(hargaBaru);
                                menuEdit.setStokMenu(stokBaru);
                                System.out.println("Menu berhasil diupdate.");
                                break;
                            case 4:
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Menu masih kosong.");
                                    break;
                                }
                                System.out.println("Pilih menu untuk hapus:");
                                for (int i = 0; i < daftarMenu.size(); i++) {
                                    System.out.println((i+1) + ". " + daftarMenu.get(i).getNamaMenu());
                                }
                                System.out.print("Pilih nomor : ");
                                int hapusIdx = input.nextInt() - 1;
                                if (hapusIdx < 0 || hapusIdx >= daftarMenu.size()) {
                                    System.out.println("Pilihan tidak valid.");
                                    break;
                                }
                                System.out.print("Yakin hapus? (Y/N) : ");
                                String konfirmasi = input.next();
                                if (konfirmasi.equalsIgnoreCase("Y")) {
                                    daftarMenu.remove(hapusIdx);
                                    System.out.println("Menu berhasil dihapus.");
                                }
                                break;
                            case 5:
                                menuRunning = false;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }
                    break;

                case 3:
                    // Lihat Transaksi
                    System.out.println("\n--- DAFTAR TRANSAKSI ---");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi.");
                    } else {
                        System.out.printf("%-4s | %-10s | %-12s | %-8s | %-12s | %-10s%n", "ID", "Kasir", "Total Bayar", "Jumlah","Status",  "Tanggal");
                        System.out.println("----+------------+--------------+----------+--------------+-----------");
                        for (int i = 0; i < daftarTransaksi.size(); i++) {
                            cTransaksi t = daftarTransaksi.get(i);
                            System.out.printf("%-4d | %-10s | Rp%-11.0f | %-8d | %-12s | %-10s%n", t.getIdTransaksi(), t.getPesanan().getKasir().getNama(), t.getTotalSetelahDiskon(), t.getPesanan().getItems().size(), t.getStatusPembayaran(),  t.getTanggalTransaksi());
                        }
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem kasir Warmindo.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }

    private static cMenu cariMenuByNama(ArrayList<cMenu> daftarMenu, String kategori, String namaMenu) {
        for (cMenu menu : daftarMenu) {
            if (menu.getKategoriMenu().equalsIgnoreCase(kategori)
                    && menu.getNamaMenu().equalsIgnoreCase(namaMenu)) {
                return menu;
            }
        }
        return null;
    }
}
