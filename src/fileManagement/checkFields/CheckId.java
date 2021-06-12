package fileManagement.checkFields;

import commands.CommandWorker;
import сlasses.Dragon;

import java.util.HashMap;
import java.util.Map;

/**
 * класс отвечает за проверку ID
 */

public class CheckId{
    public static boolean check = false;
    static Dragon dragon = new Dragon();
    static HashMap<Long,Dragon> collection= CommandWorker.collection;

    /**
     * Метод проверяющмй значения id
     * @param id
     * @return
     */
    public static boolean checkId(Long id){
        for (Map.Entry<Long, Dragon> element : collection.entrySet()){
            if (id == dragon.getID()){
                check = true;
                System.out.println("элементы совпадают");
            }
        }
        if (!check) {
            if (id > 0) {
                return true;
            } else {
                System.out.println("Вводимый элемент меньше нуля");
                return false;
            }
        }    return false;
    }

}
