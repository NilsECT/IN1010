public class SHoved {
    public static void main(String[] args){
        S q = new G();
        Q b = new Q();
        D s = new Q();
        D g = new D();
        S p = new D();

        System.out.println(q instanceof D); //false
        System.out.println(q instanceof G); //true
        System.out.println(q instanceof S); //true
        System.out.println(b instanceof D); //true
        System.out.println(b instanceof S); //true
        System.out.println(s instanceof D); //true
        System.out.println(g instanceof Q); //false
        System.out.println(g instanceof S); //true
        System.out.println(p instanceof Q); //false
        System.out.println(p instanceof S); //true
        System.out.println(p instanceof G); //false

    }
}
