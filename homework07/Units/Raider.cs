class Raider : Infantry
{
    public Raider(int x, int y) : this(Names.getRandName(), x, y) { } 


    public Raider(string name, int x, int y) : base(name, x, y)
    {
        this.attack=8;
        this.defence=3;
        this.damage[0]=2;
        this.damage[1]=4;
        this.hp=10;
        this.maxHp=10;
        this.speed=6;
        this.className="Разбойник"; 
    }
}