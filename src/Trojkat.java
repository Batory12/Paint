import javafx.scene.shape.Polygon;

public class Trojkat extends Polygon{
    private double bok;
    public Trojkat(double x, double y, double bok) {
        double h = Math.sqrt(3)/2*bok;
        getPoints().addAll(new Double[]{
            x, y-h*2/3,
            x+bok/2, y+h/3,
            x-bok/2, y+h/3
        });
    }
    
}
