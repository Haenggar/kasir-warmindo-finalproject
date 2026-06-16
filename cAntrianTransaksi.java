package ProjectAkhir;

import java.util.LinkedList;
import java.util.Queue;

public class cAntrianTransaksi {
    private final Queue<cTransaksi> antrian = new LinkedList<>();

    public void tambah(cTransaksi transaksi) {
        antrian.add(transaksi);
    }

    public cTransaksi peek() {
        return antrian.peek();
    }

    public cTransaksi proses() {
        return antrian.poll();
    }

    public boolean isEmpty() {
        return antrian.isEmpty();
    }

    public int size() {
        return antrian.size();
    }

    public void tampilkan() {
        cTransaksi.tampilkanTransaksi(antrian);
    }
}
