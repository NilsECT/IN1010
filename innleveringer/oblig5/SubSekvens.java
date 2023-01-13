public class SubSekvens {
    private String subsekvens;
    private int antForekomster;

    public SubSekvens(String subsekvens) {
        this.antForekomster = 1;
        this.subsekvens = subsekvens;
    }

    public int hentAntForekomster() {
        return antForekomster;
    }

    public String hentSubSekvens() {
        return subsekvens;
    }

    public void settAntForekomster(int antForekomster) {
        this.antForekomster = antForekomster;
    }

    @Override
    public String toString() {
        String info = "SubSekvens: ";
        info += subsekvens;
        info += " med forekomst: ";
        info += antForekomster;
        return info;
    }
}