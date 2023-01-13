public class Test {
    public static void main(String[] args){
        String testString = "prednisolon, kombinasjoner,vanlig,282.1546565691305,574.546565476458,";
        String[] splittern = testString.split(",");
        System.out.println(splittern.length);
    }
}
