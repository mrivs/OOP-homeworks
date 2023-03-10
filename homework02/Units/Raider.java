package homework02.Units;

import homework02.Names;

public class Raider extends BaseUnit{

    public Raider(String name, int hp) {
        super(name, hp);
        this.strength=12;
        this.dexterity=14;
        this.viability=10;
        this.intelligence=10;
        this.wisdom=10;
        this.charisma=10;
        this.className="Разбойник"; 

    }

    public Raider() {
        this(Names.getRandName(), 120);
    }

    public void daggerStrike(BaseUnit target){
        float damade=10+(float)this.dexterity/10*(float)this.strength/10*BaseUnit.diceRoll();
        System.out.println(this.name+" удар кинжалом "+target.getName());
        target.getDamage((int)damade);
    }
    
}
