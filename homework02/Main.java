package homework02;

import java.util.ArrayList;
import java.util.Random;
import homework02.Units.*;

/**
Добавить файл с описанием интерфейса.
В котором описать два метода, void step(); 
и String getInfo(); Реализовать интерфейс в абстрактном классе и в наследниках так,
чтобы getInfo возвращал тип персонажа. Создать два списка в классе main. 
В каждый из списков добавить по десять экземпляров наследников BaseHero (BaseUnit).
Удалить ненужные методы из абстрактного класса, если такие есть. В main пройти по спискам и вызвать у всех персонажей getInfo.
 */
public class Main {

    public static void main(String[] args) {
      
        ArrayList<BaseUnit> team1=new ArrayList<>();
        ArrayList<BaseUnit> team2=new ArrayList<>();

        fillListHeroes(team1, 10);
        fillListHeroes(team2, 10);
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
            case 7: list.add(new Farmer());
            break;

        }
    }
}
    public static void getListInfo(ArrayList<BaseUnit> list){
        for (BaseUnit unit : list) {
            System.out.println(unit.getInfo());
            
        }
        System.out.println("----------------");
    }
}