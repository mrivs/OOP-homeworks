package homework03.Units;

import homework03.Names;

public class Wizard extends BaseUnit{
    private int magic;
 
    public Wizard(String name) {

        super(name);
        this.attack=17;
        this.defence=12;
        this.damage[0]=-5;
        this.damage[1]=-5;
        this.hp=30;
        this.maxHp=30;
        this.speed=9;
        this.className="Колдун"; 
        this.magic=1;

    }
    public Wizard() {
        this(Names.getRandName());
    }
   
}
