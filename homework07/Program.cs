// See https://aka.ms/new-console-template for more information

class Program
{
    public static void Main (String[] args){
    Console.WriteLine("Start");
    
    
    int n=0;
     BattleField.start();
     ConsoleView.view();
        while ( n==0){
            
            string command=Console.ReadLine();
            if (command.Equals("q")) return;
            n=BattleField.nextStep();
            ConsoleView.view();
            if (n!=0) Console.WriteLine("Победила команда "+ n);
           
        }
    
  }

}