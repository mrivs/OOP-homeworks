package homework05.Additional;

import homework05.Units.*;
import homework05.Comparators.SpeedComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BattleField {
    public static int battleStep = 0;
    public static int tm1Step = 0;
    public static int tm2Step = 0;

    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseUnit> team1 = new ArrayList<>();
    public static ArrayList<BaseUnit> team2 = new ArrayList<>();

    public static void start() {

        fillBalanceHeroesList(team1, GANG_SIZE, "Peasant, Sniper, Arbalester", 1);
        fillBalanceHeroesList(team2, GANG_SIZE, "Peasant, Sniper, Arbalester", 10);

        team1.sort(new SpeedComparator());
        team2.sort(new SpeedComparator());

    }

    public static void fillSpecialHeroesList(ArrayList<BaseUnit> list, int size, String classes, int column) {
        classes = classes.replaceAll("\\s+", "");
        ArrayList<String> HerList = new ArrayList<String>(Arrays.asList(classes.split(",")));
        Random rand = new Random();
        int r;
        int row = 1;
        for (int i = 0; i < size; i++) {
            r = rand.nextInt(0, HerList.size());
            if (HerList.get(r).equals("Peasant")) {
                list.add(new Peasant(column, row));
            } else if (HerList.get(r).equals("Arbalester")) {
                list.add(new Arbalester(column, row));
            } else if (HerList.get(r).equals("Spearman")) {
                list.add(new Spearman(column, row));
            } else if (HerList.get(r).equals("Raider")) {
                list.add(new Raider(column, row));
            } else if (HerList.get(r).equals("Sniper")) {
                list.add(new Sniper(column, row));
            } else if (HerList.get(r).equals("Wizard")) {
                list.add(new Wizard(column, row));
            } else if (HerList.get(r).equals("Monk")) {
                list.add(new Monk(column, row));
            } else {
                System.out.println("присутствует неверный класс!");
            }
            row++;
        }
    }

    public static void fillBalanceHeroesList(ArrayList<BaseUnit> list, int teamSize, String classes, int column) {
        classes = classes.replaceAll("\\s+", "");
        ArrayList<String> HerList = new ArrayList<String>(Arrays.asList(classes.split(",")));
        int r = 0;
        int row = 1;
        for (int i = 0; i < teamSize; i++) {
            if (r == HerList.size()) {
                r = 0;
            }
            if (HerList.get(r).equals("Peasant")) {
                list.add(new Peasant(column, row));
            } else if (HerList.get(r).equals("Arbalester")) {
                list.add(new Arbalester(column, row));
            } else if (HerList.get(r).equals("Spearman")) {
                list.add(new Spearman(column, row));
            } else if (HerList.get(r).equals("Raider")) {
                list.add(new Raider(column, row));
            } else if (HerList.get(r).equals("Sniper")) {
                list.add(new Sniper(column, row));
            } else if (HerList.get(r).equals("Wizard")) {
                list.add(new Wizard(column, row));
            } else if (HerList.get(r).equals("Monk")) {
                list.add(new Monk(column, row));
            } else {
                System.out.println("присутствует неверный класс!");
            }
            row++;
            r++;
        }
    }

    public static void getListInfo(ArrayList<BaseUnit> list) {
        int n = 1;
        for (BaseUnit unit : list) {
            System.out.println(n + " " + unit.toString());
            n++;
        }
        System.out.println("----------------");
    }

    public static void nextStep() {
        if (battleStep == 45) {
            // debug
            battleStep = battleStep;
        }
        if (battleStep % 2 == 0) {
            tm1Step = teamStep(team1, team2, tm1Step);
            battleStep++;
        } else {
            tm2Step = teamStep(team2, team1, tm2Step);
            battleStep++;
        }

    }

    public static int teamStep(ArrayList<BaseUnit> mainTeam, ArrayList<BaseUnit> enTeam, int tmStep) {
        int deads = 0;

        while (true) {
            if (tmStep >= mainTeam.size())
                tmStep = 0;
            if (mainTeam.get(tmStep).isDead() == false) {
                mainTeam.get(tmStep).step(mainTeam, enTeam);
                tmStep++;
                return tmStep;
            } else {
                tmStep++;
                deads++;
                if (deads > 10) {
                    System.out.println("Все мертвы");
                    return tmStep;
                }

            }
        }

    }

}
