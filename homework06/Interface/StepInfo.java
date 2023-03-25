package homework06.Interface;
import homework06.Units.BaseUnit;
import java.util.ArrayList;





//import Units.BaseUnit;

public interface StepInfo {

      /**
   * @param step     шаг
   * @param getInfo  информация о классе
   * 
   */

    public void step(ArrayList <BaseUnit> friends,ArrayList <BaseUnit> enemies);
    public String getInfo();
   
}
