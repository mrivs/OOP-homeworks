package homework02.Units;

import java.util.Random;
import homework02.Names;
import homework02.Interface.StepInfo;

public abstract class BaseUnit implements StepInfo {
  /**
   * @param strength     сила
   * @param dexterity    ловкость
   * @param viability    выносливость
   * @param intelligence интеллект
   * @param wisdom       мудрость
   * @param charisma     харизма
   */

  protected int strength;
  protected int dexterity;
  protected int viability;
  protected int intelligence;
  protected int wisdom;
  protected int charisma;

  protected int hp;
  protected int maxHp;
  protected String name;
  protected String speed;
  protected String className;

  boolean isDead = false;
  private static final Random rnd = new Random();

  public BaseUnit(String name, int hp) {
    this.name = name;
    this.hp = hp;
    this.maxHp = hp;
  }

  public BaseUnit() {
    this(Names.getRandName(), 50);
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

      String str = String.format("Имя: %s; Класс: %s; Здоровье %d/%d ", this.name,this.className,this.hp,this.maxHp);
    return str;
  }
}
