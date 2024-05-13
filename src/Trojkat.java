import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class Trojkat extends Polygon{
    private double bok;
    private double h, x, y;
    public Trojkat(double x, double y, double bok) {
        this.bok = bok;
        this.x = x;
        this.y=y;
        h = Math.sqrt(3)/2*bok;
        getPoints().addAll(new Double[]{
            x, y,
            x+bok/2, y+h,
            x-bok/2, y+h
        });
    }
    public double wysokosc() {
        return h;
    }
    public boolean pasuje(Plansza plansza) {
        return !(y+this.wysokosc()>plansza.getHeight()||x+bok/2>plansza.getWidth()||x<bok/2);
    }
    
}
