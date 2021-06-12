import fileManagement.Deserializer;
import fileManagement.Input;
import fileManagement.Receiver;
import сlasses.*;
import com.google.gson.*;
import commands.CommandWorker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Класс Main, организуюзий выполнение программы
 */
public class Main {
    /**
     * Метод main
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        Coordinates coordinates = new Coordinates(300,20.5);
//        DragonHead dragonHead = new DragonHead(36.3F, 20.4F, 3.5);
//        Date den = new Date();
//        Gson roach = new Gson();
        System.out.println("server started");
        Receiver receiver = new Receiver();
        try {
            receiver.setConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //deserializer.read();

//        try (ServerSocket server = new ServerSocket(8000)) {
//            System.out.println("server started");
//            while (true)
//                try (
//                    Socket socket = server.accept();
//                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//                    BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));
//                ){
////                    InputStreamReader input = new InputStreamReader();
////                    System.out.println(request);
//                    String message = org.apache.commons.io.IOUtils.toString(reader);
//                    System.out.println("connected "+message);
////                    writer.write(request);
//                    writer.newLine();
//                    writer.flush();
//                } catch (NullPointerException e) {
//                    e.printStackTrace();
//                }
//
//        } catch (IOException e){
//            throw new RuntimeException(e);
//        }
//    }
        //CommandWorker commandWorker = new CommandWorker();
        //commandWorker.worker();

        //Dragon dragon = new Dragon(200,"Подкидыш",coordinates, den,30, Color.RED, DragonType.FIRE,DragonCharacter.CHAOTIC,dragonHead);
        //System.out.println(roach.toJson(dragon));

        //Input in = new Input();
        //try {
        //    in.FileInput();
        //} catch (IOException e) {
        //e.printStackTrace();
        //}
        //catch (NullPointerException e){
        //    System.out.println("Проверьте переменную окружения на Гелиосе!");
        //}

    }
}
