class RektangelHovedprogram {
    public static void main(String[] args){
        Rektangel a = new Rektangel(4, 6);
        Rektangel b = new Rektangel(2, 8);

        System.out.println("a sitt areal er " + a.areal());
        System.out.println("b sitt areal er " + b.areal());

        a.oekBredde(3);
        b.oekLengde(5);

        System.out.println("a  sin omkrets er " + a.omkrets());
        System.out.println("b sin omkrets er " + b.omkrets());
    }
}
