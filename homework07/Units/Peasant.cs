using System.Collections;
namespace homework07.Interface;
class Peasant : BaseUnit
{
    private bool delivery;
    public Peasant(string name, int x, int y) : base(name, x, y)
    {
        this.attack = 1;
        this.defence = 1;
        this.damage[0] = 1;
        this.damage[1] = 1;
        this.hp = 1;
        this.maxHp = 1;
        this.speed = 3;
        this.className = "Крестьянин";
        this.delivery = true;

    }
    public Peasant(int x, int y) : this(Names.getRandName(), x, y) { }

    public void deliveryArr() {
        Console.WriteLine(this.name + " доставляет стрелы");
        this.delivery = false;
    }

    
    public override void step(List<BaseUnit>  friends, List<BaseUnit>  enemies) {

        base.step(friends, enemies);
        if (!checkAlifeUnits(friends)) {
            Console.WriteLine(this.name + " сбегает с поля боя!");
            this.away = true;
            this.hp=0;
            return;
        } else {
            if (this.delivery == false) {
                this.delivery = true;
                Console.WriteLine(this.name + " снова готов нести стрелы..");
            } else
                Console.WriteLine(this.name + " ждет...");

        }
    }

    public bool checkAlifeUnits(List <BaseUnit> friends) {
        bool stayInBattle = false;
        foreach (BaseUnit unit in friends)
        {
         if (unit.isAway() == false && !unit.getClassName().Equals("Крестьянин"))
                stayInBattle = true;
            
        }
        return stayInBattle;
    }
    public bool getDelivery(){
        return this.delivery;
    }
}