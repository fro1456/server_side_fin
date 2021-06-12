    package commands;

    import сlasses.Dragon;
    /**
     * данный класс отвечает за команду LessThanAge
     */

    import java.util.HashMap;
    import java.util.Map;

    public class LessThenAgeCommand {
        /**
         * Метод отвечает за команду LessThenAge
         *
         * @param num
         * @param collection
         */
        public static String LessThenCommand(int num, HashMap<Long, Dragon> collection) {
            for (Map.Entry<Long, Dragon> pair : collection.entrySet()) {
                Dragon value = pair.getValue();
                if (value.getAge() < num) {
                    return String.valueOf(((value)));
                }
            }return null;
        }


        /**
         * Команда отвечает за подсчет элементов меньше чем возраст
         * @param num
         * @param collection
         */
        public static String CountLessThenCommand(int num, HashMap<Long, Dragon> collection){
            int count =0;
            for(Map.Entry<Long, Dragon> pair : collection.entrySet())
            {
                Dragon value = pair.getValue();
                if (value.getAge()<num){
                    count = count + 1;
                }
            }
            return String.valueOf((count));
        }
    }
