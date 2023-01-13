public class Hovedprogram {
    public static void main(String[] args) throws Exception {
        Dataklynge abel = new Dataklynge("abel", "dataklynge.txt");   

        System.out.println("");

        System.out.println("Noder med minst 32 GB: " + abel.noderMedNokMinne(32));
        System.out.println("Noder med minst 64 GB: " + abel.noderMedNokMinne(64));
        System.out.println("Noder med minst 128 GB: " + abel.noderMedNokMinne(128));
        
        System.out.println("");

        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall rack: " + abel.antRack());
    }
}



/**
Kjøreeksempel for dataklynge.txt:

~/Documents/Studies/Bachelor/IN/in1010/pre_course/oblig1$ java Hovedprogram 

Noder med minst 32 GB: 666
Noder med minst 64 GB: 666
Noder med minst 128 GB: 16

Antall prosessorer: 682
Antall rack: 56



Kjøreeksempel for dataklynge2.txt:

~/Documents/Studies/Bachelor/IN/in1010/pre_course/oblig1$ java Hovedprogram 

Noder med minst 32 GB: 148
Noder med minst 64 GB: 148
Noder med minst 128 GB: 118

Antall prosessorer: 264
Antall rack: 74



Kjøreeksempel for dataklynge3.txt:

~/Documents/Studies/Bachelor/IN/in1010/pre_course/oblig1$ java Hovedprogram 

Noder med minst 32 GB: 150
Noder med minst 64 GB: 150
Noder med minst 128 GB: 100

Antall prosessorer: 200
Antall rack: 1



Kjøreeksempel for dataklynge4.txt:

~/Documents/Studies/Bachelor/IN/in1010/pre_course/oblig1$ java Hovedprogram 

Noder med minst 32 GB: 11
Noder med minst 64 GB: 11
Noder med minst 128 GB: 11

Antall prosessorer: 19
Antall rack: 2


 */