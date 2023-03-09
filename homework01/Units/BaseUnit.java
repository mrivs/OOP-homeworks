package homework01.Units;

import java.util.Random;

import homework01.Names;

public abstract class BaseUnit {
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

  public String getInfo() {
    String str = this.name + " " + this.className + " hp " + this.hp + " str,dex,via,int: " + this.strength + " "
        + this.dexterity + " " + this.viability + " " + this.intelligence;
    return str;
  }

  public String getName() {
    return this.name;
  }

  public void waiting() {
    System.out.println(this.name + " ждет...");
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

  public void arrival() {
    System.out.println(this.className + " " + this.name + " прибыл! ");
  }
}
