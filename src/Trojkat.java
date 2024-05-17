import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
/**
 * Klasa Trojkat
 * Rozszerza klasę Polygon na potrzeby aplikacji
 * Implementuje interfejs Figura
 * @see Figura
 */
public class Trojkat extends Polygon implements Figura {
    /**
     * Pole topX
     * wykorzystywane przy rysowaniu trójkąta
     * @see Rysowanie
     * @see ustawGornyRog
     * @see ustawDolnyRog
     */
    private double topX;
     /**
     * Pole topY
     * wykorzystywane przy rysowaniu trójkąta
     * @see Rysowanie
     * @see ustawGornyRog
     * @see ustawDolnyRog
     */
    private double  topY;
     /**
     * Pole botX
     * wykorzystywane przy rysowaniu trójkąta
     * @see Rysowanie
     * @see ustawGornyRog
     * @see ustawDolnyRog
     */
    private double botX;
     /**
     * Pole botY
     * wykorzystywane przy rysowaniu trójkąta
     * @see Rysowanie
     * @see ustawGornyRog
     * @see ustawDolnyRog
     */
    private double botY;
    /**
     * Pole menu
     * Przechowuje menu kontekstowe dla figury
     * @see EditMenu
     */
    private EditMenu menu;
    /**
     * Bezargumentowy konstruktor klasy Trojkat
     * Tworzy trójkąt o wierzchołkach o boku 0 i kolorze czarnym
     * @see Rysowanie
     * @see Plansza
     */
    public Trojkat() {
        setOnScroll(new Skalowanie());
        menu = new EditMenu(this);
        setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    /**
     * Konstruktor klasy Trojkat
     * Tworzy trójkąt o podanych parametrach
     * @param x pole x
     * @param y pole y
     * @param botX pole botX
     * @param botY pole botY
     * @param kolor kolor trójkąta
     * @param kat kąt obrotu
     * @see Plansza
     * @see Zapisz
     * @see SFigura
     */
    public Trojkat(double x, double y, double botX, double botY, Color kolor, double kat) {
        setFill(kolor);
        ustawGornyRog(x,y);
        ustawDolnyRog(botX, botY);
        setRotate(kat);
        setOnScroll(new Skalowanie());
        menu = new EditMenu(this);
        setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    @Override
    public boolean zawiera(double x, double y) {
        return getBoundsInLocal().contains(x,y);
    }
    @Override
    public void skaluj(double d) {
        setScaleX(getScaleX()+d/100);
        setScaleY(getScaleY()+d/100);
    }
    @Override
    public void przesun(double dx, double dy) {
        botX+=dx;
        topX+=dx;
        botY+=dy;
        topY+=dy;
        getPoints().clear();
        getPoints().addAll(new Double[]{
            botX, botY,
            topX, botY,
            (botX+topX)/2, topY
    });
    }
    @Override
    public void ustawGornyRog(double x, double y) {
      topX=x;
      topY=y;
    }
    @Override
    public void ustawDolnyRog(double x, double y) {
        botX=x;
        botY=y;
        getPoints().clear();
        getPoints().addAll(new Double[]{
            botX, botY,
            topX, botY,
            (botX+topX)/2, topY
    });
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
    /**
     * Zwraca pole topX
     * @return topX pole topX
     */
    public double getTopX() {
        return topX;
    }  
    /**
     * Zwraca pole topY
     * @return topY pole topY
     */
    public double getTopY() {
        return topY;
    }
    /**
     * Zwraca pole botX
     * @return botX pole botX
     */
    public double getBotX() {
        return botX;
    }
    /**
     * Zwraca pole botY
     * @return botY pole botY
     */
    public double getBotY() {
        return botY;
    }
    @Override
    public Color kolor() {
        return (Color)getFill();
    }
    
}
