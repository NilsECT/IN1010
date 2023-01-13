class FeilTest {
    public static void main(String[] args) {

        //Oppretter en array med noen strenger
        String[] tallstrenger = {"10", "1", "32", "hei", "14", "11"};

        
        //Forsoeker aa konvertere alle strengene til heltall og skrive ut
        for (int i = 0; i < tallstrenger.length; i++) {

            try {
                int tmp = Integer.parseInt(tallstrenger[i]);
                System.out.println("Tallet er: " + tmp);
            }
            catch (NumberFormatException e) {
                System.out.println("Element med index [" + i + "] er ikke ett tall!");
                System.out.println("Du må endre '" + tallstrenger[i] + "' til ett tall!");
            }
        }
    }
}