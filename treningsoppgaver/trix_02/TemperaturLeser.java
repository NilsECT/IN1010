import java.util.Scanner;
import java.io.File;


class TemperaturLeser {
    public static void main(String[] args) throws Exception{
        String[] temperatur = new String[12];
        Scanner temperaturer = new Scanner(new File("Temperatur.txt"));

        int i = 0;
        while (temperaturer.hasNextLine()){
            temperatur[i] = temperaturer.nextLine();
            i++;
        }
        /**
        for (int p = 0; p < temperatur.length; p++){
            System.out.println(temperatur[p]);
        }*/
        for (String linje : temperatur){
            System.out.println(linje);
        }
    }
}
