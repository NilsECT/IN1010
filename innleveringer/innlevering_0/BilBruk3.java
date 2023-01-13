public class BilBruk3 {
    public static void main(String[] args) {
        Bil3 enbil = new Bil3("DK 88888");
        Person per = new Person("Per", enbil);

        per.skrivBilNummer();
    }
}


/**
 * Kjøreeksempel:
~/Documents/Studies/Bachelor/IN/in1010/innleveringer/innlevering_0$ java BilBruk3
Per har bil med bilnummer: DK 88888

 */