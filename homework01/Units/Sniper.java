package homework01.Units;

import homework01.Names;

public class Sniper extends Arbalester{

    
    public Sniper(String name, int hp) {
        super(name, hp);
        this.dexterity=16;
        this.className="Sniper";
        this.arrival();
     
    }

    public Sniper() {
        this(Names.getRandName(),100);
    }


    
}
