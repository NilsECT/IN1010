import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.io.PrintWriter;


public class StudentSystem {
    HashMap<String, Fag> fagliste = new HashMap<>();
    HashMap<String, Student> studentliste = new HashMap<>();
    private Scanner tastatur = new Scanner(System.in);


    public void lesFraFil(String filnavn) throws Exception {
        Scanner fil = new Scanner(new File(filnavn));
        String linje;
        Fag fag = null;

        while (fil.hasNextLine()){
            linje = fil.nextLine();
            if (linje.charAt(0) == '*'){
                fag = new Fag(linje.substring(1));
                fagliste.put(fag.hentFag(), fag);
            }
            else {
                Student student;

                if (studentliste.containsKey(linje)){
                    student = studentliste.get(linje);
                }
                else {
                    student = new Student(linje);
                    studentliste.put(linje, student);
                }
                fag.nyStudent(student);
                student.nyttFag(fag);
            }
        }
    }

    public void meny(){
        String meny = "**********StudentSystem**********\n";
        meny += "1 - Legg til ny student.\n";
        meny += "2 - Legg til nytt fag.\n";
        meny += "3 - Meld på student opp til et emne.\n";
        meny += "4 - Meld av student fra et emne.\n";
        meny += "5 - Fjern en student fra systemet.\n";
        meny += "6 - Fjern et fag fra systemet.\n";
        meny += "7 - Skriv ut alle fag til en spesifik student.\n";
        meny += "8 - Skriv ut alle studenter som tar et spesifikt fag.\n";
        meny += "9 - Finne hvilken student som tar flest fag.\n";
        meny += "10 - Finne hvilket fag som har flest studenter.\n";
        meny += "11 - Skriv ut alle fag med deres studenter.\n";
        meny += "0 - Avslutt.\n";
        
        System.out.println(meny);
    }

    //1
    public void leggTilNyStudent(){
        Scanner onske = new Scanner(System.in);
        System.out.println("Hva heter studenten?");
        String navn = onske.nextLine();
        studentliste.put(navn, new Student(navn));
        
    }

    //2
    public void leggTilNyttFag(){
        Scanner onske = new Scanner(System.in);
        System.out.println("Hvilket fag vil du legge til?");
        String fag = onske.nextLine();
        fagliste.put(fag, new Fag(fag));
        
    }

    //3
    public void meldOppStudentTilFag(){
        Scanner onske = new Scanner(System.in);
        System.out.println("Hvilken student har du lyst til å melde opp?");
        Student student = studentliste.get(onske.nextLine());

        System.out.println("Til hvilket emne har du lyst melde studenten på?");
        Fag fag = fagliste.get(onske.nextLine());

        student.nyttFag(fag);
        fag.nyStudent(student);
        
    }

    //4
    public void meldAvStudentFraFag(){
        Scanner onske = new Scanner(System.in);
        System.out.println("Hvilken student har du lyst til å melde av?");
        Student student = studentliste.get(onske.nextLine());

        System.out.println("Fra hvilket emne har du lyst å melde studenten av?");
        Fag fag = fagliste.get(onske.nextLine());

        student.fjernFag(fag);
        fag.fjernStudent(student);
        
    }

    //5
    public void fjernStudentFraSystem(){
        Scanner onske = new Scanner(System.in);

        System.out.println("Hvilken student vil du fjerne fra systemet?");
        Student student = studentliste.get(onske.nextLine());

        student.fjernAlleMineFag();
        studentliste.remove(student.hentNavn());
        
    }

    //6
    public void fjernFagFraSystem(){
        Scanner onske = new Scanner(System.in);

        System.out.println("Hvilket emne har du lyst til å slette fra systemet?");
        Fag fag = fagliste.get(onske.nextLine());

        fag.fjernAlleMineStudenter();
        fagliste.remove(fag.hentFag());
        
    }

    //7
    public void skrivFagTilStudent(){
        Scanner onske = new Scanner(System.in);

        System.out.println("Hvilken student vil du ha oversikt over?");
        Student student = studentliste.get(onske.nextLine());

        student.skrivMineFag();
        
    }

    //8
    public void skrivStudenterSomTarFag(){
        Scanner onske = new Scanner(System.in);

        System.out.println("Hvilket emne vil du ha oversikt over?");
        Fag fag = fagliste.get(onske.nextLine());

        fag.skrivMineStudenter();
        
    }

    //9
    public void studentMedFlestFag(){
        Student studenten = null;
        for (Student student : studentliste.values()){
            if (studenten == null){
                studenten = student;
            }
            else if (studenten.antFag() < student.antFag()) {
                studenten = student;
            }
        }
        System.out.println("Studenten med flest emner er " + studenten.hentNavn() + ".");
        System.out.println("Studenten tar " + studenten.antFag() + " emner.");
    }

    //10
    public void fagMedFlestStudenter(){
        Fag faget = null;
        for (Fag fag : fagliste.values()){
            if (faget == null){
                faget = fag;
            }
            else if (faget.antStudenter() < fag.antStudenter()){
                faget = fag;
            }
        }
        System.out.println("Emnet med flest studenter er" + faget.hentFag() + ".");
        System.out.println("Emnet har " + faget.antStudenter() + " studenter.");
    }

    //11
    public void oversikt(){
        for (Fag fag : fagliste.values()){
            System.out.println(fag.hentFag() + ":");
            fag.skrivMineStudenter();
        }
    }

    //culmination
    public void ordrelokke(){
        int input = -1;

        while (input != 0){
            meny();
            input = tastatur.nextInt();
            if (input == 1){
                leggTilNyStudent();
            }
            else if (input == 2){
                leggTilNyttFag();
            }
            else if (input == 3){
                meldOppStudentTilFag();
            }
            else if (input == 4){
                meldAvStudentFraFag();
            }
            else if (input == 5){
                fjernStudentFraSystem();
            }
            else if (input == 6){
                fjernFagFraSystem();
            }
            else if (input == 7){
                skrivFagTilStudent();
            }
            else if (input == 8){
                skrivStudenterSomTarFag();
            }
            else if (input == 9){
                studentMedFlestFag();
            }
            else if (input == 10){
                fagMedFlestStudenter();
            }
            else if (input == 11){
                oversikt();
            }
            else if (input == 0){
                System.out.println("Avslutter.");
            }
            else if (input > 11){
                System.out.println("Du må taste inn et heltall fra og med 0 til og med 11!");
            }
        }
    }

    //skrive til fil
    public void skrivTilFil(String filnavn) throws Exception {
        PrintWriter fil = new PrintWriter(filnavn);
        for (Fag fag : fagliste.values()){
            fil.println("*" + fag.hentFag());
            for (Student student : fag.mineStudenter.values()){
                fil.println(student.hentNavn());
            }
        }
        fil.close();
    }
    
}
