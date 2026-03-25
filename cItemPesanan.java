package ProjectAkhir;

public class cItemPesanan {
    private cMenu menu;
    private int jumlah;

    public cItemPesanan(cMenu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public cMenu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getSubtotal() {
        return menu.getHargaMenu() * jumlah;
    }

    public String toString() {
        return menu.getNamaMenu() + " x" + jumlah + " = " + getSubtotal();
    }
}