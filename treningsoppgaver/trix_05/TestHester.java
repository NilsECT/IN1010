public class TestHester {
    public static void main(String[] args){

        EngelskFullblodshest eng = new EngelskFullblodshest("Rob", 6);
        PasoFino fino = new PasoFino("Rico", 10);
        Islandshest island = new Islandshest("Old Man Raikonen", 99);

        eng.galopp();
        eng.trav();

        fino.galopp();
        fino.trav();
        fino.toelt();

        island.galopp();
        island.trav();
        island.toelt();
        island.pass();

    }
}
