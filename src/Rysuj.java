

public class Rysuj {
    private Figury tryb;
    private boolean czyAktywny=false;
    private double x, y;
    public void ustawTryb(Figury tryb) {
        this.tryb = tryb;
    }
    public boolean stan() {
        return czyAktywny;
    }
    public void wlacz() {
        czyAktywny = true;
    }
    public void wylacz() {
        czyAktywny = false;
    }
    public void ustawPozycje(double x, double y) {
        this.x = x;
        this.y = y;
    }   
    public void rysuj(Plansza plansza) {
        if(!czyAktywny) return;
        switch (tryb) {
            case KOLO:
                Kolo k = new Kolo(x, y, 50);
                if(!k.pasuje(plansza)) return;
                plansza.getChildren().add(k);
                break;
            case PROSTOKAT:
            Prostokat p = new Prostokat(x, y, 100, 100);
                if(!p.pasuje(plansza)) return;
            plansza.getChildren().add(p);
                break;
            case TROJKAT:
            Trojkat t = new Trojkat(x, y, 200);
                if(!t.pasuje(plansza)) return;
                plansza.getChildren().add(t);
                break;
        }
        wylacz();  
    }
    
    
}