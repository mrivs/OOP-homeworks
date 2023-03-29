using homework07.Interface;

class BattleField
{
    public static int battleStep = 0;
    public static int tm1Step = 0;
    public static int tm2Step = 0;

    public static int[,] desk = new int[12, 12];
    public static readonly int GANG_SIZE = 10;
    public static List<BaseUnit> team1 = new List<BaseUnit>();
    public static List<BaseUnit> team2 = new List<BaseUnit>();

    public static void start()
    {

        fillBalanceHeroesList(team1, GANG_SIZE, " Spearman, Spearman, Spearman,Monk,Sniper,Peasant", 1);
        fillBalanceHeroesList(team2, GANG_SIZE, "Raider, Raider,Arbalester,Arbalester,Raider,Wizard,Peasant", 10);

        team1.Sort(new SpeedComparator());
        team2.Sort(new SpeedComparator());
        placeUnits();
    }

    public static void fillSpecialHeroesList(List<BaseUnit> list, int size, String classes, int column)
    {
        classes = classes.Replace(" ", "");
        List<string> HerList = new List<string>(classes.Split(","));
        Random rand = new Random();
        int r;
        int row = 1;
        for (int i = 0; i < size; i++)
        {
            r = rand.Next(0, HerList.Count() - 1);
            if (HerList[r].Equals("Peasant"))
            {
                list.Add(new Peasant(column, row));
            }
            else if (HerList[r].Equals("Arbalester"))
            {
                list.Add(new Arbalester(column, row));
            }
            else if (HerList[r].Equals("Spearman"))
            {
                list.Add(new Spearman(column, row));
            }
            else if (HerList[r].Equals("Raider"))
            {
                list.Add(new Raider(column, row));
            }
            else if (HerList[r].Equals("Sniper"))
            {
                list.Add(new Sniper(column, row));
            }
            else if (HerList[r].Equals("Wizard"))
            {
                list.Add(new Wizard(column, row));
            }
            else if (HerList[r].Equals("Monk"))
            {
                list.Add(new Monk(column, row));
            }
            else
            {
                Console.WriteLine("присутствует неверный класс!");
            }
            row++;
        }
    }

    public static void fillBalanceHeroesList(List<BaseUnit> list, int teamSize, String classes, int column)
    {
        classes = classes.Replace(" ", "");
        List<string> HerList = new List<string>(classes.Split(","));
        int r = 0;
        int row = 1;
        for (int i = 0; i < teamSize; i++)
        {
            if (r == HerList.Count())
            {
                r = 0;
            }
            if (HerList[r].Equals("Peasant"))
            {
                list.Add(new Peasant(column, row));
            }
            else if (HerList[r].Equals("Arbalester"))
            {
                list.Add(new Arbalester(column, row));
            }
            else if (HerList[r].Equals("Spearman"))
            {
                list.Add(new Spearman(column, row));
            }
            else if (HerList[r].Equals("Raider"))
            {
                list.Add(new Raider(column, row));
            }
            else if (HerList[r].Equals("Sniper"))
            {
                list.Add(new Sniper(column, row));
            }
            else if (HerList[r].Equals("Wizard"))
            {
                list.Add(new Wizard(column, row));
            }
            else if (HerList[r].Equals("Monk"))
            {
                list.Add(new Monk(column, row));
            }
            else
            {
                Console.WriteLine("присутствует неверный класс!");
            }
            row++;
            r++;
        }
    }

    public static void getListInfo(List<BaseUnit> list)
    {
        int n = 1;
        foreach (BaseUnit unit in list)
        {
            Console.WriteLine(n + " " + unit.toString());
            n++;
        }

        Console.WriteLine("----------------");
    }

    public static int nextStep()
    {
        // placeUnits();
        if (battleStep % 2 == 0)
        {
            tm1Step = teamStep(team1, team2, tm1Step);

        }
        else
        {
            tm2Step = teamStep(team2, team1, tm2Step);

        }
        battleStep++;
        placeUnits();
        return checkWinner();

        // System.out.println(Arrays.deepToString(desk).replace("], ", "]\n"));
    }

    public static int teamStep(List<BaseUnit> mainTeam, List<BaseUnit> enTeam, int tmStep)
    {
        int deads = 0;

        while (true)
        {
            if (tmStep >= mainTeam.Count())
                tmStep = 0;
            if (mainTeam[tmStep].isAway() == false)
            {
                mainTeam[tmStep].step(mainTeam, enTeam);
                tmStep++;
                return tmStep;
            }
            else
            {
                tmStep++;
                deads++;
                if (deads > 10)
                {
                    Console.WriteLine("Все мертвы");
                    return tmStep;
                }

            }
        }

    }

    public static void placeUnits()
    {
        int x;
        int y;

        for (int i = 0; i < desk.GetLength(0); i++)
        {
            for (int j = 0; j < desk.GetLength(1); j++)
            {
                desk[i, j] = 0;
            }
        }

        foreach (BaseUnit unit in team1)
        {
            x = unit.getPosition().getX();
            y = unit.getPosition().getY();
            if (!unit.isAway())
            {
                desk[y, x] = 1;
            }
        }
        foreach (BaseUnit unit in team2)
        {
            x = unit.getPosition().getX();
            y = unit.getPosition().getY();
            if (!unit.isAway())
            {
                desk[y, x] = 2;
            }
        }
        
    }

    public static bool checkDeskPosition(int x, int y)
    {
        if (desk[y, x] == 0)
            return true;
        else
            return false;

    }

    public static void nextRound()
    {
        nextStep();
        while (battleStep % 10 != 0)
        {
            nextStep();
        }
    }

    public static int checkWinner()
    {

        bool alldeads = true;
        foreach (BaseUnit unit in team1)
        {
            if (!unit.isAway())
                alldeads = false;
        }
        if (alldeads == true) return 2;

        else
        {
            alldeads = true;
            foreach (BaseUnit unit in team2)
            {
                if (!unit.isAway())
                    alldeads = false;
            }
            if (alldeads == true) return 1;
        }
        return 0;
    }
}