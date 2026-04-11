package ProjectAkhir;

public class cItemPesanan {
    private cMenu menu;
    private int jumlah;
    private String extraInfo;

    public cItemPesanan(cMenu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
        this.extraInfo = menu.getExtraInfo();
    }

    public cItemPesanan(cMenu menu, int jumlah, String extraInfo) {
        this.menu = menu;
        this.jumlah = jumlah;
        this.extraInfo = extraInfo;
    }

    public cMenu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public double getSubtotal() {
        return menu.getHargaMenu() * jumlah;
    }

    public String toString() {
        return menu.getNamaMenu() + (extraInfo.isEmpty() ? "" : " (" + extraInfo + ")") + " x" + jumlah + " = " + getSubtotal();
    }
}