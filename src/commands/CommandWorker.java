package commands;

import fileManagement.Input;
import fileManagement.Receiver;
import fileManagement.checkFields.CheckId;
import сlasses.*;
/**
 * класс отвечает за выполнение программы
 */

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.*;

public class CommandWorker {
    private HistoryCommand historyCommand = new HistoryCommand();
    public static HashMap<Long, Dragon> collection = new HashMap<Long, Dragon>();
    public static Date creation_date = new Date();
    public String Array = "";
    //ExecuteScriptCommand executeScript = new ExecuteScriptCommand();
    public static Date save_date = null;
    public static AnswerClass messageToClient = new AnswerClass();


    //Receiver receiver = new Receiver();

    /**
     * Метод содержащий switch case, отвечающий за работу программы
     *
     * @throws IOException
     */
    public void worker(RequestedClass command) throws IOException {

        if (fileManagement.Input.FileInput()) {

            //save_date = null;
            //System.out.println("Введите команду");
//        Coordinates coordinates = new Coordinates(300,20.5);
//        DragonHead dragonHead = new DragonHead(36.3F, 20.4F, 3.5);
//        Date date = new Date();
//        Dragon dragon = new Dragon(200,"Драконыш",coordinates, date,30, Color.RED, DragonType.FIRE,DragonCharacter.CHAOTIC,dragonHead);
//
//        collection.put(1,dragon);
//        collection.put(2,dragon);
            //Scanner a = new Scanner(System.in);


            //String input = command.getCommandName().toLowerCase(Locale.ROOT);
            //command = input.split(" ");

            try {
                switch ((command.getCommandName())) {
                    case ("help"):
                        messageToClient.setMessage(HelpCommand.help());
                        historyCommand.historyRecorder(command.getCommandName());

                        break;
                    case ("info"):
                        messageToClient = new AnswerClass(InfoCommand.info());
                        historyCommand.historyRecorder(command.getCommandName());
                        break;
                    case ("show"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        for (Map.Entry<Long, Dragon> pair : collection.entrySet()) {
                            Dragon value = pair.getValue();
                            System.out.println(value);
                            Array += pair.getValue().toString() + "\n";
                            //System.out.println(pair.getKey());
                            messageToClient.setMessage(Array);
                        }
                        Array = "";
                        break;
                    case ("insert"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        RequestedClass requestedClass = new RequestedClass();

                        if ((command.getArgument() != null)) {
//                            Long addKey = Long.valueOf(((command.getCommand())[1]));
                            CheckId.checkId((command.getArgument()));
                            Dragon data = command.getDragon();
                            collection.put(command.getArgument(), command.getDragon());
                        } else {
                            System.err.println("формат ввода insert + id");
                        }
                        break;
                    case ("update_id"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        if ((command.getArgument() != null)) {
                            CheckId.checkId(command.getArgument());
                            switch (Integer.parseInt(String.valueOf(command.getArgument()))) {
                                case (1):
//                                    for (Map.Entry<Long, Dragon> pair1 : collection.entrySet()) {
//                                        Dragon value1 = pair1.getValue();
//                                        if (value1.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value1.setAge(dd.getAge());
//                                        }
//                                    }
                                    collection.keySet().stream()
                                            .filter(k->collection.get(k).getID() == command.getArgument())
                                            .forEach(key->collection.get(key)
                                                    .setAge(command.getDragon().getAge()));
                                    break;
                                case (2):
//                                    for (Map.Entry<Long, Dragon> pair2 : collection.entrySet()) {
//                                        Dragon value2 = pair2.getValue();
//                                        if (value2.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value2.setName(dd.getName());
//                                        }
//                                    }
                                    collection.keySet().stream()
                                            .filter(k->collection.get(k).getID() == command.getArgument())
                                            .forEach(key->collection.get(key)
                                                    .setName(command.getDragon().getName()));
                                    break;
                                case (3):
//                                    for (Map.Entry<Long, Dragon> pair3 : collection.entrySet()) {
//                                        Dragon value3 = pair3.getValue();
//                                        if (value3.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value3.setCoordinates(dd.getCoordinates());
//                                        }
//                                    }
                                    collection.keySet().stream()
                                            .filter(k->collection.get(k).getID() == command.getArgument())
                                            .forEach(key->collection.get(key)
                                                    .setCoordinates(command.getDragon().getCoordinates()));
                                    break;
                                case (4):
//                                    for (Map.Entry<Long, Dragon> pair3 : collection.entrySet()) {
//                                        Dragon value3 = pair3.getValue();
//                                        if (value3.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value3.setCoordinates(dd.getCoordinates());
//                                        }
//                                    }
                                case (5):
//                                    for (Map.Entry<Long, Dragon> pair5 : collection.entrySet()) {
//                                        Dragon value5 = pair5.getValue();
//                                        if (value5.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value5.setColor(dd.getColor());
//                                        }
//                                    }
                                    collection.keySet().stream()
                                            .filter(k->collection.get(k).getID() == command.getArgument())
                                            .forEach(key->collection.get(key)
                                                    .setColor(command.getDragon().getColor()));
                                case (6):
//                                    for (Map.Entry<Long, Dragon> pair6 : collection.entrySet()) {
//                                        Dragon value6 = pair6.getValue();
//                                        if (value6.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value6.setType(dd.getType());
//                                        }
//                                    }
                                    collection.keySet().stream()
                                            .filter(k->collection.get(k).getID() == command.getArgument())
                                            .forEach(key->collection.get(key)
                                                    .setType(command.getDragon().getType()));
                                case (7):
//                                    for (Map.Entry<Long, Dragon> pair7 : collection.entrySet()) {
//                                        Dragon value7 = pair7.getValue();
//                                        if (value7.getID() == command.getArgument()) {
//                                            Dragon dd = command.getDragon();
//                                            value7.setCharacter(dd.getCharacter());
//                                        }
//                                    }
                                    collection.keySet().stream()
                                            .filter(k->collection.get(k).getID() == command.getArgument())
                                            .forEach(key->collection.get(key)
                                                    .setCharacter(command.getDragon().getCharacter()));
                                case (8):
//                                    for (Map.Entry<Long, Dragon> pair8 : collection.entrySet()) {
//                                        Dragon value8 = pair8.getValue();
//                                        DragonHead value8h = value8.getHead();
//                                        if (value8.getID() == command.getArgument()) {
//                                            DragonHead dragonHead = command.getDragon().getHead();
//                                            value8h.setSize(dragonHead.getSize());
//                                        }
//                                    }
//                                    collection.keySet().stream()
//                                            .filter(k->collection.get(k).getID() == command.getArgument())
//                                            .forEach(key->collection.get(key)
//                                                    .setType(command.getDragon().getType()));
                                case (9):
//                                    for (Map.Entry<Long, Dragon> pair9 : collection.entrySet()) {
//                                        Dragon value9 = pair9.getValue();
//                                        DragonHead value9h = value9.getHead();
//                                        if (value9.getID() == command.getArgument()) {
//                                            DragonHead dragonHead = command.getDragon().getHead();
//                                            value9h.setEyesCount(dragonHead.getEyesCount());
//                                        }
//                                    }
                                case (10):
//                                    for (Map.Entry<Long, Dragon> pair10 : collection.entrySet()) {
//                                        Dragon value10 = pair10.getValue();
//                                        DragonHead value10h = value10.getHead();
//                                        if (value10.getID() == command.getArgument()) {
//                                            DragonHead dragonHead = command.getDragon().getHead();
//                                            value10h.setToothCount(dragonHead.getToothCount());
//                                        }
//                                    }

                            }


                            Long Key = Long.valueOf((command.getArgument()));
                            //UpdateIdCommand.updateId(Key);


                        } else {
                            System.err.println("формат ввода update_id + id");
                        }
                        break;
                    case ("remove_key"):
                        historyCommand.historyRecorder((command.getCommandName()));
//                        if ((command.getArgument()) != null) {
                        ;
                        Long key = command.getArgument();
                        try {
                            //System.out.println(collection);
//                            collection.remove(key);
                            //System.out.println(collection);
                            //collection.keySet().stream().filter(key->collection.get(key).getAge()<ageForDelete).collect(Collectors.toSet()).forEach(collection::remove);
                            List<Long> list = collection.keySet().stream().filter(k->k.equals(key))
                                    .collect(Collectors.toList());
                            System.out.println(list);
                            System.out.println(collection);
                            list.forEach(collection::remove);
                            SaveCommand.save(collection);
                            System.out.println(collection);
                            messageToClient.setMessage(collection.toString());


                        } catch (ConcurrentModificationException e) {
                            e.printStackTrace();
                        }
//                            for (Map.Entry<Long, Dragon> pair : collection.entrySet()) {
//                                Dragon value = pair.getValue();
//                                System.out.println(value);
//                                if (value.getID() == key) {
//                                    System.out.println("element v ife" + value);
//                                    System.out.println(key);
//                                    collection.remove(key,value);
//                                    System.out.println(collection.size());
//
//
//                                }//System.out.println();
//                            }

                        //System.out.println(collection);


                        //RemoveKeyCommand.remove(key, collection);
//                            messageToClient.setMessage("элемент " + key + " удален");
//                        } else {
//                            System.err.println("формат ввода remove_key + key");
//                        }

                        break;
                    case ("clear"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        System.out.println(collection);
                        collection.clear();
                        System.out.println(collection);
                        messageToClient.setMessage(valueOf(collection));
                        messageToClient.setMessage("коллекция отчищена");
                        break;
                    case ("save"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        SaveCommand.save(collection);
                        save_date = new Date();
                        messageToClient.setMessage("коллекция сохранена в файл");
                        break;
                    case ("execute_script"):
                        historyCommand.historyRecorder((command.getCommandName()));
//                            executeScript.Reading(command[1]);
                        break;
                    case ("exit"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        messageToClient.setMessage("программа завершена");
                        System.exit(0);
                    case ("remove_lower"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        if ((command.getArgument()) != null) {
                            Integer ageForDelete = Integer.parseInt(String.valueOf((command.getArgument())));
                            System.out.println("Удалнение драконов с возрастом меньшим чем данный");
                            RemoveLowerCommand.Remove(ageForDelete, collection);
                        } else {
                            System.err.println("формат ввода remove_lower + key");
                        }

                        break;
                    case ("history"):
                        System.out.println(historyCommand.historyViewer());
                        messageToClient.setMessage("вывод истории:" + historyCommand.historyViewer());
                        historyCommand.historyRecorder((command.getCommandName()));
                        //messageToClient.setMessage("я там");
                        break;
                    case ("replace_if_greater"):
                        if (command.getArgument() != null) {
                            Integer ageForReplacement = Integer.parseInt((command.getCommand())[1]);
                            ReplaceIfGreater.replaceGrater(ageForReplacement, collection);
                        } else {
                            System.err.println("формат ввода replace_if_greater + key");
                        }
                        historyCommand.historyRecorder((command.getCommandName()));
                        break;
                    case ("average_of_age"):
                        historyCommand.historyRecorder((command.getCommandName()));
                        messageToClient.setMessage(AvarageOfAgeCommand.avaregeOfAge(collection));
                        break;
                    case ("count_less_than_age"):
                        try {
                            historyCommand.historyRecorder((command.getCommandName()));
                            Integer ageForCounter = Integer.parseInt(String.valueOf((command.getArgument())));
                            messageToClient.setMessage(LessThenAgeCommand.CountLessThenCommand(ageForCounter, collection));
                        } catch (Exception e) {
                            messageToClient.setMessage("неверный формат команды");
                        }
                        break;
                    case ("filter_less_than_age"):
                        historyCommand.historyRecorder((command.getCommandName()));


                        if (command.getArgument() != null) {
                            Integer age = Integer.parseInt(String.valueOf((command.getArgument())));
                            messageToClient.setMessage(LessThenAgeCommand.LessThenCommand(age, collection));
                        } else {
                            System.err.println("формат ввода filter_less_than_age + key");
                        }


                        break;
                    default:
                        messageToClient = new AnswerClass("Попробуйте другую комманду" + "\n" +
                                "help-вывести справку о коммандах");
                }
                SaveCommand.save(collection);
            } catch (NumberFormatException e) {
                messageToClient.setMessage("Ошибка ввода данных");

            }
        }
        //System.out.println("Проверьте переменную окружения");
    }
}

