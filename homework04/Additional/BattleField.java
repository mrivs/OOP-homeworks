package homework04.Additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import homework04.Comparators.SpeedComparator;
import homework04.Units.*;


public class BattleField {
    
    public static void start(){
    ArrayList<BaseUnit> team1=new ArrayList<>();
    ArrayList<BaseUnit> team2=new ArrayList<>();

    //fillSpecialHeroesList(team1, 10,"Peasant, Raider, Sniper, Wizard",1);
   // fillSpecialHeroesList(team2, 10,"Peasant, Spearman, Arbalester, Monk ",10);
    BaseUnit vasya=new Arbalester("VASYA", 1, 1);
    team1.add( vasya);

    //team1.sort(new SpeedComparator());
   // team2.sort(new SpeedComparator());

    System.out.println("Команда 1:");
    getListInfo(team1);
    System.out.println("Команда 2:");
    getListInfo(team2);

    }
    

    public static void fillSpecialHeroesList(ArrayList<BaseUnit>list,int size,String classes,int column) {
        classes=classes.replaceAll("\\s+","");
        ArrayList<String> HerList = new ArrayList<String>(Arrays.asList(classes.split(",")));
        Random rand = new Random();
        int r;
        int row=1;
        for (int i = 0; i < size; i++) {
            r=rand.nextInt(0,HerList.size());
            if (HerList.get(r).equals("Peasant")){ list.add(new Peasant(0,0));}
            else if (HerList.get(r).equals("Arbalester")){ list.add(new Arbalester("VASYA",column,row));}
            else if (HerList.get(r).equals("Spearman")){ list.add(new Spearman(column,row));}
            else if (HerList.get(r).equals("Raider")){ list.add(new Raider(column,row));}
            else if (HerList.get(r).equals("Sniper")){ list.add(new Sniper(column,row));}
            else if (HerList.get(r).equals("Wizard")){ list.add(new Wizard(column,row));}
            else if (HerList.get(r).equals("Monk")){ list.add(new Monk(column,row));}
            else System.out.println("присутствует неверный класс!");
            row++;
        }
}

    public static void getListInfo(ArrayList<BaseUnit> list){
        int n=1;
        for (BaseUnit unit : list) {
            System.out.println(n+" "+unit.toString());
            n++;
        }
        System.out.println("----------------");
    } 
}
