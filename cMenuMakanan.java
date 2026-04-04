package ProjectAkhir;

public class cMenuMakanan extends cMenu {
    private String levelPedas;

    public cMenuMakanan(int idMenu, String namaMenu, double hargaMenu, int stokMenu, String levelPedas) {
        super(idMenu, namaMenu, "Makanan", hargaMenu, stokMenu);
        this.levelPedas = levelPedas;
    }

    public String getLevelPedas() {
        return this.levelPedas;
    }

    public void setLevelPedas(String levelPedas) {
        this.levelPedas = levelPedas;
    }

    @Override
    public String getExtraInfo() {
        return "Level Pedas : " + this.levelPedas;
    }
}