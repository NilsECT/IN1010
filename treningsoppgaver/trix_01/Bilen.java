class Bilen {
    
    private String eier;
    private String merke;

    public Bilen(String navn, String merk){
        eier = navn;
        merke = merk;
    }

    public void Info(){
        System.out.println("Eier: " + eier);
        System.out.println("Merke: " + merke);
    }
}
