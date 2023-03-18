package homework04.Units;
import java.util.ArrayList;

import homework04.Additional.Names;
import homework04.Additional.Position;
import homework04.Interface.StepInfo;

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

  protected int hp;
  protected int maxHp;
  protected String name;
  protected int speed;
  protected String className;

  boolean isDead = false;
  
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
      this.isDead = true;
  }

  
  @Override
  public String getInfo() {

    return this.className + " " + this.name;
  }

  @Override
  public String toString() {

      String str = String.format(" %s %s Здоровье: %d/%d Скорость: %d ", this.name,this.className,this.hp,this.maxHp,this.speed);
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
  System.out.println(this.className+" ходит");
    
}




  
  
}
