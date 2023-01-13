public class Tuppel {
    private int x;
    private int y;

    // konstruktoren tar posisjonen
    public Tuppel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    // henter ut posisjonen via toString
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
