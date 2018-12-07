/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.HashMap;
import java.util.*;

/**
 *
 * @author Aino
 */
public class Komentotehdas {
    private final HashMap<String, Komento> komennot;

    public Komentotehdas(IO io) {
        komennot = new HashMap<>();
        komennot.put("summa", new Summa(io));
        komennot.put("tulo", new Tulo(io));
        komennot.put("nelio", new Nelio(io));
        komennot.put("tuntematon", new Tuntematon(io));
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("tuntematon");
        }
        return komento;
    }
}
