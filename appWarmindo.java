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
        int idMenuCounter = 3;

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
                        System.out.println("\n--- KERANJANG ---");
                        pesanan.tampilkanKeranjang();

                        if (daftarMenu.isEmpty()) {
                            System.out.println("Menu masih kosong. Tambahkan menu terlebih dahulu.");
                            break;
                        }

                        System.out.println("\n1. Tambah Makanan");
                        System.out.println("2. Tambah Minuman");
                        System.out.println("3. Hapus Item Keranjang");
                        System.out.println("0. Selesai");
                        System.out.print("Pilih tindakan : ");
                        int pilihkategori = input.nextInt();
                        input.nextLine();
                        switch (pilihkategori) {
                            case 0:
                                tambahItem = false;
                                break;
                            case 1:
                                System.out.println("Daftar Makanan:");
                                cMenu.tampilkanMenuKategori(daftarMenu, "Makanan");
                                System.out.print("Masukkan nama makanan yang ingin dipesan (atau ketik selesai untuk kembali): ");
                                String namaMakanan = input.nextLine();
                                if (namaMakanan.equalsIgnoreCase("selesai")) {
                                    break;
                                }
                                cMenu menuMakanan = cMenu.cariMenuByNama(daftarMenu, "Makanan", namaMakanan);
                                if (menuMakanan == null) {
                                }

                                System.out.print("Masukkan jumlah pesanan : ");
                                int jumlahMakanan = input.nextInt();
                                input.nextLine();   
                                pesanan.tambahItem(menuMakanan, jumlahMakanan);

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
                                pesanan.tambahItem(menuMakanan, jumlahMakanan);
                                System.out.println("Item ditambahkan ke keranjang sementara.");
                                break;
                            case 2:
                                System.out.println("Daftar Minuman:");
                                cMenu.tampilkanMenuKategori(daftarMenu, "Minuman");
                                System.out.print("Masukkan nama minuman yang ingin dipesan (atau ketik selesai untuk kembali): ");
                                String namaMinuman = input.nextLine();
                                if (namaMinuman.equalsIgnoreCase("selesai")) {
                                    break;
                                }
                                cMenu menuMinuman = cMenu.cariMenuByNama(daftarMenu, "Minuman", namaMinuman);
                                if (menuMinuman == null) {
                                    System.out.println("Menu minuman tidak ditemukan.");
                                    break;
                                }
                                System.out.print("Masukkan jumlah pesanan : ");
                                int jumlahMinuman = input.nextInt();
                                input.nextLine();
                                pesanan.tambahItem(menuMinuman, jumlahMinuman);
                                System.out.println("1. Tanpa Gula \n2. Dengan Gula");
                                System.out.print("Masukkan jenis gula : ");
                                int pilihGula = input.nextInt();
                                input.nextLine();
                                switch (pilihGula) {
                                    case 1:
                                        System.out.println("Tanpa Gula");
                                        cMenuMinuman minuman = (cMenuMinuman) menuMinuman;
                                        minuman.setGula("Tanpa Gula");
                                        break;
                                    case 2:
                                        System.out.println("Dengan Gula");
                                        cMenuMinuman minuman2 = (cMenuMinuman) menuMinuman;
                                        minuman2.setGula("Dengan Gula");
                                        break;
                                    default:
                                        System.out.println("Jenis gula tidak valid. Default: Tanpa Gula.");
                                        break;
                                }
                                System.out.println("Item ditambahkan ke keranjang sementara.");
                                break;
                            case 3:
                                if (pesanan.isEmpty()) {
                                    System.out.println("Keranjang masih kosong.");
                                    } 
                                else {
                                    pesanan.tampilkanKeranjang();
                                    System.out.print("Masukkan nomor item yang ingin dihapus: ");
                                    int noHapus = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Yakin ingin menghapus item tersebut? (Y/N) : ");
                                    String konfirmasiHapus = input.nextLine();
                                    if (konfirmasiHapus.equalsIgnoreCase("Y")) {
                                        pesanan.hapusItem(noHapus);
                                        System.out.println("Item berhasil dihapus dari keranjang.");
                                    } else {
                                        System.out.println("Penghapusan dibatalkan.");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    }

                    if (pesanan.isEmpty()) {
                        System.out.println("Pesanan kosong, dibatalkan.");
                        break;
                    }

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
                    double kembalian = transaksi.prosesPembayaran(bayar);
                    if (kembalian < 0) {
                        System.out.println("Pembayaran gagal. Jumlah bayar kurang.");
                    } else {
                        System.out.println("Pembayaran berhasil. Kembalian: Rp" + kembalian);
                        System.out.println("Status pembayaran: " + transaksi.getStatusPembayaran());

                        for (int i = 0; i < pesanan.getItems().size(); i++) {
                            cItemPesanan item = pesanan.getItems().get(i);
                            cMenu menu = item.getMenu();
                            menu.tambahPenjualan(item.getJumlah());
                        }
                    }
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
                                    cMenu.Tampilmenu(daftarMenu);
                                }
                                break;
                            case 3:
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Menu masih kosong.");
                                    break;
                                }
                                System.out.println("Pilih menu untuk edit:");
                                cMenu.Tampilmenu(daftarMenu);
                                System.out.print("Pilih nomor : ");
                                int editId = input.nextInt();
                                input.nextLine();
                                cMenu menuEdit = cMenu.cariMenuById(daftarMenu, editId);
                                if (menuEdit != null) {
                                    System.out.println("Data ditemukan: " + menuEdit.getNamaMenu());
                                    System.out.print("Masukkan Harga Baru : ");
                                    double hargaBaru = input.nextDouble();
                                    System.out.print("Masukkan Stok Baru  : ");
                                    int stokBaru = input.nextInt();
                                    
                                    menuEdit.setHargaMenu(hargaBaru);
                                    menuEdit.setStokMenu(stokBaru);
                                    System.out.println("Menu berhasil diperbarui.");
                                }
                                else {
                                    System.out.println("Menu dengan ID tersebut tidak ditemukan.");
                                }
                                    break;
                            case 4:
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Menu masih kosong.");
                                    break;
                                }
                                System.out.println("Pilih menu untuk hapus:");
                                cMenu.Tampilmenu(daftarMenu);
                                System.out.print("Pilih nomor : ");
                                int hapusId = input.nextInt();
                                System.out.println("Yakin ingin menghapus menu tersebut? (Y/N) : ");
                                String konfirmasiHapusMenu = input.next();
                                if (konfirmasiHapusMenu.equalsIgnoreCase("Y")) {
                                    cMenu.hapusId(daftarMenu, hapusId);
                                    System.out.println("Menu berhasil dihapus.");
                                } else {
                                    System.out.println("Penghapusan dibatalkan.");
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
                        cTransaksi.tampilkanTransaksi(daftarTransaksi);
                    }
                    break;

                case 4:
                    System.out.println("\n==========================================");
                    System.out.println("       LAPORAN PENJUALAN HARI INI");
                    System.out.println("==========================================");
                    System.out.printf("%-20s | %-10s | %-10s%n", "Nama Menu", "Terjual", "Omzet");
                    System.out.println("------------------------------------------");
                    double totalPendapatan = 0;
                    for (int i = 0; i < daftarMenu.size(); i++) {
                        if (daftarMenu.get(i).getJumlahTerjual() > 0) {
                        double omzetItem = daftarMenu.get(i).getJumlahTerjual() * daftarMenu.get(i).getHargaMenu();
                        System.out.printf("%-20s | %-10d | Rp%-10.0f%n", 
                              daftarMenu.get(i).getNamaMenu(), daftarMenu.get(i).getJumlahTerjual(), omzetItem);
                        totalPendapatan += omzetItem;
                        }
                    }

                    System.out.println("------------------------------------------");
                    System.out.printf("TOTAL PENDAPATAN KOTOR: Rp%.0f%n", totalPendapatan);
                    System.out.println("==========================================");
                    running = false;
                    System.out.println("Terima kasih telah bertugas hari ini, " + kasirLoggedIn.getNama() + "!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }

}

