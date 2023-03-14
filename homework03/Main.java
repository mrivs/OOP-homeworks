package homework03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import homework03.Comparators.SpeedComparator;
import homework03.Units.*;

/**
В материалы добавлены xml с полями и параметрами по умолчанию. Убедиться что все поля описанны. 
Создать в основной программе два списка. Положить в них по 10 случайных персонажей.

В первом только крестьянин, разбойник, снайпер или колдун. 

Во втором крестьянин, копейщик, арбалетчик, монах. 

Вывести в консоль информацию обо всех персонажах не зависимо от списка, очередь должна определяться скоростью каждого персонажа.

*Начать реализацию метода step у лучников.
1. Если жизнь равна нулю или стрел нет, завершить обработку.
2. Поиск среди противников наиболее приближённого.
3. Нанести среднее повреждение найденному противнику.
4. Найти среди своих крестьянина.
5. Если найден завершить метод иначе уменьшить запас стрел на одну.
Степ лучника будет доделовать на следующем саминаре!)
 */
public class Main {

    public static void main(String[] args) {
      
        ArrayList<BaseUnit> team1=new ArrayList<>();
        ArrayList<BaseUnit> team2=new ArrayList<>();

        fillSpecialHeroesList(team1, 10,"Peasant, Raider, Sniper, Wizard");
        fillSpecialHeroesList(team2, 10,"Peasant, Spearman, Arbalester, Monk ");
        
        team1.sort(new SpeedComparator());
        team2.sort(new SpeedComparator());

        System.out.println("Команда 1:");
        getListInfo(team1);
        System.out.println("Команда 2:");
        getListInfo(team2);

    }

    public static void fillListHeroes(ArrayList<BaseUnit> list,int size){
        Random rand = new Random();
        int r;
        
        for (int i = 0; i < size; i++) {
            r=rand.nextInt(1,8);
            switch (r){
            case 1: list.add(new Monk());
            break;
            case 2: list.add(new Arbalester());
            break;
            case 3: list.add(new Spearman());
            break;
            case 4: list.add(new Raider());
            break;
            case 5: list.add(new Sniper());
            break;
            case 6: list.add(new Wizard());
            break;
            case 7: list.add(new Peasant());
            break;

        }
    }
}

    public static void fillSpecialHeroesList(ArrayList<BaseUnit>list,int size,String classes) {
        classes=classes.replaceAll("\\s+","");
        ArrayList<String> HerList = new ArrayList<String>(Arrays.asList(classes.split(",")));
        Random rand = new Random();
        int r;
        
        for (int i = 0; i < size; i++) {
            r=rand.nextInt(0,HerList.size());
            if (HerList.get(r).equals("Peasant")){ list.add(new Peasant());}
            else if (HerList.get(r).equals("Arbalester")){ list.add(new Arbalester());}
            else if (HerList.get(r).equals("Spearman")){ list.add(new Spearman());}
            else if (HerList.get(r).equals("Raider")){ list.add(new Raider());}
            else if (HerList.get(r).equals("Sniper")){ list.add(new Sniper());}
            else if (HerList.get(r).equals("Wizard")){ list.add(new Wizard());}
            else if (HerList.get(r).equals("Monk")){ list.add(new Monk());}
            else System.out.println("присутствует неверный класс!");
            
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