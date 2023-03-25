
package homework06.Units;

import homework06.Additional.Names;

import java.util.ArrayList;

public class Arbalester extends BaseUnit {

    protected int arrows;

    public Arbalester(String name, int x, int y) {
        super(name, x, y);
        this.attack = 6;
        this.defence = 3;
        this.damage[0] = 2;
        this.damage[1] = 3;
        this.hp = 10;
        this.maxHp = 10;
        this.speed = 4;
        this.className = "Арбалетчик";
        this.arrows = 8;
    }

    public Arbalester(int x, int y) {
        this(Names.getRandName(), x, y);
    }

    @Override
    public String toString() {
        String str = super.toString() + " стрел: " + this.arrows;
        return str;
    }

    @Override
    public void step (ArrayList<BaseUnit> friends,ArrayList<BaseUnit> ememies) {
        super.step(friends, ememies);
        if (!this.isAway){
            if (this.arrows<1){
            System.out.println( "У " +this.name+" закончились стрелы!" );
                if (!this.findPeasant(friends)){
                    System.out.println("Живых крестьян нет! "+this.name+" сбегает с поля боя! ");
                   this.isAway=true;
                   this.hp=0;
                };
                
            }
            else{
                int index=this.findTarget(ememies);
                if (index==-1){
                    System.out.println("Целей нет");
                }
                else this.shooting(ememies.get(index));
            }
        }

    }

    public int findTarget(ArrayList<BaseUnit> ememies) {
        int targetInd = -1;
        double distanse = 100;
        double minDistanse = 100;
        System.out.println(this.getName()+" ищет цель");
        for (int index = 0; index < ememies.size(); index++) {
            distanse = this.getDistanse(ememies.get(index));
            if (!ememies.get(index).isAway && distanse < minDistanse) {
                targetInd = index;
                minDistanse = distanse;
            }
        }
        return targetInd;
    }

    public boolean findPeasant(ArrayList<BaseUnit> friends) {
        boolean alifePeasants=false;
        for (int index = 0; index < friends.size(); index++) {
           
            BaseUnit unit = friends.get(index);
            if (!unit.isAway && unit.className.equals("Крестьянин")) {
                if (((Peasant) unit).delivery == true) {
                    ((Peasant) unit).deliveryArr();
                    this.arrows+=3;
                    return true;
                }
                else alifePeasants= true;
            }
           
        }
         if (alifePeasants) System.out.println("Свободных крестьян нет");
        return alifePeasants;
    
    }

    public void shooting(BaseUnit target) {
        if (this.arrows > 0) {
            this.arrows--;
            int damade;
            if (this.attack >= target.defence) {
                damade = this.damage[1];
            } else {
                damade = this.damage[0];
            }

            System.out.println(this.name + " стреляет в " + target.getName());
            target.getDamage(damade);
        }
    }

}
