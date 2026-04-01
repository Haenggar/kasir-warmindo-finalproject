package ProjectAkhir;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class appWarmindo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<cMenu> daftarMenu = new ArrayList<>();
        ArrayList<cTransaksi> daftarTransaksi = new ArrayList<>();
        int idPesananCounter = 1;
        int idTransaksiCounter = 1;

        System.out.println("Selamat datang di Program Kasir Warmindo");
        System.out.println("Silahkan masukkan data kasir terlebih dahulu..");
        System.out.print("ID Kasir : ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Nama Kasir : ");
        String nama = input.nextLine();

        ckasir kasir1 = new ckasir(id, nama);
        System.out.println("\nSelamat datang " + kasir1.getNama() + " di Program Kasir Warmindo..");

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
                    System.out.print("ID Pelanggan : ");
                    int idPelanggan = input.nextInt();
                    input.nextLine();
                    System.out.print("Nama Pelanggan : ");
                    String namaPelanggan = input.nextLine();
                    cPelanggan pelanggan = new cPelanggan(idPelanggan, namaPelanggan);

                    cPesanan pesanan = new cPesanan(idPesananCounter++, pelanggan, kasir1);

                    boolean tambahItem = true;
                    while (tambahItem) {
                        System.out.println("Daftar Menu:");
                        if (daftarMenu.isEmpty()) {
                            System.out.println("Menu masih kosong. Tambahkan menu terlebih dahulu.");
                            break;
                        }
                        for (int i = 0; i < daftarMenu.size(); i++) {
                            System.out.println((i+1) + ". " + daftarMenu.get(i).getNamaMenu() + " - Rp" + daftarMenu.get(i).getHargaMenu() + " (Stok: " + daftarMenu.get(i).getStokMenu() + ")");
                        }
                        System.out.print("Pilih nomor menu : ");
                        int pilihMenu = input.nextInt() - 1;
                        if (pilihMenu < 0 || pilihMenu >= daftarMenu.size()) {
                            System.out.println("Pilihan tidak valid.");
                            continue;
                        }
                        cMenu menuDipilih = daftarMenu.get(pilihMenu);
                        System.out.print("Jumlah pesanan : ");
                        int jumlah = input.nextInt();
                        input.nextLine(); // consume newline
                        if (jumlah > menuDipilih.getStokMenu()) {
                            System.out.println("Stok tidak cukup.");
                            continue;
                        }
                        cItemPesanan item = new cItemPesanan(menuDipilih, jumlah);
                        pesanan.addItem(item);
                        menuDipilih.setStokMenu(menuDipilih.getStokMenu() - jumlah);

                        System.out.print("Tambah item lagi? (Y/N) : ");
                        String lagi = input.nextLine();
                        if (!lagi.equalsIgnoreCase("Y")) {
                            tambahItem = false;
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
                                System.out.print("ID Menu : ");
                                int idMenu = input.nextInt();
                                input.nextLine();
                                System.out.print("Nama Menu : ");
                                String namaMenu = input.nextLine();
                                System.out.print("Kategori Menu : ");
                                String kategoriMenu = input.nextLine();
                                System.out.print("Harga Menu : ");
                                double hargaMenu = input.nextDouble();
                                System.out.print("Stok Menu : ");
                                int stokMenu = input.nextInt();
                                input.nextLine();
                                cMenu menuBaru = new cMenu(idMenu, namaMenu, kategoriMenu, hargaMenu, stokMenu);
                                daftarMenu.add(menuBaru);
                                System.out.println("Menu berhasil ditambahkan.");
                                break;
                            case 2:
                                System.out.println("Daftar Menu:");
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Menu masih kosong.");
                                } else {
                                    for (cMenu m : daftarMenu) {
                                        System.out.println(m.toString());
                                        System.out.println("---");
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
                        for (cTransaksi t : daftarTransaksi) {
                            System.out.println(t.toString());
                            System.out.println("---");
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
}
