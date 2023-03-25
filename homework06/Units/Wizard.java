package homework06.Units;

import homework06.Additional.Names;

public class Wizard extends BaseUnit{
    private int magic;
 
    public Wizard(String name,int x,int y) {

        super(name, x, y);
        this.attack=17;
        this.defence=12;
        this.damage[0]=-5;
        this.damage[1]=-5;
        this.hp=30;
        this.maxHp=30;
        this.speed=8; // was 9
        this.className="Колдун"; 
        this.magic=1;

    }
    public Wizard(int x,int y) {
        this(Names.getRandName(), x, y);
    }
   
}
