import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.shape.Shape;

public class Prostokat extends Rectangle implements Figura {
    private Rotate rotate = new Rotate();
    private EditMenu menu;
    public Prostokat() {
      menu = new EditMenu(this);
      setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
        @Override
        public void handle(ContextMenuEvent event) {        
          menu.show((Shape)event.getSource(), event.getScreenX(), event.getScreenY());              
      }
      });
    }
    public boolean pasuje(Plansza plansza) {
      return plansza.getBoundsInLocal().contains(getX(), getY()) && plansza.getBoundsInLocal().contains(getX()+getWidth(), getY()+getHeight());
        //!(getX()<50 || getY()<50 || getX()+getWidth()>plansza.getWidth()-50 || getY()+getHeight()>plansza.getHeight()-50);
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
      this.setX(x);
      this.setY(y);
    }
    @Override
    public void ustawDolnyRog(double x, double y) {
      this.setWidth(x-getX());
      this.setHeight(y-getY());
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
}
