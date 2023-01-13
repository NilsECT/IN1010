public class HovedButikk {
    public static void main(String[] args){
        Person per = new Person("Per", "vin");
        Person peder = new Person("Peder", "vin");
        Person petter = new Person("Petter", "vin");
        Person pedro = new Person("Pedro", "vin");
        Person pepper = new Person("Pepper", "vin");

        Butikk butikk = new Butikk();

        butikk.entreButikk(per);
        butikk.entreButikk(peder);
        butikk.entreButikk(petter);
        butikk.entreButikk(pedro);
        butikk.entreButikk(pepper);

        butikk.kassa();
    }
}
