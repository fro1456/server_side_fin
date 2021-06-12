package commands;
import сlasses.Dragon;
/**
 * Класс отвечает за выполнение команды удаления
 */

import java.util.*;
public class RemoveKeyCommand {
    /**
     * команда удаления
     * @param key
     * @param collection
     * @return
     */
    public static boolean remove(int key, HashMap<Long, Dragon> collection){
        collection.remove(key);
        return true;
    }


}
