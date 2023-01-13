public class Post {
    private String beskrivelse = "";
    private String mottaker = "";

    public Post(String beskrivelse, String mottaker){
        this.beskrivelse = beskrivelse;
        this.mottaker = mottaker;
    }

    public String hentBeskrivelse(){
        return this.beskrivelse;
    }

    public String hentMottaker(){
        return this.mottaker;
    }

    @Override
    public String toString(){
        return beskrivelse + " til " + mottaker;
    }
}