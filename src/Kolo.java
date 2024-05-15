import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
/**
 * Klasa Kolo
 * Rozszerza klasę Circle na potrzeby aplikacji
 * Implementuje interfejs Figura
 * @see Figura
 */
public class Kolo extends Circle implements Figura {
    /**
     * Pole menu
     * Przechowuje menu kontekstowe dla figury
     * @see EditMenu
     */
    private EditMenu menu;
    /**
     * Bezargumentowy konstruktor klasy Kolo
     * Tworzy kolo o promieniu 0 i kolorze czarnym
     * @see Rysowanie
     * @see Plansza
     */
    public Kolo() {
        menu = new EditMenu(this);
        setOnScroll(new Skalowanie());
        setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    /**
     * Konstruktor klasy Kolo
     * Tworzy kolo o podanych parametrach
     * @param x współrzędna x środka koła
     * @param y współrzędna y środka koła
     * @param r promień koła
     * @param kolor kolor koła
     * @see Plansza
     * @see Zapisz
     * @see SFigura
     */
    public Kolo(double x, double y, double r, Color kolor) {
        super(x,y,r);
        setFill(kolor);
        menu = new EditMenu(this);
        setOnScroll(new Skalowanie());
        setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    @Override
    public void skaluj(double d) {
        setRadius(getRadius()+d/5);
    }
    @Override
    public boolean zawiera(double x, double y) {
      return getBoundsInLocal().contains(x,y); 
    }
    @Override
    public void przesun(double dx, double dy) {
        setCenterX(getCenterX()+dx);
        setCenterY(getCenterY()+dy);
    }
    @Override
    public void ustawGornyRog(double x, double y) {
        setCenterX(x);
        setCenterY(y);
    }
    @Override
    public void ustawDolnyRog(double x, double y) {
        final double dx = getCenterX()-x;
        final double dy = getCenterY()-y;
        setRadius(Math.sqrt(dx*dx+dy*dy));
    }
    @Override
    public void wlaczEdycje() {
        setOnMousePressed(new Przesuwanie());
        setOnMouseDragged(new Przesuwanie());
        setOnScroll(new Skalowanie());
    }
    @Override
    public void wylaczEdycje() {
      setOnMousePressed(null);
      setOnMouseDragged(null);
      setOnScroll(null);
    }
    @Override
    public void obroc(double kat) {
        setRotate(getRotate()+kat);
    }
     @Override
    public Color kolor() {
        return (Color)getFill();
    }

}