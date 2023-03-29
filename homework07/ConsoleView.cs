using static AnsiColrs;

public class ConsoleView
{
    private static int step = 0;
    private static readonly String top10 = formatDiv("a") + String.Join("", nCopies(9, formatDiv("-b")))
            + formatDiv("-c");
    private static readonly String mid10 = formatDiv("d") + String.Join("", nCopies(9, formatDiv("-e")))
            + formatDiv("-f");
    private static readonly String bottom10 = formatDiv("g") + String.Join("", nCopies(9, formatDiv("-h")))
            + formatDiv("-i");

    public static void view()
    {
        if (step++ == 0)
        {
            Console.Write(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
            Console.Write(AnsiColors.ANSI_GREEN +
                     String.Join("", nCopies(20, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
            Console.WriteLine(AnsiColors.ANSI_BLUE +
                    String.Join("", nCopies(55, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
        }
        else
        {
            Console.Write(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
            Console.Write(AnsiColors.ANSI_GREEN +
                    string.Join("", nCopies(20, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
            Console.WriteLine(AnsiColors.ANSI_BLUE +
                    string.Join("", nCopies(55, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
        }

        Console.WriteLine(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= BattleField.GANG_SIZE - 1; i++)
        {
            for (int j = 1; j <= BattleField.GANG_SIZE; j++)
            {
                Console.Write(getChar(new Position(j, i)));
            }
            Console.Write("|");
            Console.WriteLine(PrintInfo(npcIndex));
            Console.WriteLine(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= BattleField.GANG_SIZE; j++)
        {
            Console.Write(getChar(new Position(j, BattleField.GANG_SIZE)));
        }
        Console.Write("|");
        Console.WriteLine(PrintInfo(npcIndex));
        Console.WriteLine(ConsoleView.bottom10);
    }

    private static String getChar(Position position)
    {

        string str = "| ";
        bool alive = false;
        for (int i = 0; i < BattleField.GANG_SIZE; i++)
        {
            if (BattleField.team1[i].getPosition().Equals(position))
            {
                if (BattleField.team1[i].hp == 0)
                    str = "|" + AnsiColors.ANSI_RED + BattleField.team1[i].getName().ToUpper()[0]
                            + AnsiColors.ANSI_RESET;
                else
                {
                    str = "|" + AnsiColors.ANSI_GREEN + BattleField.team1[i].getName().ToUpper()[0]
                            + AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (BattleField.team2[i].getPosition().Equals(position) && !alive)
            {
                if (BattleField.team2[i].hp == 0)
                    str = "|" + AnsiColors.ANSI_RED + BattleField.team2[i].getName().ToUpper()[0]
                            + AnsiColors.ANSI_RESET;
                else
                    str = "|" + AnsiColors.ANSI_BLUE + BattleField.team2[i].getName().ToUpper()[0]
                            + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static string PrintInfo(int npcIndex)
    {
        String str = "";

        if (BattleField.team1[npcIndex].hp == 0)
            str += "     " + AnsiColors.ANSI_RED + BattleField.team1[npcIndex].getInfo() + AnsiColors.ANSI_RESET;
        else
            str += "     " + AnsiColors.ANSI_GREEN + BattleField.team1[npcIndex].getInfo() + AnsiColors.ANSI_RESET;
        if (BattleField.team2[npcIndex].hp == 0)
            str += "     " + AnsiColors.ANSI_RED + BattleField.team2[npcIndex].getInfo() + AnsiColors.ANSI_RESET;
        else
            str += "     " + AnsiColors.ANSI_BLUE + BattleField.team2[npcIndex].getInfo() + AnsiColors.ANSI_RESET;

        return str;
    }

    private static string formatDiv(string str)
    {
        return str.Replace('a', '\u250c')
                .Replace('b', '\u252c')
                .Replace('c', '\u2510')
                .Replace('d', '\u251c')
                .Replace('e', '\u253c')
                .Replace('f', '\u2524')
                .Replace('g', '\u2514')
                .Replace('h', '\u2534')
                .Replace('i', '\u2518')
                .Replace('-', '\u2500')
                .Replace("s", "...")
                .Replace("o", "___");
    }

    public static List<string> nCopies(int n, string str)
    {
        List<string> list = new List<string>();
        for (int i = 0; i < n; i++)
        {
            list.Add(str);
        }
        return list;
    }


}