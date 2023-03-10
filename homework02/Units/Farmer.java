package homework02.Units;

import homework02.Names;


public class Farmer extends BaseUnit {

public Farmer(String name, int hp) {
    super(name, hp);
    this.strength=10;
    this.dexterity=8;
    this.viability=10;
    this.intelligence=8;
    this.wisdom=8;
    this.charisma=8;
    this.className="Крестьянин";

}
public Farmer() {
    this(Names.getRandName(),100);
}
 
}
