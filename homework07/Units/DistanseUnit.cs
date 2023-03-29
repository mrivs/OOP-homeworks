using homework07.Interface;

public abstract class DistanseUnit : BaseUnit
{   int arrows;
    public DistanseUnit(string name, int x, int y) : base(name, x, y)
    {
        this.className="Дальний Юнит"; 
    }

    public DistanseUnit(int x, int y) : this(Names.getRandName(), x, y) { }



        public int findTarget(List<BaseUnit> targets) {
        int targetInd = -1;
        double distanse = 100;
        double minDistanse = 100;
        Console.WriteLine(this.getName()+" ищет цель");
        for (int index = 0; index < targets.Count(); index++) {
            distanse = this.getDistanse(targets[index]);
            if (!targets[index].isAway() && distanse < minDistanse) {
                targetInd = index;
                minDistanse = distanse;
            }
        }
        return targetInd;
    }
}