package homework01;

import homework01.Units.*;

/**
 * Крестьянин, разбойник, снайпер, колдун, копейщик, арбалетчик, монах. 
 * Для каждого сформировать список свойств и возможных действий. 
 * Например свойство скорость, действие нанести удар. 
 * Проанализировать получившиеся свойства и действия персонажей и создать Обобщённый класс
 * описывающий свойства и действия имеющиеся у всех персонажей.
 * Создать этот класс. 
 * Создать классы для каждого типа персонажей наследующие и расширяющие абстрактный(обобщённый) класс. 
 * В основной программе создать по одному экземпляру каждого типа персонажей.
 * Main
 */
public class Main {

    public static void main(String[] args) {
        BaseUnit farm1=new Farmer();
        BaseUnit farm2=new Farmer("Vasya",110);
        BaseUnit arb1=new Arbalester();
        Sniper sniper1=new Sniper();    
        Monk monk1=new Monk();
        Raider raider1=new Raider();
        Spearman spearman1=new Spearman();
        Wizard wiz1=new Wizard();

        farm2.waiting();
        ((Farmer) farm1).working();
        
        
        raider1.daggerStrike(sniper1);
        System.out.println( sniper1.getInfo());
        monk1.Healing(sniper1);
        System.out.println( sniper1.getInfo());
    }
}