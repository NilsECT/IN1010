public class PasoFino extends Hest implements KanToelte {
    public PasoFino(String navn, int alder){
        super(navn, alder);
    }

    @Override
    public void toelt(){
        System.out.println(navn + " skritter i raskt tempo med hevede bein.");
    }
}
