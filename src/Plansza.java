import java.io.Serializable;

import javafx.scene.layout.Pane;

public class Plansza extends Pane implements Serializable {
    private Figura f;
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
