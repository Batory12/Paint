import java.io.Serializable;

import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Trojkat extends Polygon implements Figura {
    private double topX, topY, botX, botY;
    private EditMenu menu;
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
    public Trojkat(double x, double y, double botX, double botY, Color kolor) {
        setFill(kolor);
        ustawGornyRog(x,y);
        ustawDolnyRog(botX, botY);
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
    public double getTopX() {
        return topX;
    }  
    public double getTopY() {
        return topY;
    }
    public double getBotX() {
        return botX;
    }
    public double getBotY() {
        return botY;
    }
    @Override
    public Color kolor() {
        return (Color)getFill();
    }
    
}
