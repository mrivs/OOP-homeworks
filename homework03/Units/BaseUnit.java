package homework03.Units;

import java.util.Random;
import homework03.Names;
import homework03.Interface.StepInfo;

public abstract class BaseUnit implements StepInfo {
  /**
   * @param attack   атака
   * @param defence  защита
   * @param damage   урон

   */

  protected int attack;
  protected int defence;
  protected int[] damage=new int[2];


  protected int hp;
  protected int maxHp;
  protected String name;
  protected int speed;
  protected String className;

  boolean isDead = false;
  private static final Random rnd = new Random();

  public BaseUnit(String name) {
    this.name = name;

  }

  public BaseUnit() {
    this(Names.getRandName());
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

  public static int diceRoll() {
    return BaseUnit.rnd.nextInt(21);
  }
  
  @Override
  public void step() {
    System.out.println(this.className+" ходит ");
  }

  @Override
  public String getInfo() {

    return this.className+" "+this.name;
  }

  @Override
  public String toString() {

      String str = String.format(" %s %s Здоровье: %d/%d Скорость: %d ", this.name,this.className,this.hp,this.maxHp,this.speed);
    return str;
  }

  public int getSpeed() {
    return this.speed;
  }


  
  
}
