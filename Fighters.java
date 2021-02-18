import java.util.HashMap;
import java.util.Map;

public class Fighters {
    public String name;
    public Map<String, Object> stats = new HashMap<String, Object>();
    // public boolean defenseIsBuffed = false;
    // public boolean dpsIsDebuffed = false;
    // public boolean defenseIsDebuffed = false;
    // public int malusDps = 0;
    // public int malusDef = 0;

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
        // this.defenseIsBuffed = true;
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
        return malus;
    }

    public void atkDebuffed(int malus) {
        this.stats.put("malusDps", malus);
    }

    public int debuffDef() {
        double coefficient = Math.random();
        int malus = (int) ((int) this.stats.get("debuffDps") * coefficient);
        return malus;
    }

    public void defDebuffed(int malus) {
        this.stats.put("malusDef", malus);
    }
    
}
