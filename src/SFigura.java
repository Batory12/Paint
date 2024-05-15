import java.io.Serializable;
/**
 * Klasa SFigura
 * Zawiera w sobie informacje o figurze, które są potrzebne do zapisu
 * @see Zapisz
 * @see Figura
 */
public class SFigura implements Serializable {
    /**
     * Typ figury:
     * K - kolo
     * P - prostokat
     * T - trojkat
     * @see Kolo
     * @see Prostokat
     * @see Trojkat
     */
    char typ;
    /**
     * Własności figury:
     * Kolo: x, y, r
     * Prostokat: x, y, w, h
     * Trojkat: x, y, botX, botY
     * @see Kolo
     * @see Prostokat
     * @see Trojkat
     */
    double x, y, w, h, r, botX, botY, red, green, blue;
    /**
     * Konstruktor klasy SFigura
     * Tworzy obiekt klasy SFigura na podstawie obiektu klasy Figura
     * @param f figura, na podstawie której tworzony jest obiekt klasy SFigura
     * @see Figura
     */
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
