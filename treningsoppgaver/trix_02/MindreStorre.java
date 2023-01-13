import java.util.Scanner;

class MindreStorre {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Tast inn et tall:");
        int a = sc.nextInt();

        if (20 > a && a > 10){
            System.out.println("Tallet er mellom 10 og 20");
        } else if (a < 10){
            System.out.println("Tallet er mindre enn 10");
        } else {
            System.out.println("Tallet er større enn 20");
        }

        sc.close();
    }
}
