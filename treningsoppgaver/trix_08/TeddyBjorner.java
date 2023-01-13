public class TeddyBjorner {
    public static void main(String[] args){
        System.out.println(teddy(250));
        System.out.println(teddy(42));
        System.out.println(teddy(84));
        System.out.println(teddy(53));
        System.out.println(teddy(41));
    }

    static boolean teddy(int n){
        return teddyRekursjon(n, "");
    }

    static boolean teddyRekursjon(int n, String path){
        if (n == 42){
            return true;
        }
        if (n <= 0 || path.contains(""+n)){
            return false;
        }
        if (n%5 != 0 && n%2 != 0 && n%3 != 0 && n%4 != 0){
            return false;
        }

        boolean loype1 = true;
        boolean loype2 = true;
        boolean loype3 = true;

        if (n%5 == 0){
            loype1 = teddyRekursjon(n-42, path += " " + (n-42));
        }
        if (n%2 == 0){
            loype2 = teddyRekursjon(n/2, path += " " + (n/2));
        }
        if (n%3 == 0 || n%4 == 0){
            int inter = (n%10) * ((n%100)/10);
            loype3 = teddyRekursjon(n - inter, path += " " + (n-inter));
        }
        return (loype1 || loype2 || loype3);
    }
}
