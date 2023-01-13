import java.util.Random;

public class Bankbruker implements Runnable {

    Bank bank;
    int belop;

    public Bankbruker(Bank bank){
        this.bank = bank;
    }
    public void run(){
        for (int i = 0; i < 100; i++){
            this.belop = i * new Random().nextInt(15);
            this.bank.ta(this.belop);
            this.bank.gi(this.belop);

            System.out.println(this.bank.saldo());
        }
    }
}
