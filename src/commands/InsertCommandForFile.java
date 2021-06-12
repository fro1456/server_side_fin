    //pack HashMap;
//import java.util.Scanner;
//
//public class InsertCommandForFile {
//    public static void insert(HashMap<Long,Dragon> collection, Long key) {
//
//        Dragon dragon = new Dragon();
//        dragon.setId(key);
//        if(CheckId.checkId(key)) {
//            ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand();
//            executeScriptCommand.Reading();
//            String name;
//            int age;
//            int parseId;
//            while (true) {
////                System.out.println("введите имя");
////                name = scanner.nextLine();
//                while (!CheckName.check) {
//                    CheckName.checkName(dragon);
//                }
//
//                //dragon.setName(name);
//                //System.out.println("введите возраст");
//                //age = scanner.nextInt();
//                while (!CheckAge.check) {
//                    CheckAge.checkAge(dragon);
//                }
//                //CheckAge.check=false;
//                Coordinates coordinates = new Coordinates();
//                while (!CheckCoordinates.check) {
//                    CheckCoordinates.checkCoordinates(coordinates);
//                }
//                dragon.setCoordinates(coordinates);
//                //CheckCoordinates.check=false;
//                dragon.setCreationDate(new Date());
//                System.out.println("Дата создания установленна " + dragon.getCreationDate());
//                while (!CheckColor.check) {
//                    CheckColor.checkColor(dragon);
//                }
//                while (!CheckCharacter.check) {
//                    CheckCharacter.checkCharacter(dragon);
//                }
//                while (!CheckType.check) {
//                    CheckType.checkType(dragon);
//                }
//                try {
//
//                    System.out.println("Создание головы" + "(ограничения по вводимым данным отсутствуют)");
//                    DragonHead dragonHead = new DragonHead();
//                    // //System.out.println("введите количество глаз");
//                    //String s=scanner.nextLine();
////    try {
////        int l=Integer.parseInt(s);
////    }catch (NumberFormatException e){
////        int l;
////    }
//                    while (!CheckHead.check1){
//                        CheckHead.checkEyes(dragonHead);
//                    }
//                    while (!CheckHead.check2){
//                        CheckHead.checkSize(dragonHead);
//                    }
//                    while (!CheckHead.check3){
//                        CheckHead.checkTooth(dragonHead);
//                    }
////    System.out.println("введите размер головы");
////    dragonHead.setSize(Float.parseFloat(scanner.nextLine()));
////    System.out.println("Введите количество зубов");
////    dragonHead.setToothCount(Double.parseDouble(scanner.nextLine()));
//
//                    dragon.setHead(dragonHead);
//
//                    System.out.println("Начинаем добавлять в колекцию");
//                    System.out.println(dragon);
//                    collection.put(dragon.getID(), dragon);
//                    System.out.println("Вроде добавили");
//                    break;
//                }catch (NumberFormatException r){
//
//                }
//
//            }
//        } else {
//            System.err.println("ID некорректен!");
//        }
//    }
//}
