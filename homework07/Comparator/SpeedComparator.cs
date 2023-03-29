using homework07.Interface;

class SpeedComparator: IComparer <BaseUnit>
{
    public int Compare(BaseUnit? p1, BaseUnit? p2)
    {
        return p2.getSpeed() - p1.getSpeed();
    }
}