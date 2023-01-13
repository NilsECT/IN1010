class Ansatt extends Person {
    protected int lønnstrinn;
    protected int antallTimer;

    void lønnstillegg(int tillegg){
        lønnstrinn += tillegg;
    }
}
