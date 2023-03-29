using homework07.Interface;

class Sniper : Arbalester
{    
    public Sniper(string name, int x, int y) : base(name, x, y)
    {
        this.attack=12;
        this.defence=10;
        this.damage[0]=8;
        this.damage[1]=10;
        this.hp=15;
        this.maxHp=15;
        this.speed=9;
        this.className="Снайпер"; 
        this.arrows=5;   
    }
    public Sniper(int x, int y) : this(Names.getRandName(), x, y)  { }

}