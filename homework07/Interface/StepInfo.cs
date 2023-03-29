
using homework07.Interface;

//import Units.BaseUnit;

public interface StepInfo {

      /**
   * @param step     шаг
   * @param getInfo  информация о классе
   * 
   */

    public void step(List <BaseUnit> friends, List <BaseUnit>   enemies);
    public string getInfo();
   
}
