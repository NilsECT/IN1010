public class EspressoMaskin {
    private int maksVannITank = 1000;   // i ml
    private int vannITank = 0;          // i ml

    public void lagEspresso(){
        int vannEspresso = 40;
        if ((vannITank - vannEspresso) >= 0){
            System.out.println("Forbereder Espresso!\n");
            vannITank -= vannEspresso;
        } else {
            System.out.println("Det er ikke nok vann!\n");
            System.out.print("Fyll på med minst:\n");
            int fyll = vannEspresso - vannITank;
            System.out.print(fyll + " ml.\n");
        }
    }

    public void lagLungo(){
        int vannLungo = 40;
        if ((vannITank - vannLungo) >= 0){
            System.out.println("Forbereder Lungo!\n");
            vannITank -= vannLungo;
        } else {
            System.out.println("Det er ikke nok vann!\n");
            System.out.print("Fyll på med minst:\n");
            int fyll = vannLungo - vannITank;
            System.out.print(fyll + " ml.\n");
        }
    }

    public void fyllvann(int ml){
        if ((ml + vannITank) <= maksVannITank){
            vannITank += ml;
            System.out.println("Fylt på med " + ml + " ml vann!\n");
        } else {
            System.out.println("Du kan ikke fylle på så mye, det er kun plass for:\n");
            int plass = maksVannITank - vannITank;
            System.out.print(plass + " ml.\n");
        }
    }

    public int hentVannmengde(){
        return vannITank;
    }
}
