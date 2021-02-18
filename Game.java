
public class Game {
    public static void main(String[] args) {
        Magician toto = new Magician("toto");
        Magician jojo = new Magician("jojo");

        System.out.println("toto : " + toto.stats);
        System.out.println("jojo : " + jojo.stats);
        jojo.defense(toto.attack());

        toto.defense(jojo.attack());
        System.out.println("toto : " + toto.stats);
        System.out.println("jojo : " + jojo.stats);
    }
}