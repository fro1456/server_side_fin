package commands;
/**
 * класс выполняет команду Average of age
 */

import сlasses.Dragon;

import java.util.HashMap;
import java.util.Map;

public class AvarageOfAgeCommand {
    /**
     * Метод исполняющий avarageOfAge
     * @param collection
     */
    public static String avaregeOfAge(HashMap<Long, Dragon> collection){
        float age = 0;
        float count = 0;
        for(Map.Entry<Long, Dragon> pair : collection.entrySet()) {
            Dragon value = pair.getValue();
            age = age + value.getAge();
            count= count+1;
        }
        return ("среднее значение возраста: "+ age/count);
    }
}
