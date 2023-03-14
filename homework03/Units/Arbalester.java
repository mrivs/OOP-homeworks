package homework03.Units;

import homework03.Names;

public class Arbalester extends BaseUnit {

    protected int arrows;
    
    public Arbalester(String name) {
        super(name);
        this.attack=6;
        this.defence=3;
        this.damage[0]=2;
        this.damage[1]=3;
        this.hp=10;
        this.maxHp=10;
        this.speed=4;
        this.className="Арбалетчик";
        this.arrows=16;
    }

    public Arbalester() {
        this(Names.getRandName());
    }
    // public void shooting(BaseUnit target){
    //     if (this.arrows>0){
    //     this.arrows--;
    //     float damade=12+(float)this.defence/10*BaseUnit.diceRoll();
    //     System.out.println(this.name+" стреляет в "+target.getName());
    //     target.getDamage((int)damade);
    //    }
    //    else System.out.println("Стрелы закончились!");
    // }
    
    @Override
    public String toString() {
        String str=super.toString()+ " стрел: "+this.arrows;
        return str;
    }


    
}
