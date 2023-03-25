package homework06.Units;

import java.util.ArrayList;

import homework06.Additional.BattleField;

public abstract class Infantry extends BaseUnit {

    public Infantry(String name, int x, int y) {
        super(name, x, y);
        this.className="Пехота"; 
    }

    public Infantry(int x, int y) {
        super(x, y);
        this.className="Пехота"; 
    }

    @Override
    public void step(ArrayList<BaseUnit> friends, ArrayList<BaseUnit> enemies) {
        
        super.step(friends, enemies);
          if (!this.isAway){

                int index=this.findTarget(enemies);
                if (index==-1){
                    System.out.println("Целей нет");
                }
                else {
                    if (this.getDistanse(enemies.get(index))>1.42){
                        this.moving(enemies.get(index));
                    }
                    else{
                        this.baseAttack(enemies.get(index));
                    }

                }
                
        }
    }

    public void baseAttack(BaseUnit target) {
        
            int damade;
            if (this.attack >= target.defence) {
                damade = this.damage[1];
            } else {
                damade = this.damage[0];
            }
            System.out.println(this.name + " атакует " + target.getName());
            target.getDamage(damade);
        
    }
    public int findTarget(ArrayList<BaseUnit> ememies) {
        int targetInd = -1;
        double distanse = 100;
        double minDistanse = 100;
        
        for (int index = 0; index < ememies.size(); index++) {
            distanse = this.getDistanse(ememies.get(index));
            if (!ememies.get(index).isAway && distanse < minDistanse) {
                targetInd = index;
                minDistanse = distanse;
            }
        }
        return targetInd;
    }
    public void moving(BaseUnit target){
        System.out.println( this.name +" идет к противнику " +target.name);
        int x1=this.position.getX();
        int x2=target.position.getX();
        int y1=this.position.getY();
        int y2=target.position.getY();

        if (Math.abs(x1-x2)>Math.abs(y2-y1)){
            if (x1>x2){
                if(BattleField.checkDeskPosition(x1-1,y1))
                this.position.moveLeft();
                else System.out.println("путь прегражден");
            }
            else {
                if(BattleField.checkDeskPosition(x1+1,y1))
                this.position.moveRight();
                else System.out.println("путь прегражден");
                } 
        }
        else {
            if (y1>y2){
                if(BattleField.checkDeskPosition(x1,y1-1))
                this.position.moveDown();
                else System.out.println("путь прегражден");
            }
            else {
                if(BattleField.checkDeskPosition(x1,y1+1))
                this.position.moveUp();
                else System.out.println("путь прегражден");
            } 
        }
    }
    
}
