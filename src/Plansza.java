import javafx.scene.layout.Pane;


/**
 * Klasa Plansza
 * Klasa dziedzicząca po Pane
 * Obsługuje rysowanie figur
 * @see Figura
 * @see Rysowanie
 */
public class Plansza extends Pane {
    /**
     * Aktualnie rysowana figura
     */
    private Figura f;
    /**
     * Konstruktor klasy Plansza
     * ustawia obsługę rysowania figur
     * @see Rysowanie
     */
    public Plansza() {
        Rysowanie a = new Rysowanie();
        setOnMousePressed(a);
        setOnMouseDragged(a);
        setOnMouseReleased(a);
    }
    /**
     * Metoda rysowanaFigura
     * Zwraca aktualnie rysowaną figurę
     * @return f aktualnie rysowana figura
     * @see Figura
     */
    public Figura rysowanaFigura() {
        return f;
    }
    /**
     * Metoda przestanRysowac
     * Przestaje rysować figurę
     */
    public void przestanRysowac() {
        f=null;
    }
    /**
     * Metoda rysuj
     * Rysuje figurę
     * @param f figura do narysowania
     * @see Figura
     */
    public void rysuj(Figura f) {
        this.f = f;
    }

}
