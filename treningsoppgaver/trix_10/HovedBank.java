public class HovedBank {
    public static void main(String[] args){
        Bank bank = new Bank();

        for (int i = 0; i < 50; i++){
            Bankbruker bruker = new Bankbruker(bank);
            Thread traad = new Thread(bruker);
            traad.start();
        }
    }
}
