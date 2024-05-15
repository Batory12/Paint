import javafx.scene.paint.Color;

/**
 * Interfejs dla rysowanych figur
 */
public interface Figura {
    /**
     * Sprawdza czy punkt (x,y) należy do figury
     * @param x współrzędna x punktu
     * @param y współrzędna y punktu
     * @return true jeśli punkt należy do figury, false w przeciwnym wypadku
     */
    public boolean zawiera(double x, double y);
    /**
     * Skaluje figurę o d
     * @param d wartość o jaką ma być przeskalowana figura
     */
    public void skaluj(double d);
    /**
     * Przesuwa figurę o dx w poziomie i dy w pionie
     * @param dx wartość o jaką ma być przesunięta figura w poziomie
     * @param dy wartość o jaką ma być przesunięta figura w pionie
     */
    public void przesun(double dx, double dy);
    /**
     * Ustawia górny róg figury na punkt (x,y)
     * @param x współrzędna x punktu
     * @param y współrzędna y punktu
     */
    public void ustawGornyRog(double x, double y);
    /**
     * Ustawia dolny róg figury na punkt (x,y)
     * @param x współrzędna x punktu
     * @param y współrzędna y punktu
     */
    public void ustawDolnyRog(double x, double y);
    /**
     * Włącza edycję figury
     * @see EditMenu
     */
    public void wlaczEdycje();
    /**
     * Wyłącza edycję figury
     * @see EditMenu
     */
    public void wylaczEdycje();
    /**
     * Obraca figurę o kat
     * @param kat wartość o jaką ma być obrócona figura
     * @see EditMenu
     */
    public void obroc(double kat);
    /**
     * Zwraca kolor figury
     * @return kolor figury
     */
    public Color kolor();
}
