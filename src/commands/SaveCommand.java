package commands;

import сlasses.Dragon;
import com.google.gson.*;
/**
 * класс выполняет сохранение коллекции
 */
import java.io.*;
import java.util.HashMap;
import java.util.*;
public class SaveCommand {
    /**
     * Метод для работы ком
     * @param collection
     */
    public static void save(HashMap<Long, Dragon> collection){
        Gson gson = new Gson();
        File file = new File(System.getenv("LAB_PATH"));
        PrintWriter delete = null;
        try {
            delete = new PrintWriter(file);
            delete.print("");
            delete.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Long, Dragon> pair : collection.entrySet())
        {
            Dragon dragon=collection.get(pair.getKey());
            String colectJson=gson.toJson(dragon);
//            System.out.println(colectJson);

            try (PrintWriter pw = new PrintWriter(new FileWriter(file,true))) {

//                System.out.println(colectJson);
                pw.println(colectJson);
                pw.close();


            } catch (FileNotFoundException e) {
                System.out.println("Ошибка:");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}