package commands;

import сlasses.Dragon;
/**
 * Класс отвечает за команду ReplaceIfGreater
 */

import java.util.HashMap;
import java.util.Map;

public class ReplaceIfGreater {
    /**
     * Метод отвечает за работу команды ReplaceGreater
     * @param greaterAge
     * @param collection
     */
    public static void replaceGrater(int greaterAge, HashMap<Long, Dragon> collection){
        System.out.println("Проверка и замена значения возраста");
            for (Map.Entry<Long, Dragon> pair : collection.entrySet()) {
                Dragon value = pair.getValue();
                if (value.getAge() < greaterAge) {
                    value.setAge(greaterAge);
                }
                else{
                    System.out.println("введеное значение возраста меньше");
                }


        }

    }
}
