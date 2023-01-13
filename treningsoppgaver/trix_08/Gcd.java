public class Gcd {
    public static void main(String[] args){
        System.out.println(gcd(20, 30));
        System.out.println(gcdInteractiv(20, 4));
    }

    static int gcd(int a, int b){
        if (a < b){
            int t = a;
            a = b;
            b = t;
        }

        int c = a % b;
        if (c == 0){
            return b;
        }
        else {
            return gcd(b, c);
        }
    }

    static int gcdInteractiv(int a, int b){
        if (a < b){
            int t = a;
            a = b;
            b = t;
        }

        int c = a % b;
        while (c != 0){
            a = b;
            b = c;

            c = a % b;
        }
        return b;
    }
}