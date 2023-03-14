package homework03.Units;

import homework03.Names;


public class Peasant extends BaseUnit {

    boolean delivery;

    public Peasant(String name) {
    super(name);
    this.attack=1;
    this.defence=1;
    this.damage[0]=1;
    this.damage[1]=1;
    this.hp=1;
    this.maxHp=1;
    this.speed=3;
    this.className="Крестьянин";
    this.delivery=true;
}
public Peasant() {
    this(Names.getRandName());
}
 
}
