import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

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
    public Shape rysuj(double x, double y, double r) {
        return new Circle() {
            {
                setCenterX(x);
                setCenterY(y);
                setRadius(r);
            }
        };
    }
}
