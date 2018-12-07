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
public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    TextField tuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    int lastInt;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }


    @Override
    public void suorita() {
        lastInt = Integer.parseInt(this.tuloskentta.getCharacters().toString());
        sovellus.nollaa();
        sovellus.tulosta(this.tuloskentta, this.syotekentta);
    }

    @Override
    public void peru() {
        this.tuloskentta.setText(Integer.toString(lastInt));
        sovellus.tulosta(this.tuloskentta, this.syotekentta);
    }
    
}
