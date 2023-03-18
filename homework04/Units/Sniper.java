package homework04.Units;

import homework04.Additional.Names;

public class Sniper extends Arbalester{

    
    public Sniper(String name,int x,int y) {
        super(name,x, y);
        this.attack=12;
        this.defence=10;
        this.damage[0]=8;
        this.damage[1]=10;
        this.hp=15;
        this.maxHp=15;
        this.speed=9;
        this.className="Снайпер"; 
        this.arrows=3;  
    }

    public Sniper(int x,int y) {
        this(Names.getRandName(),x, y);
    }

}
