package homework01.Units;

import homework01.Names;

public class Wizard extends BaseUnit{
    private int mana;
    private int maxMana;
    public Wizard(String name, int hp) {

        super(name, hp);
        this.strength=8;
        this.dexterity=10;
        this.viability=8;
        this.intelligence=14;
        this.wisdom=10;
        this.charisma=10;
        this.maxMana=100;
        this.mana=this.maxMana;
        this.className="Wizard"; 
        this.arrival();
    }
    public Wizard() {
        this(Names.getRandName(),100);
    }

    @Override
    public String getInfo() {
        String str=super.getInfo()+ " manna "+this.mana;
        return str;
    }  
    
}
