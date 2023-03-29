using homework07.Interface;

class Wizard : Monk
{



    public Wizard(string name, int x, int y) : base(name, x, y)
    {
        this.attack = 17;
        this.defence = 12;
        this.damage[0] = -5;
        this.damage[1] = -5;
        this.hp = 30;
        this.maxHp = 30;
        this.speed = 8; // was 9
        this.className = "Колдун";
        this.mana = 100;
    }
    public Wizard(int x, int y) : this(Names.getRandName(), x, y) { }

    public override void step(List<BaseUnit> friends, List<BaseUnit> enemies)
    {
        //base.step(friends, enemies);

        if (!this.isAway())
        { Console.WriteLine("Ходит "+ this.className + " " + this.name);
            if (this.mana < 1)
            {
                Console.WriteLine("У " + this.name + " закончилась манна!");
                Console.WriteLine(this.name + " сбегает с поля боя! ");
                this.away = true;
                this.hp = 0;
            }
            else
            {
                int index = this.findWounded(friends);
                if (index == -1)
                {
                    Console.WriteLine("Раненых нет");
                    index = this.findTarget(enemies);
                    if (index == -1)
                    {
                        Console.WriteLine("Целей нет");
                    }
                    else this.MagicAttack(enemies[index]);

                }
                else this.Healing(friends[index]);
            }
        }
    }
    public void MagicAttack(BaseUnit target)
    {

        int damade;
        if (this.attack >= target.getDef())
        {
            damade = this.damage[1];
        }
        else
        {
            damade = this.damage[0];
        }
        damade = -1 * damade;
        Console.WriteLine(this.name + " пускает волшебную стрелу в " + target.getName());
        target.getDamage( damade);
        this.mana = this.mana - 25;
    }
}

