import java.io.Serializable;

import javafx.scene.layout.Pane;

public class Plansza extends Pane implements Serializable {
    public enum tryb {
        EDIT, DRAW
    }
    private Figura f;
    private tryb t;
    public void ustawTryb(tryb t) {
        this.t = t;
    }
   /* public Plansza(Rysuj r) {
        setOnMousePressed(e -> {
            setPrefSize(800, 600);
            System.out.println("Kliknieto plansze");
            r.ustawPozycje(e.getX(), e.getY());
            r.rysuj(this);
        });
    };*/
    public Plansza() {
        Rysowanie a = new Rysowanie();
        setOnMousePressed(a);
        setOnMouseDragged(a);
        setOnMouseReleased(a);
    }
    public Figura rysowanaFigura() {
        return f;
    }
    public void przestanRysowac() {
        f=null;
    }
    public void rysuj(Figura f) {
        this.f = f;
    }

}
