import java.util.*;
import java.io.*;

public class HovedAlbum {
    
    public static void main(String[] args){
        ArrayList<CDAlbum> samling = new ArrayList<>();
        samling = les(args[0]);
        for (CDAlbum album : samling){
            System.out.println(album.toString());
        }
    }

    private static ArrayList<CDAlbum> les(String filnavn){
        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn));
        }
        catch (FileNotFoundException e){
            System.out.println("Fant ikke filen.");
            return null;
        }

        ArrayList<CDAlbum> albumSamling = new ArrayList<>();

        while (fil.hasNextLine()){
            String[] info = fil.nextLine().split(",");
            CDAlbum ny = new CDAlbum(info[0], info[1], Integer.parseInt(info[2]));

            boolean satt = false;
            int teller = 0;

            while (teller < albumSamling.size() && !satt){
                if (ny.compareTo(albumSamling.get(teller)) < 0){
                    albumSamling.add(teller, ny);
                    satt = true;
                }
                teller++;
            }

            if (!satt){
                albumSamling.add(ny);
            }
        }

        return albumSamling;
    }
}
