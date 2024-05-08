import javafx.scene.layout.Pane;

public class Plansza extends Pane {
    public enum tryb {
        EDIT, DRAW
    }
    private tryb t;
    public void ustawTryb(tryb t) {
        this.t = t;
    }
    public Plansza(Rysuj r) {
        setOnMousePressed(e -> {
            setPrefSize(800, 600);
            System.out.println("Kliknieto plansze");
            r.ustawPozycje(e.getX(), e.getY());
            r.rysuj(this);
        });
    };
}
