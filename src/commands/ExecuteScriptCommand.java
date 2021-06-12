//package commands;
///**
// * В данном классе описывается работа Execute скрипта
// */
//
//import сlasses.Coordinates;
//import сlasses.Dragon;
//import сlasses.DragonHead;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.lang.reflect.Array;
//import java.util.*;
//import java.util.concurrent.ExecutionException;
//
//public class ExecuteScriptCommand {
//    private String fileName;
//    File file;
//    Commands commands;
//    CommandWorker commandWorker;
//    private ArrayList<String> command = new ArrayList<String>();
//    Scanner scanner;
//    String[] commandArray;
//    private static ArrayList<String> fileHistory = new ArrayList<String>();
//
//    //public ExecuteScript(String fileName,CommandWorker commandWorker,Commands  commands){
////    this.fileName=fileName;
////    this.commandWorker=commandWorker;
////    this.commands=commands;
////}
//
//    /**
//     *
//     * @param fileName
//     *
//     * @throws FileNotFoundException
//     */
//    public void Reading(String fileName) throws FileNotFoundException {
//        try {
//
//
//            this.file = new File(fileName);
//            Scanner scanner = new Scanner(file);
//            this.fileName = fileName;
//
//            while (scanner.hasNextLine()) {
//
//                command.add(scanner.nextLine());
//            }
//            worker();
//        }catch (FileNotFoundException e){
//            System.err.println("файл не найден");
//        }
//    }
//
//    /**
//     *конструкция switch case для чтения и обработки команд
//     */
//    private void worker() {
//        while (command.size() > 0) {
//
//            String[] comanndArray = command.get(0).toLowerCase().trim().split(" ");
//            //System.out.println(comanndArray);
//            switch (comanndArray[0]) {
//                case "help":
//                    if (checkCommndLine(0, comanndArray)) {
//                        break;
//                    }
//                    HelpCommand.help();
//                    break;
//                case "exit":
//                    if (checkCommndLine(0, comanndArray)) {
//                        break;
//                    }
//                    System.out.println("программа завершена");
//                    System.exit(0);
//                    break;
//                case "show":
//                    if (checkCommndLine(0, comanndArray)) {
//                        break;
//                    }
//                    for (Map.Entry<Long, Dragon> pair : CommandWorker.collection.entrySet()) {
//                        Dragon value = pair.getValue();
//                        System.out.println(value);
//                        break;
//                    }
//                    break;
//                case "remove_key":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    try {
//                        Integer.parseInt(comanndArray[1]);
//                        int RemoveKey = Integer.parseInt(comanndArray[1]);
//                        RemoveKeyCommand.remove(RemoveKey, CommandWorker.collection);
//                        break;
//                    } catch (NumberFormatException e) {
//                        new  Dragon().getStrings().add("ключ может принимать только целое числовое значение ");
//                    }
//                    break;
//                case "clear":
//                    if (checkCommndLine(0, comanndArray)) {
//                        break;
//                    }
//                    CommandWorker.collection.clear();
//                    System.out.println("коллекция отчищена");
//                    break;
//                case "history":
//                    if (checkCommndLine(0, comanndArray)) {
//                        break;
//                    }
//                    System.out.println("вывод истории:");
//                    HistoryCommand historyCommand = new HistoryCommand();
//                    historyCommand.historyViewer();
//                    break;
//                case "info":
//                    if (checkCommndLine(0, comanndArray)) {
//                        InfoCommand.info();
//                        break;
//                    }
//
//                    break;
//                case "insert":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    executeInsert(command, Long.parseLong(comanndArray[1]));
//
//                    break;
//                case "save":
//                    if (checkCommndLine(0, comanndArray)) {
//                        break;
//                    }
//                    SaveCommand.save(CommandWorker.collection);
//                    break;
//                case "update_id":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    executeUpdate(command,Long.parseLong(comanndArray[1]));
//                    break;
//                case "remove_lower":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    RemoveKeyCommand.remove(Integer.parseInt(comanndArray[1]), CommandWorker.collection);
//                    break;
//                case "replace_if_greater":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    ReplaceIfGreater.replaceGrater(Integer.parseInt(comanndArray[1]), CommandWorker.collection);
//                    break;
//                case "average_of_age":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    AvarageOfAgeCommand.avaregeOfAge(CommandWorker.collection);
//                    break;
//                case "count_less_then_age":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    LessThenAgeCommand.CountLessThenCommand(Integer.parseInt(comanndArray[1]), CommandWorker.collection);
//                    break;
//                case "filter_less_then_age":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    LessThenAgeCommand.LessThenCommand(Integer.parseInt(comanndArray[1]), CommandWorker.collection);
//                    break;
//                case "execute_script":
//                    if (checkCommndLine(1, comanndArray)) {
//                        break;
//                    }
//                    try {
//                        //System.out.println(fileName);
//                        //System.out.println(comanndArray[1]);
//                        //System.out.println("556");
//                        if (checkFileHistory(fileName)) {
//                            fileHistory.add(fileName);
//                            //System.out.println(fileHistory);
//                            if (command.size()!=0) {
//                                command.remove(0);
//                            }
//                            Reading(comanndArray[1]);
//                            worker();
//                            break;
//                        }else{
//                            System.err.println("файл уже был в работе");
//                            break;
//
//                        }
//
//
//                    } catch (FileNotFoundException e) {
//                        System.err.println("Не удалось найти файл");
//                        break;
//                        // e.printStackTrace();
//                    }
//                default:
//                    System.out.println("команды <" + comanndArray[0] + "> не существует ");
//                    break;
//            }
//            if (command.size()!=0){
//                command.remove(0);
//            }
//        }
//    }
//
//    /**
//     *Проверка аргумента
//     * @param arguments
//     * @param comanndLine
//     * @return
//     *
//     */
//    private boolean checkCommndLine(int arguments, String[] comanndLine) {
//        if (arguments != comanndLine.length - 1) {
//            System.out.println("Комманда" + comanndLine[0] + " принемает " + arguments + " аргумента");
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//
//    /**
//     *Проверка истории файла. Необходимо для того чтобы избежать рекурсии
//     * @param fileName
//     * @return
//     */
//    public boolean checkFileHistory(String fileName){
//        //System.out.println(fileName);
//        boolean check1 = true;
//        for (String i:
//             fileHistory) {
//            if (i.equals(fileName)){
//                check1= false;
//            }
//
//        }
//        return check1;
//    }
//
//    /**
//     * Реализация execute_script для Insert
//     * @param command
//     * @param key
//     */
//    public void executeInsert(ArrayList command, Long key) {
//        Dragon executeDragon = new Dragon();
//        if (CheckId.checkId(key)) {
//            executeDragon.setId(key);
//            //System.out.println("1");
//            if (CheckName.checkNameExecute((String) command.get(1), executeDragon)) {
//                //System.out.println(command.get(1));
//                if (CheckAge.checkAgeExecute((String) command.get(2), executeDragon)) {
//                    //System.out.println(command.get(2));
//                    if (CheckCoordinates.checkCoordinatesExecute(new Coordinates(), (String) command.get(3), (String) command.get(4))) {
//                        Coordinates coordinates = new Coordinates();
//                        coordinates.setX(Long.parseLong(String.valueOf(command.get(3))));
//                        coordinates.setY(Long.parseLong(String.valueOf(command.get(4))));
//                        executeDragon.setCoordinates(coordinates);
//                        executeDragon.setCreationDate(new Date());
//
//                        //System.out.println(command.get(3));
//                        if (CheckColor.checkColorExecute((String) command.get(5), executeDragon)) {
//                            //System.out.println(command.get(4));
//                            if (CheckCharacter.checkCharacterExecute((String) command.get(6), executeDragon)) {
//                                //System.out.println(command.get(5));
//                                if (CheckType.checkTypeExecute((String) command.get(7), executeDragon)) {
//                                    //System.out.println(command.get(6));
//                                    if (CheckHead.checkEyesExecute(new DragonHead(), (String) command.get(8))) {
//                                        DragonHead dragonHead = new DragonHead();
//                                        dragonHead.setEyesCount(Float.parseFloat(String.valueOf(command.get(8))));
//                                        //System.out.println(command.get(7));
//                                        if (CheckHead.checkSizeExecute(new DragonHead(), (String) command.get(9))) {
//                                            dragonHead.setSize(Float.parseFloat(String.valueOf(command.get(9))));
//                                            //System.out.println(command.get(8));
//                                            if (CheckHead.checkToothExecute(new DragonHead(), (String) command.get(10))) {
//                                                dragonHead.setToothCount(Double.parseDouble(String.valueOf(command.get(10))));
//                                                executeDragon.setHead(dragonHead);
//                                                //System.out.println(command.get(10));
//                                                System.out.println("Элемент успешно добавлен в коллекцию");
//                                                CommandWorker.collection.put(executeDragon.getID(), executeDragon);
//                                                for (int i = 10; i > 0; i--) {
//                                                    command.remove(1);
//                                                }
//
//                                            }
//                                        } else {
//                                            for (int i = 10; i > 0; i--) {
//                                                command.remove(1);
//                                            }
//                                        }
//
//                                    } else {
//                                        for (int i = 9; i > 0; i--) {
//                                            command.remove(1);
//                                        }
//                                    }
//
//                                } else {
//                                    remover(7, command);
//                                }
//
//                            } else {
//                                remover(6, command);
//                            }
//
//                        } else {
//                            remover(5, command);
//                        }
//
//                    } else {
//                        remover(4, command);
//                    }
//                } else {
//                    remover(3, command);
//                }
//            } else {
//                remover(2, command);
//            }
//
//        } else {
//            remover(1, command);
//        }
//    }
//
//    /**
//     * Команда Update для execute_script
//     * @param command
//     * @param key
//     */
//    public void executeUpdate(ArrayList command, Long key){
//        //System.out.println(CommandWorker.collection.get(14));
//        //System.out.println(command);
//        //System.out.println(key);
//        Dragon dragon;
//        dragon=CommandWorker.collection.get(key);
//        if (dragon==null){
//            System.err.println("Дракона с таким именем не существует");
//        }else{
//            System.out.println("Напоминаю о том какие id имеют поля");
//            System.out.println("1-age");
//            System.out.println("2-name");
//            System.out.println("3-coordinates");
//            System.out.println("4-age");
//            System.out.println("5-Color");
//            System.out.println("6-Type");
//            System.out.println("7-Character");
//            System.out.println("8-Size");
//            System.out.println("9-eyesCount");
//            System.out.println("10-ToothCount");
//            switch (command.get(1).toString()){
//                case("1"):
//                    CheckAge.checkAgeExecute(command.get(2).toString(),dragon);
//                    command.remove(2);
//                    break;
//                case("2"):
//                    CheckName.checkNameExecute(command.get(2).toString(),dragon);
//                    command.remove(2);
//                    break;
//                case("3"):
//                    CheckCoordinates.checkCoordinatesExecute(new Coordinates(),(String)command.get(2),(String)command.get(3));
////                    dragon.setCoordinates(new Coordinates(command.get(2)), (double)command.get(3)));
//                    Coordinates coordinates = new Coordinates();
//                    coordinates.setX(Long.parseLong((String)command.get(2)));
//                    coordinates.setY(Double.parseDouble((String)command.get(3)));
//                    dragon.setCoordinates(coordinates);
//                    command.remove(3);
//                    command.remove(2);
//                    break;
//                case("4"):
//                    CheckAge.checkAgeExecute(command.get(2).toString(),dragon);
//                    command.remove(2);
//                    break;
//                case("5"):
//                    CheckColor.checkColorExecute(command.get(2).toString(),dragon);
//                    command.remove(2);
//                    break;
//                case("6"):
//                    CheckType.checkTypeExecute(command.get(2).toString(),dragon);
//                    command.remove(2);
//                    break;
//                case("7"):
//                    CheckCharacter.checkCharacterExecute(command.get(2).toString(),dragon);
//                    command.remove(2);
//                    break;
//                case("8"):
//                    CheckHead.checkSizeExecute(new DragonHead(),command.get(2).toString());
//                    command.remove(2);
//                    break;
//                case("9"):
//                    CheckHead.checkEyesExecute(new DragonHead(),command.get(2).toString());
//                    command.remove(2);
//                    break;
//                case("10"):
//                    CheckHead.checkToothExecute(new DragonHead(),command.get(2).toString());
//                    break;
//            }
//            command.remove(0);
//            command.remove(0);
//        }
//    }
//
//    /**
//     * Метод для удаления элементов
//     * @param x
//     * @param command
//     */
//    public void remover(int x, ArrayList command) {
//        while (x > 0) {
//            command.remove(1);
//            x--;
//        }
//
//    }
//
//
//
//}
//
