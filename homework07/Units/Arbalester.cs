namespace homework07.Interface;

using System.Collections;
public class Arbalester : DistanseUnit
{
    protected int arrows;

    public Arbalester(string name, int x, int y) : base(name, x, y)
    {
        this.attack = 6;
        this.defence = 3;
        this.damage[0] = 2;
        this.damage[1] = 3;
        this.hp = 10;
        this.maxHp = 10;
        this.speed = 4;
        this.className = "Арбалетчик";
        this.arrows = 8;
    }
    public Arbalester(int x, int y) : this(Names.getRandName(), x, y) { }
    public void shooting(BaseUnit target)
    {
        if (this.arrows > 0)
        {
            this.arrows--;
            int damade;
            if (this.attack >= target.getDef())
            {
                damade = this.damage[1];
            }
            else
            {
                damade = this.damage[0];
            }

            Console.WriteLine(this.name + " стреляет в " + target.getName());
            target.getDamage(damade);
        }
    }

    public bool findPeasant(List<BaseUnit> friends)
    {
        bool alifePeasants = false;
        for (int index = 0; index < friends.Count(); index++)
        {

            BaseUnit unit = friends[index];
            if (!unit.isAway() && unit.getClassName().Equals("Крестьянин"))
            {
                if (((Peasant)unit).getDelivery() == true)
                {
                    ((Peasant)unit).deliveryArr();
                    this.arrows += 3;
                    return true;
                }
                else alifePeasants = true;
            }

        }
        if (alifePeasants) Console.WriteLine("Свободных крестьян нет");
        return alifePeasants;

    }

    public override void step(List<BaseUnit> friends, List<BaseUnit> enemies)
    {
        base.step(friends, enemies);
        if (!this.isAway())
        {
            if (this.arrows < 1)
            {
                Console.WriteLine("У " + this.name + " закончились стрелы!");
                if (!this.findPeasant(friends))
                {
                    Console.WriteLine("Живых крестьян нет! " + this.name + " сбегает с поля боя! ");
                    this.away = true;
                    this.hp = 0;
                };

            }
            else
            {
                int index = this.findTarget(enemies);
                if (index == -1)
                {
                    Console.WriteLine("Целей нет");
                }
                else this.shooting(enemies[index]);
            }
        }
    }

}