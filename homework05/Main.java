package homework05;
import java.util.Scanner;

import homework05.Additional.BattleField;

/**
Реализовать псевдо графику используя приложенные в документах занятия файлы. (chcp 65001)
Распределить функционал основной программы по методам в соответствии с SOLID.
Используя класс сканер реализовать повторение хода в основной программе.

 */
public class Main {
    public static final int GANG_SIZE = 0;

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //System.out.println("homework05"); 
     int q=0; 
     BattleField.start();
     ConsoleView.view();
        while (true){
            String command=sc.nextLine();
            if (command.equals("q")) return;
            BattleField.nextStep();
            ConsoleView.view();
            q=1;
        }

    }
}