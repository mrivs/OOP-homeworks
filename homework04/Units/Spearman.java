package homework04.Units;

import homework04.Additional.Names;

public class Spearman extends BaseUnit{

    public Spearman(String name,int x,int y) {
        super(name, x, y);
        this.attack=4;
        this.defence=5;
        this.damage[0]=1;
        this.damage[1]=3;
        this.hp=10;
        this.maxHp=10;
        this.speed=4;
        this.className="Копейщик"; 

    }

    public Spearman(int x,int y) {
        this(Names.getRandName(), x, y);
    }

    // public void spearStrike(BaseUnit target){
    //     float damade=15+(float)this.attack/10*BaseUnit.diceRoll();
    //     System.out.println(this.name+" удар копьем "+target.getName());
    //     target.getDamage((int)damade);
    // }


    
}
