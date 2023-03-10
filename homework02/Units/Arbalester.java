package homework02.Units;

import homework02.Names;

public class Arbalester extends BaseUnit {

    protected int arrows;
    
    public Arbalester(String name, int hp) {
        super(name, hp);
        this.strength=10;
        this.dexterity=12;
        this.viability=10;
        this.intelligence=10;
        this.wisdom=10;
        this.charisma=8;
        this.className="Арбалетчик";
        this.arrows=20;
    }

    public Arbalester() {
        this(Names.getRandName(),100);
    }
    public void shooting(BaseUnit target){
        if (this.arrows>0){
        this.arrows--;
        float damade=12+(float)this.dexterity/10*BaseUnit.diceRoll();
        System.out.println(this.name+" стреляет в "+target.getName());
        target.getDamage((int)damade);
       }
       else System.out.println("Стрелы закончились!");
    }
    
    @Override
    public String toString() {
        String str=super.toString()+ " стрел: "+this.arrows;
        return str;
    }


    
}
