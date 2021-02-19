import java.util.HashMap;
import java.util.Map;

public class Fighters {
    public String name;
    public Map<String, Object> stats = new HashMap<String, Object>();
    int dpsBased;
    int lpBased;

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

    public void attack(Fighters target) {
        double coefficient = Math.random();
        int shot = (int) ((int) this.stats.get("dps") * coefficient);
        if ((int) this.stats.get("malusDps") > 0) {
            shot -= (int) this.stats.get("malusDps");
            this.stats.put("malusDps", 0);
        }
        if (shot < 0) shot = 0;
        System.out.println(this.name + " porte un coup de " + shot + " point(s) sur " + target.name);
        target.defense(shot);
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

    public void initIa() {
        this.lpBased = (int) this.stats.get("lifePoint");
        this.dpsBased = (int) this.stats.get("dps");
    }

    public void ia(Fighters target) {
        int minLp = this.lpBased / 4;
        int midLp = this.lpBased / 2;
        int dps = (int) this.stats.get("dps");

        if ((int) this.stats.get("lifePoint") < minLp) {
            this.healing();
        } else if ((int) this.stats.get("lifePoint") < midLp) {
            this.buffDefense();
        } else if (dps < this.dpsBased) {
            this.buffAtk();
        } else {
            this.attack(target);
        }
        
        
    }

    public Fighters targetChoice(Fighters player, Fighters[] possibleTarget) {
        Fighters[] targets = new Fighters[possibleTarget.length - 1];
        Fighters target = null;
        int counter = 0;
        for (int i = 0; i < possibleTarget.length; i++) {
            if (possibleTarget[i].name != player.name) {
                targets[counter] = possibleTarget[i];
                counter++;
            }
        }
        
        int targetRandom = randomTarget(targets.length);
        target = targets[targetRandom];
        return target;

        // if((int) targets[0].stats.get("lifePoint") < (int) targets[1].stats.get("lifePoint")) {
        //     target = targets[0];
        // } else if((int) targets[0].stats.get("lifePoint") > (int) targets[1].stats.get("lifePoint")){
        //     target = targets[1];
        // } else {

        // }
    }

    public int randomTarget(int numFighters) {
        int max = numFighters - 1;
        int min = 0;
        int numTarget = -1;
        while (numTarget < min || numTarget > max) {
            double randomNum = Math.random();
            numTarget = (int) (randomNum * 10);
        }
        return numTarget; 
    }
    
}
