import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Prostokat extends Rectangle {
    private double x, y, w, h;
    private Rotate rotate = new Rotate();
    public Prostokat(double x, double y, double w, double h) {
        super(x, y, w, h);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        setOnMousePressed(new FXRectangleEventHandler());
        setOnMouseDragged(new FXRectangleEventHandler());
        setOnScroll(new FXRectangleScrollHandler());
        getTransforms().add(rotate);
    }
    public boolean pasuje(Plansza plansza) {
        return !(x<50 || y<50 || x+w>plansza.getWidth()-50 || y+h>plansza.getHeight()-50);
    }
    // Metoda sprawdza czy najechalismy na figure
    public boolean isHit(double x, double y) { 
        return getBoundsInLocal().contains(x,y);   
    }

    // Zmiana wspolrzednej x prostakata
    public void addX(double x) {  
        setX(getX()+x);
    }

    // Zmiana wspolrzednej y prostakata
    public void addY(double y) {  
        setY(getY()+y);
    }
    
    // Zmiana szerokosci prostokata
    public void addWidth(double w) {
        setWidth(getWidth()+w);
    }
    
    // Zmiana wysokosci prostokata
    public void addHeight(double h) {     
        setHeight(getHeight()+h);
    }


    // Implementacja przesuwania
  class FXRectangleEventHandler implements EventHandler<MouseEvent>{
    
    Prostokat rectangle;
    private double x;
    private double y;
  
    private void doMove(MouseEvent event) {
              
      double dx = event.getX() - x;
      double dy = event.getY() - y;
  
        // Jesli nacisnelismy na prostokat
       if (rectangle.isHit(x, y)) {
            rectangle.addX(dx);
            rectangle.addY(dy);
        }
      x += dx;
      y += dy;            
    }
  
  
    @Override
    public void handle(MouseEvent event) {
  
     rectangle = (Prostokat) event.getSource();
     if (event.getEventType()==MouseEvent.MOUSE_CLICKED){
        x = event.getX();
        y = event.getY();
      }
      if (event.getEventType()==MouseEvent.MOUSE_DRAGGED){
        doMove(event);
      }
  
    }
  }

  // Implementacja scrollowania   
class FXRectangleScrollHandler implements EventHandler<ScrollEvent>{

    Prostokat rectangle;

    private void doScale(ScrollEvent e) {
              
    double x = e.getX();
    double y = e.getY();
  
    // Jesli nacisnelismy na elipse
    if (rectangle.isHit(x, y)) {                 
            rectangle.addWidth(e.getDeltaY()*0.2);
            rectangle.addHeight(e.getDeltaY()*0.2);

        }
    }            
  
    @Override
    public void handle(ScrollEvent event) {
      
        rectangle = (Prostokat) event.getSource();
      if (event.getEventType()==ScrollEvent.SCROLL){
        doScale(event);
        //doRotate(event);
      }
    }
    private void doRotate(ScrollEvent e) {
        if (rectangle.isHit(e.getX(), e.getY())) {
            rotate.setPivotX(x+w/2);     
            rotate.setPivotY(y+h/2);            
            rotate.setAngle(rotate.getAngle()+e.getDeltaY()*0.2);
        }
    }           
      
  }
}
