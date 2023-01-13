public class HovedKatt {
    public static void main(String[] args){
        // Katt[] katter = {
        //     new Katt("Messi", 12),
        //     new Katt("Boira", 3),
        //     new Katt("Minouche", 15),
        //     new Katt("VillageElder", 50),
        //     new Katt("Ungkar", 1)};

        // Katt eldst = null;

        // for (int i = 1; i < katter.length; i++){
        //     if (katter[i].compareTo(katter[i-1]) >= 1){
        //         eldst = katter[i];
        //     }
        //     else {
        //         eldst = katter[i-1];
        //     }
        // }
        // System.out.println(eldst);

        Katt a = new Katt("Messi", 12);
        Katt b = new Katt("Boira", 3);
        Katt c = new Katt("Minouche", 15);

        GradigBeholder<Katt> beholder = new GradigBeholder<>();
        beholder.settInn(a);
        System.out.println(beholder.seObjekt().toString());
        beholder.settInn(b);
        System.out.println(beholder.seObjekt().toString());
        beholder.settInn(c);
        System.out.println(beholder.seObjekt().toString());
    }
}
