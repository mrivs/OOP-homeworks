package homework04.Units;

import homework04.Additional.Names;


public class Peasant extends BaseUnit {

    public boolean delivery;

    public Peasant(String name,int x,int y) {
    super(name,x, y);
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
public Peasant(int x,int y) {
    this(Names.getRandName(), x, y);
}

void deliveryArr(){
    System.out.println(this.getInfo()+" Доставляет стрелы");
    this.delivery=false;
}


}
