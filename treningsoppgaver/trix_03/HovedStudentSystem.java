public class HovedStudentSystem {
    public static void main(String[] args) throws Exception {
        StudentSystem system = new StudentSystem();
        system.lesFraFil("emnestudenter.txt");
        system.ordrelokke();
        system.skrivTilFil("emnestudenter.txt");

    }
}
