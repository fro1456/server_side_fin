package commands;
/**
 * Класс для выполнения RemoveLower
 */

import сlasses.Dragon;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveLowerCommand {
    /**
     * метод для выполнения remove
     * @param ageForDelete
     * @param collection
     */
    public static void Remove(int ageForDelete, HashMap<Long, Dragon> collection) {
//        for (Map.Entry<Long, Dragon> pair : collection.entrySet()) {
//            Dragon value = pair.getValue();
//            if (value.getAge() < ageForDelete) {
//                collection.remove(pair.getKey());
//            }
//        }
        collection.keySet().stream().filter(key->collection.get(key).getAge()<ageForDelete).collect(Collectors.toSet()).forEach(collection::remove);


    }
}

