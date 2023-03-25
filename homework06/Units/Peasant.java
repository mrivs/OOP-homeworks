package homework06.Units;

import homework06.Additional.Names;
import java.util.ArrayList;

public class Peasant extends BaseUnit {

    public boolean delivery;

    public Peasant(String name, int x, int y) {
        super(name, x, y);
        this.attack = 1;
        this.defence = 1;
        this.damage[0] = 1;
        this.damage[1] = 1;
        this.hp = 1;
        this.maxHp = 1;
        this.speed = 3;
        this.className = "Крестьянин";
        this.delivery = true;
    }

    public Peasant(int x, int y) {
        this(Names.getRandName(), x, y);
    }

    void deliveryArr() {
        System.out.println(this.name + " доставляет стрелы");
        this.delivery = false;
    }

    @Override
    public void step(ArrayList<BaseUnit> friends, ArrayList<BaseUnit> enemies) {

        super.step(friends, enemies);
        if (!checkAlifeUnits(friends)) {
            System.out.println(this.name + " сбегает с поля боя!");
            this.isAway = true;
            this.hp=0;
            return;
        } else {
            if (this.delivery == false) {
                this.delivery = true;
                System.out.println(this.name + " снова готов нести стрелы..");
            } else
                System.out.println(this.name + " ждет...");

        }
    }

    boolean checkAlifeUnits(ArrayList<BaseUnit> friends) {
        boolean stayInBattle = false;
        for (BaseUnit unit : friends) {

            if (unit.isAway == false && !unit.className.equals("Крестьянин"))
                stayInBattle = true;
            
        }
        return stayInBattle;
    }

}
