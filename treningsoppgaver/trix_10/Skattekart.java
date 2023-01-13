import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Skattekart {
    private char[][] plasser;
    private int hoyde;
    private int bredde;
    private boolean funnet = false;

    public Skattekart(char[][] plasser, int hoyde, int bredde){
        this.plasser = plasser;
        this.hoyde = hoyde;
        this.bredde = bredde;
    }

    static Skattekart lesInn(File f) throws FileNotFoundException {
        Scanner fil = new Scanner(f);

        String[] linje = fil.nextLine().split(" ");
        int rad = Integer.parseInt(linje[0]);
        int kol = Integer.parseInt(linje[1]);
        char[][] kart = new char[rad][kol];

        for (int i = 0; i < rad; i++){
            String nyLinje = fil.nextLine();

            for (int ii = 0; ii < kol; ii++){
                kart[i][ii] = nyLinje.charAt(ii);
            }
        }

        Skattekart skattekart = new Skattekart(kart, rad, kol);
        return skattekart;
    }

    private void rekursivSkrivUt(int h, int b){
        if (!funnet){
            if (b != this.bredde){
                System.out.print("X");
                rekursivSkrivUt(h, b + 1);
            }
            else if (h != this.hoyde - 1){
                System.out.println();
                rekursivSkrivUt(h + 1, 0);
            }
        }
        else {
            if (b != this.bredde){
                System.out.print(plasser[h][b]);
                rekursivSkrivUt(h, b + 1);
            }
            else if (h != this.hoyde - 1){
                System.out.println();
                rekursivSkrivUt(h + 1, 0);
            }
        }
    }

    public void skrivUt(){
        // for (int i = 0; i < hoyde; i++){

        //     for (int ii = 0; ii < bredde; ii++){

        //         if (funnet){
        //             System.out.print(plasser[i][ii]);
        //         }
        //         else {
        //             System.out.print("X");
        //         }
        //     }
        //     System.out.println();
        // }
        rekursivSkrivUt(0, 0);
        System.out.println();
    }

    public boolean sjekk(int rad, int kol){
        if (plasser[rad - 1][kol - 1] == 'X'){
            this.funnet = true;
        }

        return this.funnet;
    }
}
