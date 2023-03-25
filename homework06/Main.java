package homework06;
import java.util.Scanner;

import homework06.Additional.BattleField;

/**
Реализовать степ для пехоты по семинару.

 */
public class Main {
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //System.out.println("homework06"); 
    int n=0;
     BattleField.start();
     ConsoleView.view();
        while ( n==0){
            String command=sc.nextLine();
            if (command.equals("q")) return;
            n=BattleField.nextStep();
            ConsoleView.view();
            if (n!=0) System.out.println("Победила команда "+ n);
           
        }

    }
}