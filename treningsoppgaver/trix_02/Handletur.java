import java.util.Scanner;

class Handletur {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int broed = 20; // i kroner alt
        int melk = 15;
        int ost = 40;
        int youghurt = 12;
        int total = 0;

        System.out.println("Hei! Vekommen til IFI-butikken.");
        System.out.println("Hvor mange brød vil du ha?");
        int antbroed = sc.nextInt();

        System.out.println("Hvor mange melk vil du ha?");
        int antmelk = sc.nextInt();

        System.out.println("Hvor mange ost vil du ha?");
        int antost = sc.nextInt();

        System.out.println("Hvor mange youghurt vil du ha?");
        int antyoughurt = sc.nextInt();
        
        sc.close();

        total = (broed*antbroed) + (melk*antmelk) + (ost*antost) + (youghurt*antyoughurt);

        System.out.println("Du skal betale: " + total + " kr.");
    }
}
