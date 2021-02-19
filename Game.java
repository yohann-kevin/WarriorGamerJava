import java.util.HashMap;
import java.util.Map;

public class Game {
    public static void main(String[] args) {
        Magician toto = new Magician("toto");
        Magician jojo = new Magician("jojo");
        Magician coco = new Magician("coco");

        // int[] lifePointTab = {(int) toto.stats.get("lifePoint"),(int) jojo.stats.get("lifePoint"),(int) coco.stats.get("lifePoint")};
        // Map<String, Integer> allLifePoint = new SortedMap<String, Integer>();
        Map <String, Integer> allLifePoint = new HashMap <String,Integer>();
        Fighters[] allFighters = {toto,jojo,coco};

        // System.out.println("toto : " + toto.stats);
        // System.out.println("jojo : " + jojo.stats);
        // jojo.defense(toto.attack());
        // jojo.atkDebuffed(toto.debuffDps());

        // toto.defense(jojo.attack());
        // System.out.println("toto : " + toto.stats);
        // System.out.println("jojo : " + jojo.stats);


        toto.start();
        jojo.start();

        int turn = 0;
        while ((int) toto.stats.get("lifePoint") > 0 && (int) jojo.stats.get("lifePoint") > 0) {
            if (turn == 0) {
                // Fighters target;
                allLifePoint.put("jojo", (int) jojo.stats.get("lifePoint"));
                allLifePoint.put("coco", (int) coco.stats.get("lifePoint"));
                Fighters target = toto.targetChoice(toto,allFighters);
                System.out.println(target.name);
                // System.out.println(allLifePoint);
                jojo.defense(toto.attack());
                turn = 1;
            } else {
                allLifePoint.put("toto", (int) toto.stats.get("lifePoint"));
                allLifePoint.put("coco", (int) coco.stats.get("lifePoint"));
                // jojo.targetChoice(allLifePoint, jojo.name);

                toto.defense(jojo.attack());
                turn = 0;
            }
        }

        if ((int) toto.stats.get("lifePoint") > 0) {
            System.out.println(toto.name + " a gagné ! (vie restante: " +  toto.stats.get("lifePoint") + ")");
        } else {
            System.out.println(jojo.name + " a gagné ! (vie restante: " +  jojo.stats.get("lifePoint") + ")");
        }
    }
}