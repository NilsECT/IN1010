public abstract class Student extends Person {
    protected String kurs;
    protected String laerested;

    public Student(String navn, int alder, String kurs, String laerested){
        super(navn, alder);
        this.kurs = kurs;
        this.laerested = laerested;
    }

    public abstract boolean harTillgang();
}
