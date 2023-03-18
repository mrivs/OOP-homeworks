package homework04.Units;

import homework04.Additional.Names;

public class Raider extends BaseUnit{

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

    // public void daggerStrike(BaseUnit target){
    //     float damade=10+(float)this.defence/10*(float)this.attack/10*BaseUnit.diceRoll();
    //     System.out.println(this.name+" удар кинжалом "+target.getName());
    //     target.getDamage((int)damade);
    // }
    
}
