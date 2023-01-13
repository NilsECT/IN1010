class Baathus {
    private Baat[] baathus;

    public Baathus(int antallPlasser){
        baathus = new Baat[antallPlasser];
    }
    public void settInn(Baat obj) {
        boolean sattInn = false;
        int teller = 0;

        while (teller < baathus.length && sattInn == false){
            if (baathus[teller] == null) {
                baathus[teller] = obj;
                sattInn = true;
            }
            teller ++;
        }
        if (sattInn != true) {
            System.out.println("Det er ikke plass for å sette inn flere båter!");
        }
    }
    public void skrivInfo(){
        for (int i = 0; i < baathus.length; i++){
            if (baathus[i] != null){
                System.out.println(baathus[i].hentInfo());
            }
        }
    }
}
