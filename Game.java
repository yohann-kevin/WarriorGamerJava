public class Game {
    public static void main(String[] args) {
        Magician toto = new Magician("toto");
        Magician jojo = new Magician("jojo");
        Magician coco = new Magician("coco");
        Fighters[] allFighters = {toto,jojo,coco};

        toto.start();
        jojo.start();
        coco.start();
        toto.initIa();
        jojo.initIa();
        coco.initIa();

        int turn = 0;
        while ((int) toto.stats.get("lifePoint") > 0 && (int) jojo.stats.get("lifePoint") > 0 &&  (int) coco.stats.get("lifePoint") > 0) {
            if (turn == 0) {
                Fighters target = toto.targetChoice(toto,allFighters);
                toto.ia(target);
                turn = 1;
            } else if(turn == 1) {
                Fighters target = jojo.targetChoice(jojo,allFighters);
                jojo.ia(target);
                turn = 2;
            } else {
                Fighters target = coco.targetChoice(jojo,allFighters);
                coco.ia(target);
                turn = 0;
            }
        }

        if ((int) toto.stats.get("lifePoint") > 0 ) {
            System.out.println(toto.name + " a gagné ! (vie restante: " +  toto.stats.get("lifePoint") + ")");
        } else if ((int) jojo.stats.get("lifePoint") > 0 ) {
            System.out.println(jojo.name + " a gagné ! (vie restante: " +  jojo.stats.get("lifePoint") + ")");
        } else {
            System.out.println(coco.name + " a gagné ! (vie restante: " +  coco.stats.get("lifePoint") + ")");
        }
    }
}