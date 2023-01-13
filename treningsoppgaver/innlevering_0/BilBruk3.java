class BilBruk3 {
    public static void main(String[] args){
        Bil3 ford = new Bil3("66630");
        Person petter = new Person("Petter", ford);
        
        petter.hentBilnummer();
    }
}
