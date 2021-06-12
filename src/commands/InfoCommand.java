package commands;
/**
 * класс отвечающий за Info
 */

import сlasses.Dragon;

import java.util.Date;

public class InfoCommand {
    /**
     * Метод отвечающий за вывод информации о количестве элементов
     */
    public static String info(){
        if(CommandWorker.save_date==null){
            return ("колличество элементов в коллекции "+ CommandWorker.collection.size()+"\nДата загрузки "+ CommandWorker.creation_date+"\nсохранения коллеции в файл не происходило");
        }
        else{

            return ("колличество элементов в коллекции "+ CommandWorker.collection.size()+"\nДата загрузки "+ CommandWorker.creation_date+"\n дата последнего созранения "+CommandWorker.save_date);
        }
    }
}
