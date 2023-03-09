package homework01.Units;

import homework01.Names;

public class Sniper extends Arbalester{

    
    public Sniper(String name, int hp) {
        super(name, hp);
        this.dexterity=14;
        this.className="Sniper ";
     
    }

    public Sniper() {
        this(Names.getRandName(),100);
    }


    
}
