import javafx.scene.shape.Circle;

public class Kolo extends Circle {
    double x, y, r;
    public Kolo(double x, double y, double r) {
        super(x, y, r);
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public boolean pasuje(Plansza plansza) {
        return !(x<50 || y<50 || x>plansza.getWidth()-50 || y>plansza.getHeight()-50);
    }
}