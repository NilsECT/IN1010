import java.util.Scanner;

class Produkt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Oppgi verdien til x:");
        int x = sc.nextInt();

        System.out.println("Oppgi verdien til y:");
        int y = sc.nextInt();

        System.out.println("Produktet av x og y er " + (x*y));
        
        sc.close();

        if ((x - y) < 0){
            System.out.println("y er større enn x");
        } else {
            System.out.println("x er større eller lik y");
        }
    }
}
