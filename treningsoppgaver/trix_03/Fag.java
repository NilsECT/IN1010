import java.util.HashMap;

public class Fag {
    protected String fag;
    protected HashMap<String, Student> mineStudenter = new HashMap<>();


    public Fag(String fag){
        this.fag = fag;
    }

    public String hentFag(){
        return fag;
    }

    public void nyStudent(Student student){
        if (mineStudenter.containsValue(student)){
            System.out.println(student.hentNavn() + " tar allerede " + fag);
        }
        else {
            mineStudenter.put(student.hentNavn(), student);
        }
    }

    public void skrivMineStudenter(){
        System.out.println(fag + " har følgende studenter:");
        for (Student student : mineStudenter.values()){
            System.out.println(student.hentNavn());
        }
    }

    public void fjernStudent(Student student){
        if (mineStudenter.containsValue(student)){
            mineStudenter.remove(student.hentNavn());
        }
        else {
            System.out.println(student.hentNavn() + " tar ikke " + fag);
        }
    }

    public int antStudenter(){
        return mineStudenter.size();
    }

    public void fjernAlleMineStudenter(){
        for (Student student : mineStudenter.values()){
            student.fjernFag(this);
        }
    }
}
