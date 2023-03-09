package homework01.Units;

import homework01.Names;

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
        this.className="Arbalester";
        this.arrows=20;
    }

    public Arbalester() {
        this(Names.getRandName(),100);
    }
    public void shooting(){
        this.arrows--;
        System.out.println(this.className+" "+this.name+" стреляет...");
    }

    @Override
    public String getInfo() {
        String str=super.getInfo()+ " arrows "+this.arrows;
        return str;
    }  
    
}
