import java.io.Serializable;
public class SFigura implements Serializable {
    char typ;
    double x, y, w, h, r, botX, botY, red, green, blue;
    double[] points;
    public SFigura(Figura f) {
        red = f.kolor().getRed();
        green = f.kolor().getGreen();
        blue = f.kolor().getBlue();
        if(f instanceof Kolo) {
            typ = 'K';
            x = ((Kolo)f).getCenterX();
            y = ((Kolo)f).getCenterY();
            r = ((Kolo)f).getRadius();
        }
        else if(f instanceof Prostokat) {
            typ = 'P';
            x = ((Prostokat)f).getX();
            y = ((Prostokat)f).getY();
            w = ((Prostokat)f).getWidth();
            h = ((Prostokat)f).getHeight();
        }
        else if(f instanceof Trojkat) {
            typ = 'T';
            x=((Trojkat)f).getTopX();
            y=((Trojkat)f).getTopY();
            botX=((Trojkat)f).getBotX();
            botY=((Trojkat)f).getBotY();
        }
    }
}
