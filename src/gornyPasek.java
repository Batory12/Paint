import java.io.File;
import java.io.Reader;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
/**
 * Klasa gornyPasek
 * Zawiera w sobie górny pasek menu oraz jego funkcjonalności
 * Pozwala na zapisywanie i wczytywanie stanu planszy, rysowanie nowych figur oraz wyświetlanie informacji o programie    
 */
class gornyPasek extends MenuBar {

    /**
     * Konstruktor klasy gornyPasek
     * Tworzy górny pasek menu oraz dodaje do niego opcje zapisz, wczytaj, rysuj, o programie oraz instrukcja
     * @param r plansza, na której będą rysowane figury
     * @see Plansza
     * @see Zapisz
     * @see Wczytaj
     */
    public gornyPasek(Plansza r) {
        getMenus().add(new Menu("Plik") {
            {
                getItems().add(new MenuItem("Zapisz")  {
                    {
                        setOnAction(new Zapisz(r));
                    }
                });
                getItems().add(new MenuItem("Wczytaj") {
                    {
                        setOnAction(new Wczytaj(r));
                    }
                });
            }
        });
        getMenus().add(new Menu("Rysuj") {
            {
                getItems().add(new MenuItem("Okrag") {
                    {
                    setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            r.rysuj(new Kolo());
                        }
                    });
                    }
                });
                getItems().add(new MenuItem("Prostokąt") {
                    {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                r.rysuj(new Prostokat());
                            }
                        });
                    }
                });
                getItems().add(new MenuItem("Trojkat") {
                    {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                r.rysuj(new Trojkat());
                            }
                        });
                    }
                });
            }
        });
        getMenus().add(new Menu("Więcej") {
            {
                getItems().add(new MenuItem("O programie") {
                    {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                String text= new String();
                                try {
                                    Scanner reader = new Scanner(new File("src\\Info.txt"));
                                    while(reader.hasNextLine()) {
                                        text+=reader.nextLine()+"\n";
                                    }
                                    reader.close();
                                } catch (Exception ex) {
                                    text="Nie znaleziono pliku z informacjami o programie";
                                }
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("O programie");
                                alert.setContentText(text);
                                alert.setHeaderText(null);
                                alert.showAndWait();
                            }
                        });
                    }
                });

                getItems().add(new MenuItem("Instrukcja") {
                    {
                        setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                String text= new String();
                                try {
                                    Scanner reader = new Scanner(new File("src\\Instrukcja.txt"));
                                    while(reader.hasNextLine()) {
                                        text+=reader.nextLine()+"\n";
                                    }
                                    reader.close();
                                } catch (Exception ex) {
                                    text="Nie znaleziono pliku z instrukcja";
                                }
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Instrukcja");
                                alert.setContentText(text);
                                alert.setHeaderText(null);
                                alert.showAndWait();
                            }
                        });
                    }
                });
            }
        
        });
    }
}