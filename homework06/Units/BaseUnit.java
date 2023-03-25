package homework06.Units;
import java.util.ArrayList;

import homework06.Additional.Names;
import homework06.Additional.Position;
import homework06.Interface.StepInfo;

public abstract class BaseUnit implements StepInfo {
  /**
   * @param attack   атака
   * @param defence  защита
   * @param damage   урон

   */

  protected int attack;
  protected int defence;
  protected int[] damage=new int[2];
  protected Position position;

  public int hp;
  protected int maxHp;
  protected String name;
  protected int speed;
  protected String className;

  protected boolean isAway = false;
  
  public BaseUnit(String name, int x,int y) {
    this.name = name;
    position=new Position(x, y);
  }

  public BaseUnit(int x,int y) {
    this(Names.getRandName(),x,y);
  }

  public String getName() {
    return this.name;
  }

  public void getDamage(int damage) {
    this.hp = this.hp - damage;
    if (this.hp < 0)
      this.hp = 0;
    System.out.println(this.name + " получил урон: " + damage + " здоровья осталось: " + this.hp);
    if (this.hp == 0)
      this.isAway = true;
  }

  
  @Override
  public String getInfo() {
    return String.format("\t%-12s\t⚔️  %-3d\t\uD83D\uDEE1 %-3d\t♥️ %-3d%%\t☠️  %-3d\t ",
     this.className, this.attack,this.defence,(this.hp * 100 / this.maxHp),(this.damage[0] + this.damage[1])/2);
   // return String.format("\t%-12s\t⚔️  %-3d\t\uD83D\uDEE1 %-3d\t♥️ %-3d%%", , this.attack, this.defence, (this.hp * 100 / this.maxHp));
  }

  @Override
  public String toString() {

      String str = String.format(" %s %s Здоровье: %d/%d Скорость: %d x %d y %d ", this.name,this.className,this.hp,this.maxHp,this.speed,this.position.getX(),this.position.getY());
    return str;
  }

  public int getSpeed() {
    return this.speed;
  }

  public  double getDistanse( BaseUnit unit ){
    //
  return this.position.getDistanse(unit.position);}

@Override
public void step(ArrayList<BaseUnit> friends, ArrayList<BaseUnit> enemies) {
  System.out.println(this.name+" "+this.className+" ходит");
    
}

public Position getPosition() {
    return this.position;
}

public boolean isAway(){
  return this.isAway;
}

}
