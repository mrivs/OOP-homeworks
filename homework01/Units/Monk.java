package homework01.Units;

import homework01.Names;

public class Monk extends BaseUnit {

    public Monk(String name, int hp) {
        super(name, hp);
        this.strength=10;
        this.dexterity=8;
        this.viability=10;
        this.intelligence=8;
        this.wisdom=8;
        this.charisma=8;
        this.className="Monk";
    }

    public Monk() {
        this(Names.getRandName(), 100);
    }

    public void Healing(BaseUnit unit){
        unit.hp=unit.maxHp;
        System.out.println(this.name+ " исцеляет "+ unit.name);
    }
    
}
