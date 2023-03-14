package homework03.Units;

import homework03.Names;

public class Monk extends BaseUnit {

    public Monk(String name) {
        super(name);
        this.attack=12;
        this.defence=7;
        this.damage[0]=-4;
        this.damage[1]=-4;
        this.hp=30;
        this.maxHp=30;
        this.speed=5;
        this.className="Монах";

    }

    public Monk() {
        this(Names.getRandName());
    }

    public void Healing(BaseUnit unit){
        unit.hp=unit.maxHp;
        System.out.println(this.name+ " исцеляет "+ unit.name);
    }
    
}
