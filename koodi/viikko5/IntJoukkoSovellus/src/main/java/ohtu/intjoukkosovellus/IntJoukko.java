
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int ALOITUSKOKO = 5, // aloitustaulukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukujono = new int[ALOITUSKOKO];
        lukuJononAlustus(OLETUSKASVATUS);
    }

    public IntJoukko(int taulukonKoko) {
        if (taulukonKoko < 0) {
            return;
        }
        lukujono = new int[taulukonKoko];
        lukuJononAlustus(OLETUSKASVATUS);

    }
    
    public IntJoukko(int taulukonKoko, int kasvatusKoko) {
        if (taulukonKoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatusKoko < 0) {
            throw new IndexOutOfBoundsException("taulukonKoko2");//heitin vaan jotain :D
        }
        lukujono = new int[taulukonKoko];
        lukuJononAlustus(kasvatusKoko);

    }
    
    public void lukuJononAlustus(int koko){
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatusKoko = koko;
        
    }

    public boolean lisaa(int annettuLuku) {

        int eiOle = 0;
        /*if (alkioidenLkm == 0) {
            lukujono[0] = annettuLuku;
            alkioidenLkm++;
            return true;
        } else {
        }*/
        if (!kuuluu(annettuLuku)) {
            lukujono[alkioidenLkm] = annettuLuku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                int[] taulukkoOld = new int[lukujono.length];
                taulukkoOld = lukujono;
                kopioiTaulukko(lukujono, taulukkoOld);
                lukujono = new int[alkioidenLkm + kasvatusKoko];
                kopioiTaulukko(taulukkoOld, lukujono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int annettuLuku) {
        int on = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (annettuLuku == lukujono[i]) {
                on++;
            }
        }
        if (on > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poista(int annettuLuku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (annettuLuku == lukujono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                lukujono[kohta] = lukujono[alkioidenLkm-1];
                alkioidenLkm--;
                return true;
            }
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukujono[i];
                tuotos += ", ";
            }
            tuotos += lukujono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu; 
    }
   
    public static IntJoukko kopioiJoukkoon(IntJoukko kopioitava, IntJoukko joukkoon) {
        int[] aTaulu = kopioitava.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            joukkoon.lisaa(aTaulu[i]);
        }
        return joukkoon;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        yhdisteJoukko = kopioiJoukkoon(a, yhdisteJoukko);
        yhdisteJoukko = kopioiJoukkoon(b, yhdisteJoukko);
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
 
        return z;
    }
        
}