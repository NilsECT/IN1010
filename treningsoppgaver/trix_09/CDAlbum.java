public class CDAlbum implements Comparable<CDAlbum> {

    String artistnavn;
    String albumnavn;
    int utgivelsesaar;

    public CDAlbum (String artistnavn, String albumnavn, int utgivelsesaar){
        this.artistnavn = artistnavn;
        this.albumnavn = albumnavn;
        this.utgivelsesaar = utgivelsesaar;
    }

    public String hentArtist(){
        return this.artistnavn;
    }

    public String hentAlbum(){
        return this.albumnavn;
    }

    public int hentAar(){
        return this.utgivelsesaar;
    }

    @Override
    public String toString(){
        return artistnavn + ", \"" + albumnavn + "\" " + utgivelsesaar;
    }

    public int compareTo(CDAlbum annen){
        return this.artistnavn.compareTo(annen.artistnavn);
    }
}