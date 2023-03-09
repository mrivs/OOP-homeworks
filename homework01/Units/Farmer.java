package homework01.Units;

import homework01.Names;

public class Farmer extends BaseUnit {

public Farmer(String name, int hp) {
    super(name, hp);
    this.strength=10;
    this.dexterity=8;
    this.viability=10;
    this.intelligence=8;
    this.wisdom=8;
    this.charisma=8;
    this.className="Farmer";
    this.arrival();
}
public Farmer() {
    this(Names.getRandName(),100);
}

public void working(){
    System.out.println(this.className+" "+this.name+" пашет...");
   }  
}
