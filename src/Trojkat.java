import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;


public class Trojkat extends Group implements Figura {
    private tr t;
    private class tr extends Polygon{
        private double bok;
        private double h, x, y;
        public tr(double x, double y, double bok) {
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
        public Point2D srodek() {
            return new Point2D(x, y+h/2);
        }
        
    }
    public Trojkat(double x, double y, double bok) {
        t = new tr(x, y, bok);
        getChildren().add(t);
    }
    @Override
    public boolean pasuje(Plansza plansza) {
        return !(t.y+t.wysokosc()>plansza.getHeight()||t.x+t.bok/2>plansza.getWidth()||t.x<t.bok/2);
    }
    @Override
    public void przesun(double dx, double dy) {
        t.x+=dx;
        t.y+=dy;
        t.getPoints().setAll(new Double[]{
            t.x, t.y,
            t.x+t.bok/2, t.y+t.wysokosc(),
            t.x-t.bok/2, t.y+t.wysokosc()
        });
    }
    @Override
    public void obroc(double kat) {
        Rotate r = new Rotate(kat, t.srodek().getX(), t.srodek().getY());
        t.getTransforms().add(r);
    }
}
