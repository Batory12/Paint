import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
/**
 * Klasa Prostokat
 * Rozszerza klasę Rectangle na potrzeby aplikacji
 * Implementuje interfejs Figura
 * @see Figura
 */
public class Prostokat extends Rectangle implements Figura {
    /**
     * Pole menu
     * Przechowuje menu kontekstowe dla figury
     * @see EditMenu
     */
    /*
     * Pole pomocnicze przy rysowaniu
     */
    private double topX;
    /*
     * Pole pomocnicze przy rysowaniu
     */
    private double  topY;
    private EditMenu menu;
    /**
     * Bezargumentowy konstruktor klasy Prostokat
     * Tworzy prostokąt o wymiarach 0x0 i kolorze czarnym
     * @see Rysowanie
     * @see Plansza
     */
    public Prostokat() {
      menu = new EditMenu(this);
      setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    /**
     * Konstruktor klasy Prostokat
     * Tworzy prostokąt o podanych parametrach
     * @param x współrzędna x lewego górnego rogu prostokąta
     * @param y współrzędna y lewego górnego rogu prostokąta
     * @param w szerokość prostokąta
     * @param h wysokość prostokąta
     * @param kolor kolor prostokąta
     * @param kat kąt obrotu
     * @see Plansza
     * @see Zapisz
     * @see SFigura
     */
    public Prostokat(double x, double y, double w, double h, Color kolor, double kat) {  
      super(x,y,w,h);
      setFill(kolor);
      setRotate(kat);
      menu = new EditMenu(this);
      setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    @Override
    public void skaluj(double d) {
        setWidth(getWidth()+d);
        setHeight(getHeight()+d);
    }
    @Override
    public boolean zawiera(double x, double y) {
      return getBoundsInLocal().contains(x,y); 
    }
    @Override
    public void przesun(double dx, double dy) {
      setX(getX()+dx);
      setY(getY()+dy);
    }
    @Override
    public void ustawGornyRog(double x, double y) {
      topX = x;
      topY = y;
      this.setX(x);
      this.setY(y);
    }
    @Override
    public void ustawDolnyRog(double x, double y) {
      this.setWidth(Math.abs(topX-x));
      this.setHeight(Math.abs(topY-y));
      if(x<topX) {
        this.setX(x);
      }
      if(y<topY) {
        this.setY(y);
      }
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
