using homework07.Interface;

class Monk : DistanseUnit
{   protected int mana;
    public Monk(string name, int x, int y) : base(name, x, y)
    {
        this.attack = 12;
        this.defence = 7;
        this.damage[0] = -4;
        this.damage[1] = -4;
        this.hp = 30;
        this.maxHp = 30;
        this.speed = 5;
        this.mana=100;
        this.className = "Монах";
    }
    public Monk(int x, int y) : this(Names.getRandName(), x, y) { }

    public void Healing(BaseUnit unit)
    {
    Console.WriteLine(this.name + " исцеляет " + unit.getName());
    unit.getDamage(damage[0]); 
    this.mana=this.mana-25;
    }

    public int findWounded(List<BaseUnit> targets)
    {
        int targetInd = -1;
        int wound = 100;
        int temp = 100;
       
        Console.WriteLine(this.getName() + " ищет раненых");
        for (int index = 0; index < targets.Count(); index++)
        {

            if ((!targets[index].isAway()) && (targets[index].getHp() - targets[index].getMaxHp() < 0))
            {
                temp = 100 * (targets[index].getMaxHp() - targets[index].getHp()) / targets[index].getMaxHp();
                if (wound > temp)
                {
                    wound = temp;
                    targetInd = index;
                }
            }

        }
        return targetInd;
    }

    public override void step(List<BaseUnit> friends, List<BaseUnit> enemies)
    {
        base.step(friends, enemies);
        if (!checkAlifeUnits(friends)) {
            Console.WriteLine(this.name + " сбегает с поля боя!");
            this.away = true;
            this.hp=0;
            return;
        }
        else if (!this.isAway())
        {
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
                }
                else this.Healing(friends[index]);
            }
        }
    }

        public bool checkAlifeUnits(List <BaseUnit> friends) {
        bool stayInBattle = false;
        foreach (BaseUnit unit in friends)
        {
         if (unit.isAway() == false && (!unit.getClassName().Equals("Крестьянин")||!unit.getClassName().Equals("Монах")))
                stayInBattle = true;
            
        }
        return stayInBattle;
    }

    
}