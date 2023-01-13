import java.util.Scanner;

class Differanse{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Oppgi verdien til x: ");
        int a = sc.nextInt();
        
        System.out.println("Oppgi verdien til y: ");
        int b = sc.nextInt();
        
        sc.close();
        System.out.println("Differansen mellom x og y er " + (a - b));
    }
}