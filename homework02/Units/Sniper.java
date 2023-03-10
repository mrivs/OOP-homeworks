package homework02.Units;

import homework02.Names;

public class Sniper extends Arbalester{

    
    public Sniper(String name, int hp) {
        super(name, hp);
        this.dexterity=16;
        this.className="Снайпер";   
    }

    public Sniper() {
        this(Names.getRandName(),100);
    }

}
