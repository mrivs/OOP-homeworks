
package homework03.Units;
import homework03.Names;



public class Arbalester extends BaseUnit {

    protected int arrows;
    
    public Arbalester(String name) {
        super(name);
        this.attack=6;
        this.defence=3;
        this.damage[0]=2;
        this.damage[1]=3;
        this.hp=10;
        this.maxHp=10;
        this.speed=4;
        this.className="Арбалетчик";
        this.arrows=16;
    }

    public Arbalester() {
        this(Names.getRandName());
    }


     public void shooting(BaseUnit target){
         if (this.arrows>0){
         this.arrows--;
         int damade;
         if (this.attack>=target.defence) {damade=this.damage[1];} 
         else {damade=this.damage[0];}  

         System.out.println(this.name+" стреляет в "+target.getName());
         target.getDamage(damade);
        }}

    
    @Override
    public String toString() {
        String str=super.toString()+ " стрел: "+this.arrows;
        return str;
    }
// *Начать реализацию метода step у лучников.
// 1. Если жизнь равна нулю или стрел нет, завершить обработку.
// 2. Поиск среди противников наиболее приближённого.
// 3. Нанести среднее повреждение найденному противнику.
// 4. Найти среди своих крестьянина.
// 5. Если найден завершить метод иначе уменьшить запас стрел на одну.
// Степ лучника будет доделовать на следующем саминаре!)
//  */
    @Override
    public void step() {
        
        if (this.hp==0 ) return;
        else if (this.arrows==0) {
            //findFreePeasant();
        }
        else{
        //  findClTarget(team);
        //  shooting(findClTarget(team));
        }

    }

    


    
}
