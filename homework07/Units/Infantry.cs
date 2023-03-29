using homework07.Interface;

public class Infantry : BaseUnit
{
    public Infantry(string name, int x, int y) : base(name, x, y)
    {
        this.className="Пехота"; 
    }
    public Infantry(int x, int y) : this(Names.getRandName(), x, y) { }

    public override void step(List<BaseUnit> friends, List<BaseUnit> enemies) {
        
        Console.WriteLine( this.className+ " " + this.name + " ходит");
          if (!this.isAway()){

                int index=this.findTarget(enemies);
                if (index==-1){
                    Console.WriteLine("Целей нет");
                }
                else {
                    if (this.getDistanse(enemies[index])>1.42){
                        this.moving(enemies[index]);
                    }
                    else{
                        this.baseAttack(enemies[index]);
                    }

                }
                
        }
    }

    public void baseAttack(BaseUnit target) {
        
            int damade;
            if (this.attack >= target.getDef()) {
                damade = this.damage[1];
            } else {
                damade = this.damage[0];
            }
            Console.WriteLine(this.name + " атакует " + target.getName());
            target.getDamage(damade);
        
    }
    public int findTarget(List<BaseUnit> ememies) {
        int targetInd = -1;
        double distanse = 100;
        double minDistanse = 100;
        
        for (int index = 0; index < ememies.Count; index++) {
            distanse = this.getDistanse(ememies[index]);
            if (!ememies[index].isAway() && distanse < minDistanse) {
                targetInd = index;
                minDistanse = distanse;
            }
        }
        return targetInd;
    }
    public void moving(BaseUnit target){
        Console.WriteLine( this.name +" идет к противнику " +target.getName());
        int x1=this.position.getX();
        int x2=target.position.getX();
        int y1=this.position.getY();
        int y2=target.position.getY();

        if (Math.Abs(x1-x2)>Math.Abs(y2-y1)){
            if (x1>x2){
                if(BattleField.checkDeskPosition(x1-1,y1))
                this.position.moveLeft();
                else Console.WriteLine("путь прегражден");
            }
            else {
                if(BattleField.checkDeskPosition(x1+1,y1))
                this.position.moveRight();
                else Console.WriteLine("путь прегражден");
                } 
        }
        else {
            if (y1>y2){
                if(BattleField.checkDeskPosition(x1,y1-1))
                this.position.moveDown();
                else Console.WriteLine("путь прегражден");
            }
            else {
                if(BattleField.checkDeskPosition(x1,y1+1))
                this.position.moveUp();
                else Console.WriteLine("путь прегражден");
            } 
        }
    }
}