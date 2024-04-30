public class Rysuj {
    private Figury tryb;
    private boolean czyWypelniony;
    private boolean czyAktywny=false;
    private double x, y;
    public void ustawTryb(Figury tryb) {
        this.tryb = tryb;
    }
    public void ustawPoz(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void ustawWypelnienie(boolean czyWypelniony) {
        this.czyWypelniony = czyWypelniony;
    }
    public boolean stan() {
        return czyAktywny;
    }
    public void zmienStan() {
        czyAktywny = !czyAktywny;
    }
}
