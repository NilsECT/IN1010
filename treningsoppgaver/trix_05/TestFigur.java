public class TestFigur {
    public static void main(String[] args){
        Rektangel rek = new Rektangel(2, 1);
        Sirkel sirk = new Sirkel(1);

        if (rek.beregnAreal() == 2){
            System.out.println("Arealet til rektangelet ble regnet riktig.");
        }
        else {
            System.out.println("Arealet til rektangelet ble ikke regnet riktig.");
        }

        if (rek.beregnOmkrets() == 6){
            System.out.println("Omkretsen til rektangelet ble regnet riktig.");
        }
        else {
            System.out.println("Omkretsen til rektangelet ble ikke regnet riktig.");
        }

        if (sirk.beregnAreal() == Math.PI){
            System.out.println("Arealet til sirkelen ble regnet riktig.");
        }
        else {
            System.out.println("Arealet til sirkelen ble ikke regnet riktig.");
        }

        if (sirk.beregnOmkrets() == 2 * Math.PI){
            System.out.println("Omkretsen til sirkelen ble regnet riktig.");
        }
        else {
            System.out.println("Omkretsen til sirkelen ble ikke regnet riktig.");
        }

    }
}
