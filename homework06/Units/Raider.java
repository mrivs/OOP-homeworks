package homework06.Units;

import homework06.Additional.Names;

public class Raider extends Infantry{

    public Raider(String name,int x,int y) {
        super(name, x, y);
        this.attack=8;
        this.defence=3;
        this.damage[0]=2;
        this.damage[1]=4;
        this.hp=10;
        this.maxHp=10;
        this.speed=6;
        this.className="Разбойник"; 

    }

    public Raider(int x,int y) {
        this(Names.getRandName(),x,y);
    }
    
}
