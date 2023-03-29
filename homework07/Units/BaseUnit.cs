namespace homework07.Interface;

using System.Collections;


public abstract class BaseUnit : StepInfo
{
    protected int attack;
    protected int defence;
    protected int[] damage = new int[2];
    public Position position;
    public int hp;
    protected int maxHp;
    protected string name;
    protected int speed;
    protected string className;
    protected bool away = false;
    public BaseUnit(string name, int x, int y)
    {
        this.name = name;
        this.position = new Position(x, y);
    }
    public BaseUnit(int x, int y) : this(Names.getRandName(), x, y) { }

    public void getDamage(int damage)
    {
        this.hp = this.hp - damage;
        if (this.hp < 0)
            this.hp = 0;
        
        if (this.hp == 0)
            this.away = true;
        if (this.hp > this.maxHp) this.hp = maxHp;
        if (damage>=0)Console.WriteLine(this.name + " получил урон: " + damage + " здоровья осталось: " + this.hp);
        else Console.WriteLine(this.name + " исцелен на " + -1*damage + " hp, здоровье: " + this.hp);
    }

    public virtual string getInfo()
    {
        return string.Format(" {0}\t{1}\t⚔️  {2}\t\uD83D\uDEE1 {3}\t♥️ {4}%\t☠️  {5}\t ",
        AdFormat.lenForm( this.className,12),AdFormat.lenForm(this.name,12), this.attack, this.defence, (this.hp * 100 / this.maxHp), (this.damage[0] + this.damage[1]) / 2);
        // return String.format("\t%-12s\t⚔️  %-3d\t\uD83D\uDEE1 %-3d\t♥️ %-3d%%", , this.attack, this.defence, (this.hp * 100 / this.maxHp));
    }

    public string toString()
    {
        string str = string.Format("{0} {1} Здоровье: {2}/{3} Скорость: {4} x {5} y {6} ", this.name, this.className, this.hp, this.maxHp, this.speed, this.position.getX(), this.position.getY());
        return str;
    }

    public virtual void step(List<BaseUnit> friends, List<BaseUnit> enemies)
    {
        Console.WriteLine("Ходит "+ this.className + " " + this.name);
    }
    public string getName() { return this.name; }
    public string getClassName() { return this.className; }
    public Position getPosition() { return this.position; }
    public bool isAway() { return this.away; }
    public int getDef() { return this.defence; }
    public int getMaxHp() { return this.maxHp; }
    public int getHp() { return this.hp; }
    public int getSpeed() { return this.speed; }
    public double getDistanse(BaseUnit unit) { return this.position.getDistanse(unit.position); }
}
