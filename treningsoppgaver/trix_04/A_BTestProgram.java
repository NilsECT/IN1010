public class A_BTestProgram {
    
    public static void main(String[] args){
        B bokstav = new B();

        B b = bokstav;
        A a = bokstav;

        a.skrivKlasse();
        b.skrivKlasse();
    }
}
