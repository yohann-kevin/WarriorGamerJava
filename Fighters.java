import java.util.HashMap;
import java.util.Map;

public class Fighters {
    public String name;
    public Map<String, Object> stats = new HashMap<String, Object>();

    public Fighters(String name) {
        this.name = name;
    }

    public void init(String nameClasses) {
        System.out.println("Joueur #" + 0 + " = " + this.name);
        System.out.println("Jouera " + nameClasses);
        System.out.println("--------------------------------------");
    }

    public void healing() {
        int lp = (int) this.stats.get("lifePoint");
        lp += (int) this.stats.get("heal");
        this.stats.put("lifePoint", lp);
        System.out.println(this.name + " se soigne de " + this.stats.get("heal") + " point(s)");
    }

    public void buffDefense() {
        this.stats.put("defenseIsBuffed", true);
        System.out.println(this.name + " augmente sa défense de " + this.stats.get("buffDef") + " point(s)");
    }

    public void buffAtk() {
        int dpsPoint = (int) this.stats.get("dps");
        dpsPoint += (int) this.stats.get("buffDps");
        this.stats.put("dps", dpsPoint);
        System.out.println(this.name + " augmente son attaque de " + this.stats.get("buffDps") + " point(s)");
    }

    public int attack() {
        double coefficient = Math.random();
        int shot = (int) ((int) this.stats.get("dps") * coefficient);
        if ((int) this.stats.get("malusDps") > 0) {
            shot -= (int) this.stats.get("malusDps");
            this.stats.put("malusDps", 0);
        }
        if (shot < 0) return 0;
        System.out.println(this.name + " porte un coup de " + shot + " point(s)");
        return shot;
    }

    public void defense(int shot) {
        double coefficient = Math.random();
        if ((boolean) this.stats.get("defenseIsBuffed")) shot = shot - ((int) ((int) this.stats.get("buffDef") * coefficient));
        if ((int) this.stats.get("malusDef") > 0) {
            shot += (int) this.stats.get("malusDef");
            this.stats.put("malusDef", 0);
        }
        this.stats.put("defenseIsBuffed", false);
        this.stats.put("lifePoint", (int) this.stats.get("lifePoint") - shot);
    }

    public int debuffDps() {
        double coefficient = Math.random();
        int malus = (int) ((int) this.stats.get("debuffDps") * coefficient);
        System.out.println(this.name + " baisse l'attaque de " + malus + " point(s)");
        return malus;
    }

    public void atkDebuffed(int malus) {
        this.stats.put("malusDps", malus);
    }

    public int debuffDef() {
        double coefficient = Math.random();
        int malus = (int) ((int) this.stats.get("debuffDps") * coefficient);
        System.out.println(this.name + " baisse la défense de " + malus + " point(s)");
        return malus;
    }

    public void defDebuffed(int malus) {
        this.stats.put("malusDef", malus);
    }

    public void ia() {
        if ((int) this.stats.get("lifePoint") > ((int) this.stats.get("lifePoint") / 2)) {
            System.out.println("attaque");
        } else if ((int) this.stats.get("lifePoint") < ((int) this.stats.get("lifePoint") / 2)) {
            System.out.println("healing");
        }
    }

    public Fighters targetChoice(Fighters player, Fighters[] possibleTarget) {
        System.out.println(possibleTarget[2].name);
        Fighters[] targets = new Fighters[possibleTarget.length];
        for (int i = 0; i < possibleTarget.length; i++) {
            int counter = 0;
            if (possibleTarget[i].name != player.name) {
                targets[counter] = possibleTarget[i];
            }
        }

        // if(player.equals("toto")) {
        //     if ((int) allTarget.get("coco") < (int) allTarget.get("jojo")) {
        //         System.out.println("coco");
        //         return player;
        //     } else {
        //         System.out.println("jojo");
        //         return player;
        //     }
        // } else if (player.equals("jojo")) {
        //     if ((int) allTarget.get("coco") < (int) allTarget.get("toto")) {
        //         System.out.println("coco");
        //         return player;
        //     } else {
        //         System.out.println("toto");
        //         return player;
        //     }
        // }
        return player;
    }

    public Map<String, Object> getStats() {
        return this.stats; 
    }
    
}
