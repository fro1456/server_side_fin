package commands;
/**
 * Класс отвечающий за команду history
 */

import java.util.*;

public class HistoryCommand {
    int counter = 0;

    private LinkedHashMap<Integer, String> history = new LinkedHashMap<Integer, String>();

    /**
     * Метод просмотра истории
     * @return
     */
    public String historyViewer(){
        StringBuilder stringBuilder = new StringBuilder();
        history.values().stream().limit(12).forEach(x->stringBuilder.append(x).append("\n"));
        return stringBuilder.toString();
//        for (int i= counter;i>= counter-12;i--){
//            if (history.get(i) != null){
//                return(history.get(i));
//            }
//        }
    }

    /**
     * Метод записи истории
     * @param command
     */
    public void historyRecorder(String command){
        //System.out.println(history);
        counter = counter + 1;
        history.put(counter,command);
        if (counter>12){
            history.remove(counter-12);
        }

    }

}
