
package homework04.Units;

import homework04.Additional.Names;

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
        this.arrows = 16;
    }

    public Arbalester(int x, int y) {
        this(Names.getRandName(), x, y);
    }

    @Override
    public String toString() {
        String str = super.toString() + " стрел: " + this.arrows;
        return str;
    }

    //
    // Реализовать метод step() лучников.
    // 3.1 Если жизнь равна нулю или стрел нет, завершить обработку.
    // 3.2 Поиск среди противников наиболее приближённого.
    // 3.3 Нанести среднее повреждение найденному противнику.
    // 3.4 Найти среди своих крестьянина.
    // 3.5 Если найден завершить метод иначе уменьшить запас стрел на одну.
    // */

    @Override
    public void step (ArrayList<BaseUnit> friends,ArrayList<BaseUnit> ememies) {
        super.step(friends, ememies);
        if (!this.isDead){
            if (this.arrows<1){

                this.findPeasant(friends);
                return;
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
            //System.out.println(distanse+ " "+ememies.get(index).getName() );
            if (!ememies.get(index).isDead && distanse < minDistanse) {
                targetInd = index;
                minDistanse = distanse;
            }
        }
        return targetInd;
    }

    public void findPeasant(ArrayList<BaseUnit> friends) {
        for (int index = 0; index < friends.size(); index++) {
            BaseUnit unit = friends.get(index);
            // if (!friends.get(index).isDead &&
            // friends.get(index).className.equals("Крестьянин")) {
            // if (((Peasant)friends.get(index)).delivery==true){
            // }
            if (!unit.isDead && unit.className.equals("Крестьянин")) {
                if (((Peasant) unit).delivery == true) {
                    ((Peasant) unit).deliveryArr();
                    this.arrows+=3;
                    return;
                }
            }  
        }
    System.out.println("свободных крестьян нет");
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
