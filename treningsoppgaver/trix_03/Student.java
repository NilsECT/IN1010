import java.util.HashMap;

public class Student {
    protected String navn;
    protected HashMap<String, Fag> mineFag = new HashMap<>();


    public Student(String navn){
        this.navn = navn;
    }

    public String hentNavn(){
        return navn;
    }

    public void nyttFag(Fag fagkode){
        if (mineFag.containsValue(fagkode)){
            System.out.println(navn + " tar allerede " + fagkode.hentFag());
        }
        else {
            mineFag.put(fagkode.hentFag(), fagkode);
        }
    }

    public void skrivMineFag(){
        System.out.println("Du tar følgende fag:");
        for (Fag fag : mineFag.values()){
            System.out.println(fag.hentFag());
        }
    }
    
    public void fjernFag(Fag fagkode){
        if (mineFag.containsValue(fagkode)){
            mineFag.remove(fagkode.hentFag());
        }
        else {
            System.out.println(navn + " tar ikke " + fagkode.hentFag());
        }
    }

    public int antFag(){
        return mineFag.size();
    }

    public void fjernAlleMineFag(){
        for (Fag fagkode : mineFag.values()){
            fagkode.fjernStudent(this);
        }
    }
}
