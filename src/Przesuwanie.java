import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Obsługa zdarzenia przesuwania figury
 * @see Figura
 * @see Plansza
 */
public class Przesuwanie implements EventHandler<MouseEvent> {
    /**
     * Aktualnie przesuwana figura
     */
    private Figura f;
    /**
     * Współrzędna x punktu początkowego przesuwania
     */
    private double x;
    /**
     * Współrzędna y punktu początkowego przesuwania
     */
    private double y;
    /**
     * Metoda doMove
     * Przesuwa figurę
     * @param event zdarzenie przesunięcia
     */
    private void doMove(MouseEvent event) {
              
      double dx = event.getX() - x;
      double dy = event.getY() - y;
  
        // Jesli nacisnelismy na elipse
       if (f.zawiera(x, y)) {
            f.przesun(dx, dy);
        }
      x += dx;
      y += dy;            
    }
  
  
    @Override
    public void handle(MouseEvent event) {
  
     f = (Figura) event.getSource();
     if (event.getEventType()==MouseEvent.MOUSE_PRESSED){
        x = event.getX();
        y = event.getY();
      }
      if (event.getEventType()==MouseEvent.MOUSE_DRAGGED){
        doMove(event);
      }
  
    }
}
    
