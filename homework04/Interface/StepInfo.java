package homework04.Interface;

import java.util.ArrayList;

import homework04.Units.BaseUnit;



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
