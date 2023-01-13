class Person{
    protected String navn;
    protected int tlfnr;

    boolean gyldigTlfnr(){
        return tlfnr >= 10000000 && tlfnr <= 99999999;
    }
}