package ProjectAkhir;

public class cMenuMinuman extends cMenu {
    private String gula;

    public cMenuMinuman(int idMenu, String namaMenu, double hargaMenu, int stokMenu, String gula) {
        super(idMenu, namaMenu, "Minuman", hargaMenu, stokMenu);
        this.gula = gula;
    }

    public String getGula() {
        return gula;
    }

    public void setGula(String gula) {
        this.gula = gula;
    }

    @Override
    public String getExtraInfo() {
        return "Gula : " + this.gula;
    }
}