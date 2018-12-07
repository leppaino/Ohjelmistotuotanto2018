/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Aino
 */
public class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    int lastInt;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    Summa(IO io) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suorita() {
        lastInt = Integer.parseInt(this.syotekentta.getCharacters().toString());
        sovellus.plus(lastInt);
        sovellus.tulosta(this.tuloskentta, this.syotekentta);
    }

    @Override
    public void peru() {
        sovellus.miinus(lastInt);
        sovellus.tulosta(this.tuloskentta, this.syotekentta);
    }
    
}
