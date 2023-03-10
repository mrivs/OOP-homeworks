package homework02.Units;

import homework02.Names;

public class Spearman extends BaseUnit{

    public Spearman(String name, int hp) {
        super(name, hp);
        this.strength=16;
        this.dexterity=10;
        this.viability=10;
        this.intelligence=10;
        this.wisdom=10;
        this.charisma=10;
        this.className="Копейщик"; 

    }

    public Spearman() {
        this(Names.getRandName(), 130);
    }

    public void spearStrike(BaseUnit target){
        float damade=15+(float)this.strength/10*BaseUnit.diceRoll();
        System.out.println(this.name+" удар копьем "+target.getName());
        target.getDamage((int)damade);
    }


    
}
