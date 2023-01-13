public class BachelorStudent extends Student {
    public BachelorStudent(String navn, int alder, String kurs, String laerested){
        super(navn, alder, kurs, laerested);
    }

    public void skrivInformasjon(){
        System.out.println("Bachelorstudent:");
        System.out.println("Navn: " + navn + "\nAlder: " + alder);
        System.out.println("Kurs: " + kurs + "\nLærested: " + laerested);
    }

    public boolean harTillgang(){
        return false;
    }
}
