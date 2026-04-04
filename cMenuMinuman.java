package ProjectAkhir;

public class cMenuMinuman extends cMenu {
    private boolean dingin;

    public cMenuMinuman(int idMenu, String namaMenu, double hargaMenu, int stokMenu, boolean dingin) {
        super(idMenu, namaMenu, "Minuman", hargaMenu, stokMenu);
        this.dingin = dingin;
    }

    public boolean isDingin() {
        return this.dingin;
    }

    public void setDingin(boolean dingin) {
        this.dingin = dingin;
    }

    @Override
    public String getExtraInfo() {
        return "Dingin : " + (this.dingin ? "Ya" : "Tidak");
    }
}