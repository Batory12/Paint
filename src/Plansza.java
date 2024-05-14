import javafx.scene.layout.Pane;

public class Plansza extends Pane {
    private Figura f= new Kolo();
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
