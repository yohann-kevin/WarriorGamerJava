public class Magician extends Fighters {
    String classesName = "Magician";
    
    Magician(String name) {
        super(name);
        this.stats.put("lifePoint", 50);
        this.stats.put("dps", 20);
        this.stats.put("heal", 10);
        this.stats.put("buffDef", 10);
        this.stats.put("buffDps", 15);
        this.stats.put("debuffDps", 20);
        this.stats.put("debuffDef", 20);
        this.stats.put("malusDps", 0);
        this.stats.put("malusDef", 0);

        this.stats.put("defenseIsBuffed", false);
    }

    public void start() {
        this.init(this.classesName);
    }
}
