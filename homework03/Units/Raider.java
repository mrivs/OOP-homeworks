package homework03.Units;

import homework03.Names;

public class Raider extends BaseUnit{

    public Raider(String name) {
        super(name);
        this.attack=8;
        this.defence=3;
        this.damage[0]=2;
        this.damage[1]=4;
        this.hp=10;
        this.maxHp=10;
        this.speed=6;
        this.className="Разбойник"; 

    }

    public Raider() {
        this(Names.getRandName());
    }

    // public void daggerStrike(BaseUnit target){
    //     float damade=10+(float)this.defence/10*(float)this.attack/10*BaseUnit.diceRoll();
    //     System.out.println(this.name+" удар кинжалом "+target.getName());
    //     target.getDamage((int)damade);
    // }
    
}
