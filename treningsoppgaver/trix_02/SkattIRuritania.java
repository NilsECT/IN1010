import java.util.Scanner;

class SkattIRuritania {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv din inntekt:");
        double inntekt = sc.nextDouble();

        sc.close();

        if (inntekt < 10000){
            double betale = inntekt * 0.1;
            System.out.println("Må betale " + betale + " i skatt.");
        } else if (inntekt >= 10000){
            double ekstra;
            ekstra = inntekt - 10000;
            double betale = (ekstra * 0.3) + 1000;
            System.out.println("Må betale " + betale + " i skatt.");
        }
    }
}
