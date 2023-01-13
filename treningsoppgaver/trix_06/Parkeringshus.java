/** public class Parkeringshus {
    static Parkeringsplass[] etasje1 = new Parkeringsplass[10];
    static Parkeringsplass[] etasje2 = new Parkeringsplass[10];

    public static void main(String[] args){
        Bil ford =  new Bil("11122", 5);
        Bil toyota = new Bil("22211", 4);
        Bil volvo = new Bil("43433", 9);

        Motorsykkel yamaha = new Motorsykkel("22", 150);
        Motorsykkel mitsubishi = new Motorsykkel("44", 200);
        Motorsykkel harley = new Motorsykkel("55", 100);

        etasje1[2] = new Parkeringsplass<Bil>();
        etasje1[2].parker(ford);

        etasje2[2] = new Parkeringsplass<Bil>();
        etasje2[2].parker(volvo);

        etasje1[8]  = new Parkeringsplass<Motorsykkel>();
        etasje1[8].parker(yamaha);

        etasje2[10]  = new Parkeringsplass<Motorsykkel>();
        etasje1[2].parker(harley);

        etasje1[8].ut();
        etasje1[8] = null;

        etasje2[10].ut();
        etasje2[10] = null;
    }
}
*/