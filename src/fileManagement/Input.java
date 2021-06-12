package fileManagement;
/**
 * Класс организующий работу с файлом
 */

import org.apache.commons.io.*;
import сlasses.Dragon;
import com.google.gson.*;
import commands.CommandWorker;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Input {
    /**
     * Реализация работы с файлом
     * @throws IOException
     */
    public static boolean FileInput() throws IOException {
        /*InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:/Users/PREDATOR/IdeaProjects/untitled1/src/data/inputData.json"));
        new InputStreamReader(System.in);
        while (true){
             x = inputStreamReader.read();
            System.out.println(x);

        }*/

        FileInputStream fis = null;
        InputStreamReader isr = null;
        long r = 0;
        try {
            String homedir = System.getenv("LAB_PATH");
            //System.out.println(homedir);
            fis = new FileInputStream(homedir);
            isr = new InputStreamReader(fis, "UTF-8");
            String res = IOUtils.toString(fis, StandardCharsets.UTF_8);
            String[] str = res.split("\n");
            Gson gson = new Gson();
            String n = null;
            for (String p : str) {
                n = p.trim();

            }
            if (n.length()!=0){
                for (String p : str) {
                    //System.out.println(p);
                    Dragon result = gson.fromJson(p,Dragon.class);
                    CommandWorker.collection.put(result.getID(),result);
                    r=r+1;
                }
            }
            return true;

        } catch (FileNotFoundException e) {
            System.err.println("файл не найден");
            return false;
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
            return false;
            //e.printStackTrace();

        } catch (JsonSyntaxException e ){
            System.err.println("Не удалось получить доступ к файлу!!!! Проверьте есть ли у вас доступ");
            return false;
        } catch (NullPointerException e){
            System.err.println("Переменная окружения не найдена. Экспортируйте пременную на Гелиосе");
            return false;
        }
        //finally {
            //fis.close();
            //isr.close();
        //}


    }
}


