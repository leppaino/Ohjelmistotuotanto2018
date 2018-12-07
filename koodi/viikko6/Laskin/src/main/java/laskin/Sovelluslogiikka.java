package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Sovelluslogiikka {
 
    private int tulos;
 
    public int plus(int luku) {
        tulos += luku;
        return tulos;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
    public void tulosta(TextField tuloskentta, TextField syotekentta){
        tuloskentta.setText(Integer.toString(tulos)); 
        syotekentta.clear();
        syotekentta.requestFocus();
        
    }
}